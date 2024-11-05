package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import person.model.utility.JDBCUtils;
import person.view.MainView;
import person.view.RegisterView;

import java.time.LocalDate;

public class RegisterControl implements EventHandler<ActionEvent> {
    private final TextField tfIme;
    private final TextField tfPrezime;
    private final TextField tfJmbg;
    private final DatePicker dpDatumRodjenja;
    private final TextField tfKorisnickoIme;
    private final TextField tfLozinka;
    private final RegisterView registerView;

    public RegisterControl(TextField tfIme, TextField tfPrezime, TextField tfJmbg, DatePicker dpDatumRodjenja, TextField tfKorisnickoIme, TextField tfLozinka, RegisterView registerView) {
        this.tfIme = tfIme;
        this.tfPrezime = tfPrezime;
        this.tfJmbg = tfJmbg;
        this.dpDatumRodjenja = dpDatumRodjenja;
        this.tfKorisnickoIme = tfKorisnickoIme;
        this.tfLozinka = tfLozinka;
        this.registerView = registerView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String ime = tfIme.getText();
        String prezime = tfPrezime.getText();
        Integer jmbg = Integer.valueOf(tfJmbg.getText());
        LocalDate datumRodjenja = dpDatumRodjenja.getValue();
        String korisnickoIme = tfKorisnickoIme.getText();
        String lozinka = tfLozinka.getText();
        JDBCUtils.insertIntoKorisnik(ime, prezime, jmbg, datumRodjenja, korisnickoIme, lozinka);
        registerView.close();
        MainView mainView = new MainView();
        mainView.show();
    }
}
