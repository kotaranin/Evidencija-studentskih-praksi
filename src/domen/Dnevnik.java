package domen;

import java.time.LocalDate;
import java.util.List;

public class Dnevnik {

    private long idDnevnik;
    private int ukupnoTrajanje;
    private String misljenjeKompanije;
    private int ocena;
    private LocalDate datumIzdavanja;
    private Zaposleni zaposleni;
    private Student student;
    private List<StavkaDnevnika> stavke;

    public Dnevnik() {
    }

    public Dnevnik(long idDnevnik, int ukupnoTrajanje, String misljenjeKompanije, int ocena, LocalDate datumIzdavanja, Zaposleni zaposleni, Student student, List<StavkaDnevnika> stavke) {
        this.idDnevnik = idDnevnik;
        this.ukupnoTrajanje = ukupnoTrajanje;
        this.misljenjeKompanije = misljenjeKompanije;
        this.ocena = ocena;
        this.datumIzdavanja = datumIzdavanja;
        this.zaposleni = zaposleni;
        this.student = student;
        this.stavke = stavke;
    }

    public long getIdDnevnik() {
        return idDnevnik;
    }

    public void setIdDnevnik(long idDnevnik) {
        this.idDnevnik = idDnevnik;
    }

    public int getUkupnoTrajanje() {
        return ukupnoTrajanje;
    }

    public void setUkupnoTrajanje(int ukupnoTrajanje) {
        this.ukupnoTrajanje = ukupnoTrajanje;
    }

    public String getMisljenjeKompanije() {
        return misljenjeKompanije;
    }

    public void setMisljenjeKompanije(String misljenjeKompanije) {
        this.misljenjeKompanije = misljenjeKompanije;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StavkaDnevnika> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaDnevnika> stavke) {
        this.stavke = stavke;
    }

}
