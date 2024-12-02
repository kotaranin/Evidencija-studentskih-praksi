package domen;

public class StavkaDnevnika {

    private Dnevnik dnevnik;
    private int redniBroj;
    private int trajanje;
    private Zadatak zadatak;

    public StavkaDnevnika() {
    }

    public StavkaDnevnika(Dnevnik dnevnik, int redniBroj, int trajanje, Zadatak zadatak) {
        this.dnevnik = dnevnik;
        this.redniBroj = redniBroj;
        this.trajanje = trajanje;
        this.zadatak = zadatak;
    }

    public Dnevnik getDnevnik() {
        return dnevnik;
    }

    public void setDnevnik(Dnevnik dnevnik) {
        this.dnevnik = dnevnik;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Zadatak getZadatak() {
        return zadatak;
    }

    public void setZadatak(Zadatak zadatak) {
        this.zadatak = zadatak;
    }

}
