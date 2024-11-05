package person.model;

public class NebeskoTelo {
    private final int nebeskoTeloId;
    private String nebeskoTeloNaziv;
    private int udaljenostOdZvezde, minTemperatura, maxTemperatura, procenatKiseonika, procenatDrugogGasa, gravitacionoPolje, brzinaOrbitiranja;

    public NebeskoTelo(int nebeskoTeloId, String nebeskoTeloNaziv, int udaljenostOdZvezde, int minTemperatura, int maxTemperatura, int procenatKiseonika, int procenatDrugogGasa, int gravitacionoPolje, int brzinaOrbitiranja) {
        this.nebeskoTeloId = nebeskoTeloId;
        this.nebeskoTeloNaziv = nebeskoTeloNaziv;
        this.udaljenostOdZvezde = udaljenostOdZvezde;
        this.minTemperatura = minTemperatura;
        this.maxTemperatura = maxTemperatura;
        this.procenatKiseonika = procenatKiseonika;
        this.procenatDrugogGasa = procenatDrugogGasa;
        this.gravitacionoPolje = gravitacionoPolje;
        this.brzinaOrbitiranja = brzinaOrbitiranja;
    }

    public int getNebeskoTeloId() {
        return nebeskoTeloId;
    }

    public String getNebeskoTeloNaziv() {
        return nebeskoTeloNaziv;
    }

    public void setNebeskoTeloNaziv(String nebeskoTeloNaziv) {
        this.nebeskoTeloNaziv = nebeskoTeloNaziv;
    }

    public int getUdaljenostOdZvezde() {
        return udaljenostOdZvezde;
    }

    public void setUdaljenostOdZvezde(int udaljenostOdZvezde) {
        this.udaljenostOdZvezde = udaljenostOdZvezde;
    }

    public int getMinTemperatura() {
        return minTemperatura;
    }

    public void setMinTemperatura(int minTemperatura) {
        this.minTemperatura = minTemperatura;
    }

    public int getMaxTemperatura() {
        return maxTemperatura;
    }

    public void setMaxTemperatura(int maxTemperatura) {
        this.maxTemperatura = maxTemperatura;
    }

    public int getProcenatKiseonika() {
        return procenatKiseonika;
    }

    public void setProcenatKiseonika(int procenatKiseonika) {
        this.procenatKiseonika = procenatKiseonika;
    }

    public int getProcenatDrugogGasa() {
        return procenatDrugogGasa;
    }

    public void setProcenatDrugogGasa(int procenatDrugogGasa) {
        this.procenatDrugogGasa = procenatDrugogGasa;
    }

    public int getGravitacionoPolje() {
        return gravitacionoPolje;
    }

    public void setGravitacionoPolje(int gravitacionoPolje) {
        this.gravitacionoPolje = gravitacionoPolje;
    }

    public int getBrzinaOrbitiranja() {
        return brzinaOrbitiranja;
    }

    public void setBrzinaOrbitiranja(int brzinaOrbitiranja) {
        this.brzinaOrbitiranja = brzinaOrbitiranja;
    }

    @Override
    public String toString() {
        return nebeskoTeloNaziv;
    }
}