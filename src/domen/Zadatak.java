package domen;

public class Zadatak {

    private long idZadatak;
    private String opis;

    public Zadatak() {
    }

    public Zadatak(long idZadatak, String opis) {
        this.idZadatak = idZadatak;
        this.opis = opis;
    }

    public long getIdZadatak() {
        return idZadatak;
    }

    public void setIdZadatak(long idZadatak) {
        this.idZadatak = idZadatak;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return opis;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zadatak other = (Zadatak) obj;
        return this.idZadatak == other.idZadatak;
    }

}
