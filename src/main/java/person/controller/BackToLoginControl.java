package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import person.view.LoginView;
import person.view.RegisterView;

public class BackToLoginControl implements EventHandler<ActionEvent> {
    private final RegisterView registerView;
    public BackToLoginControl(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public void handle(ActionEvent event) {
        registerView.close();
        LoginView loginView = new LoginView();
        loginView.show();
    }
}
