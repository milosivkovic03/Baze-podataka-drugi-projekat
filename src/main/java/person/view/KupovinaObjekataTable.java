package person.view;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.StambeniObjekat;

public class KupovinaObjekataTable extends TableView<StambeniObjekat>{
    public KupovinaObjekataTable(ObservableList<StambeniObjekat> observableList) {
        super(observableList);

        TableColumn<StambeniObjekat, Integer> tcIdObjekta = new TableColumn<>("ID");
        TableColumn<StambeniObjekat, String> tcAdresa = new TableColumn<>("Adresa");
        TableColumn<StambeniObjekat, String> tcTipObjekta = new TableColumn<>("Tip objekta");

        tcIdObjekta.setCellValueFactory(new PropertyValueFactory<>("objekatId"));
        tcAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        tcTipObjekta.setCellValueFactory(new PropertyValueFactory<>("tipObjekta"));

        super.getColumns().add(tcIdObjekta);
        super.getColumns().add(tcAdresa);
        super.getColumns().add(tcTipObjekta);
    }
}
