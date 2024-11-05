package person.model.base;

import person.model.Korisnik;
import person.model.NebeskoTelo;
import person.model.Putovanje;
import person.model.StambeniObjekat;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private NebeskoTelo nebeskoTelo;
    private StambeniObjekat stambeniObjekat;
    private LocalDate datum_polaska;
    private LocalTime vreme_polaska;

    private Server() {
    }

    public NebeskoTelo getNebeskoTelo() {
        return nebeskoTelo;
    }

    public void setNebeskoTelo(NebeskoTelo nebeskoTelo) {
        this.nebeskoTelo = nebeskoTelo;
    }

    public LocalDate getDatum_polaska() {
        return datum_polaska;
    }

    public void setDatum_polaska(LocalDate datum_polaska) {
        this.datum_polaska = datum_polaska;
    }

    public LocalTime getVreme_polaska() {
        return vreme_polaska;
    }

    public void setVreme_polaska(LocalTime vreme_polaska) {
        this.vreme_polaska = vreme_polaska;
    }

    public StambeniObjekat getStambeniObjekat() {
        return stambeniObjekat;
    }

    public void setStambeniObjekat(StambeniObjekat stambeniObjekat) {
        this.stambeniObjekat = stambeniObjekat;
    }
}
