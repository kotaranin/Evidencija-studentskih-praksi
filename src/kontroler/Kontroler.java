package kontroler;

import baza.Broker;
import domen.Dnevnik;
import domen.Fakultet;
import domen.Student;
import domen.Zadatak;
import domen.Zaposleni;
import java.util.List;

public class Kontroler {

    private static Kontroler instanca;
    private Broker broker;

    private Kontroler() {
        broker = new Broker();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Zaposleni ulogujSe(String email, String lozinka) {
        return broker.ulogujSe(email, lozinka);
    }

    public List<Dnevnik> vratiDnevnike(String[] kriterijum) {
        return broker.vratiDnevnike(kriterijum);
    }

    public List<Student> vratiStudente() {
        return broker.vratiStudente();
    }

    public List<Fakultet> vratiFakultete() {
        return broker.vratiFakultete();
    }

    public List<Zaposleni> vratiZaposlene() {
        return broker.vratiZaposlene();
    }

    public void izmeniDnevnik(Dnevnik dnevnik) {
        broker.izmeniDnevnik(dnevnik);
    }

    public List<Zadatak> vratiZadatke() {
        return broker.vratiZadatke();
    }

}
