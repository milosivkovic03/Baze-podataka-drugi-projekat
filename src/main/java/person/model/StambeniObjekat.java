package person.model;

public class StambeniObjekat {
    private final int objekatId;
    private String adresa;
    private String nebeskoTelo;
    private String tipObjekta;

    public StambeniObjekat(int objekatId, String adresa, String nebeskoTelo, String tipObjekta) {
        this.objekatId = objekatId;
        this.adresa = adresa;
        this.nebeskoTelo = nebeskoTelo;
        this.tipObjekta = tipObjekta;
    }

    public StambeniObjekat(int objekatId, String adresa, String tipObjekta) {
        this.objekatId = objekatId;
        this.adresa = adresa;
        this.tipObjekta = tipObjekta;
    }

    public int getObjekatId() {
        return objekatId;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNebeskoTelo() {
        return nebeskoTelo;
    }

    public void setNebeskoTelo(String nebeskoTelo) {
        this.nebeskoTelo = nebeskoTelo;
    }

    public String getTipObjekta() {
        return tipObjekta;
    }

    public void setTipObjekta(String tipObjekta) {
        this.tipObjekta = tipObjekta;
    }

    @Override
    public String toString() {
        return adresa;
    }
}
