package person;

import javafx.application.Application;
import javafx.stage.Stage;
import person.model.utility.JDBCUtils;
import person.view.LoginView;
import person.view.MainView;
import person.view.RegisterView;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        JDBCUtils.connect();
        stage = new LoginView();
        stage.show();

    }

}
