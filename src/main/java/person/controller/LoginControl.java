package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import person.model.Korisnik;
import person.model.utility.JDBCUtils;
import person.view.LoginView;
import person.view.MainView;

import java.util.List;

public class LoginControl implements EventHandler<ActionEvent> {
    private final TextField tfKorisnickoIme;
    private final TextField tfLozinka;
    private final LoginView loginView;
    public LoginControl(TextField tfKorisnickoIme, TextField tfLozinka, LoginView loginView) {
        this.tfKorisnickoIme = tfKorisnickoIme;
        this.tfLozinka = tfLozinka;
        this.loginView = loginView;
    }


    @Override
    public void handle(ActionEvent event) {
        String korisnickoIme = tfKorisnickoIme.getText().trim();
        String lozinka = tfLozinka.getText().trim();
        List<Korisnik> korisnici = JDBCUtils.selectFromKorisnik(korisnickoIme, lozinka);
        if (korisnici.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Korisnik ne postoji");
            error.setHeaderText(null);
            error.setContentText("Korisnik ne postoji");
            error.showAndWait();
        }
        else
        {
            loginView.close();
            MainView mainView = new MainView();
            mainView.show();
        }
    }
}
