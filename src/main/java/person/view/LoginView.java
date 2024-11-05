package person.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.controller.GoToRegisterControl;
import person.controller.LoginControl;

public class LoginView extends Stage {
    private final Label lbKorisnickoIme = new Label("Korisnicko ime: ");
    private final Label lbLozinka = new Label("Lozinka: ");
    private final TextField tfKorisnickoIme = new TextField();
    private final TextField tfLozinka = new TextField();
    private final Button btPrijava = new Button("Prijavi se");
    private final Button btRegistracija = new Button("Registracija za novog korisnika");
    public LoginView() {
        HBox hbView1 = new HBox(10,lbKorisnickoIme,tfKorisnickoIme);
        HBox hbView2 = new HBox(10,lbLozinka,tfLozinka);
        HBox hbView3 = new HBox(10,btRegistracija,btPrijava);

        hbView1.setAlignment(Pos.CENTER);
        hbView2.setAlignment(Pos.CENTER);
        hbView3.setAlignment(Pos.CENTER);

        VBox root = new VBox(hbView1,hbView2,hbView3);
        root.setSpacing(20);
        root.setMinSize(350,350);
        root.setAlignment(Pos.CENTER);
        btRegistracija.setOnAction(new GoToRegisterControl(this));
        btPrijava.setOnAction(new LoginControl(tfKorisnickoIme, tfLozinka, this));
        super.setScene(new Scene(root));
    }

}
