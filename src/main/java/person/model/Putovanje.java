package person.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Putovanje {
    private final int putovanjeId;
    private String korisnikIme, korisnikPrezime;
    private String nebeskoTelo;
    private String prevoznoSredstvo;
    private LocalDate datumPolaska;
    private LocalTime vremePolaska;

    public Putovanje(int putovanjeId, String korisnikIme, String korisnikPrezime, String nebeskoTelo, String prevoznoSredstvo, LocalDate datumPolaska, LocalTime vremePolaska) {
        this.putovanjeId = putovanjeId;
        this.korisnikIme = korisnikIme;
        this.korisnikPrezime = korisnikPrezime;
        this.nebeskoTelo = nebeskoTelo;
        this.prevoznoSredstvo = prevoznoSredstvo;
        this.datumPolaska = datumPolaska;
        this.vremePolaska = vremePolaska;
    }

    public Putovanje(int putovanjeId, String prevoznoSredstvo) {
        this.putovanjeId = putovanjeId;
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    public int getPutovanjeId() {
        return putovanjeId;
    }

    public String getKorisnikIme() {
        return korisnikIme;
    }

    public void setKorisnikIme(String korisnikIme) {
        this.korisnikIme = korisnikIme;
    }

    public String getKorisnikPrezime() {
        return korisnikPrezime;
    }

    public void setKorisnikPrezime(String korisnikPrezime) {
        this.korisnikPrezime = korisnikPrezime;
    }

    public String getNebeskoTelo() {
        return nebeskoTelo;
    }

    public void setNebeskoTelo(String nebeskoTelo) {
        this.nebeskoTelo = nebeskoTelo;
    }

    public String getPrevoznoSredstvo() {
        return prevoznoSredstvo;
    }

    public void setPrevoznoSredstvo(String prevoznoSredstvo) {
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    public LocalDate getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(LocalDate datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public LocalTime getVremePolaska() {
        return vremePolaska;
    }

    public void setVremePolaska(LocalTime vremePolaska) {
        this.vremePolaska = vremePolaska;
    }
}
