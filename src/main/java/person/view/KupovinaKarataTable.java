package person.view;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Putovanje;

public class KupovinaKarataTable extends TableView<Putovanje> {
    public KupovinaKarataTable(ObservableList<Putovanje> observableList) {
        super(observableList);

        TableColumn<Putovanje, Integer> tcPutovanjeId = new TableColumn<>("ID");
        TableColumn<Putovanje, String> tcPrevoznoSredstvo = new TableColumn<>("Prevozno sredstvo");

        tcPutovanjeId.setCellValueFactory(new PropertyValueFactory<>("putovanjeId"));
        tcPrevoznoSredstvo.setCellValueFactory(new PropertyValueFactory<>("prevoznoSredstvo"));
        tcPrevoznoSredstvo.setMinWidth(150);

        super.getColumns().add(tcPutovanjeId);
        super.getColumns().add(tcPrevoznoSredstvo);
    }
}
