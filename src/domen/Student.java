package domen;

import java.util.Objects;

public class Student {

    private long idStudent;
    private String brojIndeksa;
    private String ime;
    private String prezime;
    private Fakultet fakultet;

    public Student() {
    }

    public Student(long idStudent, String brojIndeksa, String ime, String prezime, Fakultet fakultet) {
        this.idStudent = idStudent;
        this.brojIndeksa = brojIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.fakultet = fakultet;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
