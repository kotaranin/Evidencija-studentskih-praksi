package baza;

import domen.Dnevnik;
import domen.Fakultet;
import domen.StavkaDnevnika;
import domen.Student;
import domen.Zadatak;
import domen.Zaposleni;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Broker {

    public Zaposleni ulogujSe(String email, String lozinka) {
        String upit = "SELECT * FROM zaposleni WHERE email = ? AND lozinka = ?";

        try {
            PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(upit);
            ps.setString(1, email);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Zaposleni ulogovaniZaposleni = new Zaposleni();

                ulogovaniZaposleni.setIdZaposleni(rs.getLong("id_zaposleni"));
                ulogovaniZaposleni.setIme(rs.getString("ime"));
                ulogovaniZaposleni.setPrezime(rs.getString("prezime"));
                ulogovaniZaposleni.setTelefon(rs.getString("telefon"));
                ulogovaniZaposleni.setEmail(email);
                ulogovaniZaposleni.setLozinka(lozinka);

                return ulogovaniZaposleni;
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Dnevnik> vratiDnevnike(String[] kriterijum) {
        List<Dnevnik> dnevnici = new ArrayList<>();

        String upit = "SELECT * FROM dnevnik d "
                + "JOIN zaposleni z ON d.id_zaposleni = z.id_zaposleni "
                + "JOIN student s ON d.id_student = s.id_student "
                + "JOIN fakultet f ON s.id_fakultet = f.id_fakultet ";

        if (kriterijum != null && !kriterijum[0].isEmpty()) {
            if (kriterijum.length == 1) {
                upit += "WHERE LOWER(s.ime) LIKE ? OR LOWER(s.prezime) LIKE ? OR LOWER(z.ime) LIKE ? OR LOWER(z.prezime) LIKE ? ";
            } else {
                upit += "WHERE (LOWER(s.ime) LIKE ? AND LOWER(s.prezime) LIKE ?) OR (LOWER(z.ime) LIKE ? AND LOWER(z.prezime) LIKE ?) ";
            }
        }

        try {
            PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(upit);
            if (kriterijum != null && !kriterijum[0].isEmpty()) {
                ps.setString(1, "%" + kriterijum[0] + "%");
                ps.setString(2, "%" + kriterijum[0] + "%");
                ps.setString(3, "%" + kriterijum[0] + "%");
                ps.setString(4, "%" + kriterijum[0] + "%");
                if (kriterijum.length > 1) {
                    ps.setString(2, "%" + kriterijum[1] + "%");
                    ps.setString(4, "%" + kriterijum[1] + "%");
                }
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dnevnik dnevnik = new Dnevnik();
                Zaposleni zaposleni = new Zaposleni();
                Fakultet fakultet = new Fakultet();
                Student student = new Student();

                zaposleni.setIdZaposleni(rs.getLong("z.id_zaposleni"));
                zaposleni.setIme(rs.getString("z.ime"));
                zaposleni.setPrezime(rs.getString("z.prezime"));
                zaposleni.setTelefon(rs.getString("z.telefon"));
                zaposleni.setEmail(rs.getString("z.email"));
                zaposleni.setLozinka(rs.getString("z.lozinka"));

                fakultet.setIdFakultet(rs.getLong("f.id_fakultet"));
                fakultet.setNaziv(rs.getString("f.naziv"));
                fakultet.setAdresa(rs.getString("f.adresa"));

                student.setIdStudent(rs.getLong("s.id_student"));
                student.setIme(rs.getString("s.ime"));
                student.setPrezime(rs.getString("s.prezime"));
                student.setBrojIndeksa(rs.getString("s.broj_indeksa"));
                student.setFakultet(fakultet);

                dnevnik.setIdDnevnik(rs.getLong("d.id_dnevnik"));
                dnevnik.setUkupnoTrajanje(rs.getInt("d.ukupno_trajanje"));
                dnevnik.setMisljenjeKompanije(rs.getString("d.misljenje_kompanije"));
                dnevnik.setOcena(rs.getInt("d.ocena"));
                dnevnik.setDatumIzdavanja(LocalDate.parse(rs.getString("d.datum_izdavanja")));
                dnevnik.setZaposleni(zaposleni);
                dnevnik.setStudent(student);
                dnevnik.setStavke(vratiStavke(dnevnik));

                dnevnici.add(dnevnik);
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dnevnici;
    }

    public List<Student> vratiStudente() {
        List<Student> studenti = new ArrayList<>();

        String upit = "SELECT * FROM student s JOIN fakultet f ON s.id_fakultet = f.id_fakultet ";

        try {
            Statement s = Konekcija.getInstanca().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                Student student = new Student();
                Fakultet fakultet = new Fakultet();

                fakultet.setIdFakultet(rs.getLong("f.id_fakultet"));
                fakultet.setNaziv(rs.getString("f.naziv"));
                fakultet.setAdresa(rs.getString("f.adresa"));

                student.setIdStudent(rs.getLong("s.id_student"));
                student.setBrojIndeksa(rs.getString("s.broj_indeksa"));
                student.setIme(rs.getString("s.ime"));
                student.setPrezime(rs.getString("s.prezime"));
                student.setFakultet(fakultet);

                studenti.add(student);
            }

            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studenti;
    }

    public List<Fakultet> vratiFakultete() {
        List<Fakultet> fakulteti = new ArrayList<>();

        String upit = "SELECT * FROM fakultet ";

        try {
            Statement s = Konekcija.getInstanca().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                Fakultet fakultet = new Fakultet();

                fakultet.setIdFakultet(rs.getLong("id_fakultet"));
                fakultet.setNaziv(rs.getString("naziv"));
                fakultet.setAdresa(rs.getString("adresa"));

                fakulteti.add(fakultet);
            }

            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fakulteti;
    }

    public List<Zaposleni> vratiZaposlene() {
        List<Zaposleni> zaposleni = new ArrayList<>();

        String upit = "SELECT * FROM zaposleni ";

        try {
            Statement s = Konekcija.getInstanca().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                Zaposleni z = new Zaposleni();

                z.setIdZaposleni(rs.getLong("id_zaposleni"));
                z.setIme(rs.getString("ime"));
                z.setPrezime(rs.getString("prezime"));
                z.setTelefon(rs.getString("telefon"));
                z.setEmail(rs.getString("email"));
                z.setLozinka(rs.getString("lozinka"));

                zaposleni.add(z);
            }

            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return zaposleni;
    }

    private List<StavkaDnevnika> vratiStavke(Dnevnik dnevnik) {
        List<StavkaDnevnika> stavke = new ArrayList<>();

        String upit = "SELECT * FROM stavka_dnevnika sd "
                + "JOIN dnevnik d ON d.id_dnevnik = sd.id_dnevnik "
                + "JOIN zadatak z ON sd.id_zadatak = z.id_zadatak "
                + "WHERE sd.id_dnevnik = ? ";

        try {
            PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(upit);
            ps.setLong(1, dnevnik.getIdDnevnik());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StavkaDnevnika stavka = new StavkaDnevnika();
                Zadatak zadatak = new Zadatak();

                zadatak.setIdZadatak(rs.getLong("z.id_zadatak"));
                zadatak.setOpis(rs.getString("z.opis"));

                stavka.setDnevnik(dnevnik);
                stavka.setRedniBroj(rs.getInt("sd.redni_broj"));
                stavka.setTrajanje(rs.getInt("sd.trajanje"));
                stavka.setZadatak(zadatak);

                stavke.add(stavka);
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stavke;
    }

    public void izmeniDnevnik(Dnevnik dnevnik) {

    }

    public List<Zadatak> vratiZadatke() {
        List<Zadatak> zadaci = new ArrayList<>();

        String upit = "SELECT * FROM zadatak ";

        try {
            Statement s = Konekcija.getInstanca().getConnection().createStatement();
            ResultSet rs = s.executeQuery(upit);

            while (rs.next()) {
                Zadatak zadatak = new Zadatak();

                zadatak.setIdZadatak(rs.getLong("id_zadatak"));
                zadatak.setOpis(rs.getString("opis"));

                zadaci.add(zadatak);
            }

            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return zadaci;
    }

}
