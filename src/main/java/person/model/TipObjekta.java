package person.model;

public class TipObjekta {
    private final int tipId;
    private String naziv;

    public TipObjekta(int tipId, String naziv) {
        this.tipId = tipId;
        this.naziv = naziv;
    }

    public int getTipId() {
        return tipId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
