package domen;

public class Uloga {

    private Zaposleni zaposleni;
    private Projekat projekat;
    private String naziv;

    public Uloga() {
    }

    public Uloga(Zaposleni zaposleni, Projekat projekat, String naziv) {
        this.zaposleni = zaposleni;
        this.projekat = projekat;
        this.naziv = naziv;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Projekat getProjekat() {
        return projekat;
    }

    public void setProjekat(Projekat projekat) {
        this.projekat = projekat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
