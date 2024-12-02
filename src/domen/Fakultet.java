package domen;

public class Fakultet {

    private long idFakultet;
    private String naziv;
    private String adresa;

    public Fakultet() {
    }

    public Fakultet(long idFakultet, String naziv, String adresa) {
        this.idFakultet = idFakultet;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public long getIdFakultet() {
        return idFakultet;
    }

    public void setIdFakultet(long idFakultet) {
        this.idFakultet = idFakultet;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
