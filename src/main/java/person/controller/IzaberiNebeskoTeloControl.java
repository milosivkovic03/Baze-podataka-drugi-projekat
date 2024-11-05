package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import person.model.NebeskoTelo;
import person.model.StambeniObjekat;
import person.model.base.Server;
import person.model.utility.JDBCUtils;

public class IzaberiNebeskoTeloControl implements EventHandler<ActionEvent> {
    private final ComboBox<NebeskoTelo> cbNebeskoTelo;
    private final ComboBox<StambeniObjekat> cbStambeniObjekat;

    public IzaberiNebeskoTeloControl(ComboBox<NebeskoTelo> cbNebeskoTelo, ComboBox<StambeniObjekat> cbStambeniObjekat) {
        this.cbNebeskoTelo = cbNebeskoTelo;
        this.cbStambeniObjekat = cbStambeniObjekat;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        NebeskoTelo nebeskoTelo = cbNebeskoTelo.getValue();
        if (nebeskoTelo == null) {
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Nebesko telo nije izabrano.");
            info.setHeaderText(null);
            info.setContentText("Nebesko telo nije izabrano.");
            info.showAndWait();
        }
        else Server.SERVER.setNebeskoTelo(nebeskoTelo);
        cbStambeniObjekat.setItems(FXCollections.observableArrayList(JDBCUtils.selectStambeniObjekatNaNebeskomTelu(Server.SERVER.getNebeskoTelo())));
    }
}
