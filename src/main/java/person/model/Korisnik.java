package person.model;

import java.time.LocalDate;

public class Korisnik {
    private final int korisnikId;
    private String ime;
    private String prezime;
    private int jmbg;
    private LocalDate datumRodjenja;
    private String korisnickoIme;
    private String lozinka;

    public Korisnik(int korisnikId, String ime, String prezime, int jmbg, LocalDate datumRodjenja, String korisnickoIme, String lozinka) {
        this.korisnikId = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Korisnik(int korisnikId, String korisnickoIme, String lozinka) {
        this.korisnikId = korisnikId;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getKorisnikId() {
        return korisnikId;
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

    public int getJmbg() {
        return jmbg;
    }

    public void setJmbg(int jmbg) {
        this.jmbg = jmbg;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
