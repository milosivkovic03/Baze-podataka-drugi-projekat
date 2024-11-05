package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import person.view.LoginView;
import person.view.RegisterView;

public class GoToRegisterControl implements EventHandler<ActionEvent> {
    private final LoginView loginView;
    public GoToRegisterControl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void handle(ActionEvent event) {
        loginView.close();
        RegisterView registerView = new RegisterView();

        registerView.show();
    }
}
