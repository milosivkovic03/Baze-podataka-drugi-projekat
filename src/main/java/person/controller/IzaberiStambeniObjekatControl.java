package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import person.model.StambeniObjekat;
import person.model.base.Server;
import person.model.utility.JDBCUtils;
import person.view.KupovinaObjekataTable;

public class IzaberiStambeniObjekatControl implements EventHandler<ActionEvent> {
    private final ComboBox<StambeniObjekat> cbStambeniObjekat;
    private final KupovinaObjekataTable kupovinaObjekataTable;

    public IzaberiStambeniObjekatControl(ComboBox<StambeniObjekat> cbStambeniObjekat, KupovinaObjekataTable kupovinaObjekataTable) {
        this.cbStambeniObjekat = cbStambeniObjekat;
        this.kupovinaObjekataTable = kupovinaObjekataTable;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        StambeniObjekat stambeniObjekat = cbStambeniObjekat.getValue();
        if (stambeniObjekat == null)
        {
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Nebesko telo nije izabrano.");
            info.setHeaderText(null);
            info.setContentText("Nebesko telo nije izabrano.");
            info.showAndWait();
        }
        else Server.SERVER.setStambeniObjekat(stambeniObjekat);
        kupovinaObjekataTable.setItems(FXCollections.observableArrayList(JDBCUtils.selectIzabraniObjekat(stambeniObjekat.getObjekatId())));
    }
}
