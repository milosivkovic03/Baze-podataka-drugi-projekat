package person.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.controller.BackToLoginControl;
import person.controller.RegisterControl;

import java.time.LocalDate;

public class RegisterView extends Stage {
    private final Label lbIme = new Label("Ime: ");
    private final Label lbPrezime = new Label("Prezime: ");
    private final Label lbJmbg = new Label("Jmbg: ");
    private final Label lbDatumRodjenja = new Label("Datum rodjenja: ");
    private final Label lbKorisnickoIme = new Label("Korisnicko ime: ");
    private final Label lbLozinka = new Label("Lozinka: ");

    private final TextField tfIme = new TextField();
    private final TextField tfPrezime = new TextField();
    private final TextField tfJmbg = new TextField();
    private final DatePicker dpDatumRodjenja = new DatePicker(LocalDate.now().minusYears(20));
    private final TextField tfKorisnickoIme = new TextField();
    private final TextField tfLozinka = new TextField();

    private final Button btNazadPrijava = new Button("Postojeci korisnik");
    private final Button btRegistracija = new Button("Registruj se");
    public RegisterView() {
        HBox hb1 = new HBox(10,lbIme,tfIme);
        HBox hb2 = new HBox(10,lbPrezime,tfPrezime);
        HBox hb3 = new HBox(10,lbJmbg,tfJmbg);
        HBox hb4 = new HBox(10,lbDatumRodjenja,dpDatumRodjenja);
        HBox hb5 = new HBox(10,lbKorisnickoIme,tfKorisnickoIme);
        HBox hb6 = new HBox(10,lbLozinka,tfLozinka);
        HBox hb7 = new HBox(10,btNazadPrijava,btRegistracija);

        hb1.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.CENTER);
        hb3.setAlignment(Pos.CENTER);
        hb4.setAlignment(Pos.CENTER);
        hb5.setAlignment(Pos.CENTER);
        hb6.setAlignment(Pos.CENTER);
        hb7.setAlignment(Pos.CENTER);

        VBox vbRoot = new VBox(hb1,hb2,hb3,hb4,hb5,hb6,hb7);
        vbRoot.setMinSize(350,350);
        vbRoot.setSpacing(10);
        vbRoot.setAlignment(Pos.CENTER);
        btNazadPrijava.setOnAction(new BackToLoginControl(this));
        btRegistracija.setOnAction(new RegisterControl(tfIme, tfPrezime, tfJmbg, dpDatumRodjenja, tfKorisnickoIme, tfLozinka, this));
        super.setScene(new Scene(vbRoot));
    }
}
