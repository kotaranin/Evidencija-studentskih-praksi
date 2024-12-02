package domen;

import java.time.LocalDate;

public class Projekat {

    private long idProjekat;
    private String naziv;
    private String opis;
    private LocalDate datumPocetka;
    private LocalDate datumZavrsetka;

    public Projekat() {
    }

    public Projekat(long idProjekat, String naziv, String opis, LocalDate datumPocetka, LocalDate datumZavrsetka) {
        this.idProjekat = idProjekat;
        this.naziv = naziv;
        this.opis = opis;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
    }

    public long getIdProjekat() {
        return idProjekat;
    }

    public void setIdProjekat(long idProjekat) {
        this.idProjekat = idProjekat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public LocalDate getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(LocalDate datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

}
