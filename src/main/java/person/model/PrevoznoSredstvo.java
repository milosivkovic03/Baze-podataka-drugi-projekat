package person.model;

public class PrevoznoSredstvo {
    private final int prevoznoSredstvoId;
    private String naziv;

    public PrevoznoSredstvo(int prevoznoSredstvoId, String naziv) {
        this.prevoznoSredstvoId = prevoznoSredstvoId;
        this.naziv = naziv;
    }

    public int getPrevoznoSredstvoId() {
        return prevoznoSredstvoId;
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
