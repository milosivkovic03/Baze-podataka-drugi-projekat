package person.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.controller.IzaberiDatumIVremePolaskaControl;
import person.controller.IzaberiNebeskoTeloControl;
import person.controller.IzaberiStambeniObjekatControl;
import person.model.NebeskoTelo;
import person.model.Putovanje;
import person.model.StambeniObjekat;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;

public class MainView extends Stage {
    private final ComboBox<NebeskoTelo> cbNebeskaTela = new ComboBox<>(FXCollections.observableArrayList(JDBCUtils.selectNastanjivaNebeskaTela()));
    private final Button btNebeskoTeloFilter = new Button("Izaberi nebesko telo");
    private final ComboBox<StambeniObjekat> cbStambeniObjekti = new ComboBox<>();
    private final Button btStambeniObjektiFilter = new Button("Kupi objekat");
    private final DatePicker dpOdabirDatuma = new DatePicker(LocalDate.now());
    private final ComboBox<Integer> cbSati = new ComboBox<>(FXCollections.observableArrayList(0,1,2,3,4,5,6
                        ,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24));
    private final ComboBox<Integer> cbMinuti = new ComboBox<>(FXCollections.observableArrayList(0,1,2,3,4,5,6
            ,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,
            44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59));
    private final Button btIzaberiPolazak = new Button("Izaberi polazak");
    private final TableView<StambeniObjekat> tvKupovinaObjekata = new KupovinaObjekataTable(FXCollections.observableArrayList());
    private final TableView<Putovanje> tvKupovinaKarata = new KupovinaKarataTable(FXCollections.observableArrayList());

    public MainView() {
        btNebeskoTeloFilter.setOnAction(new IzaberiNebeskoTeloControl(cbNebeskaTela, cbStambeniObjekti));
        btStambeniObjektiFilter.setOnAction(new IzaberiStambeniObjekatControl(cbStambeniObjekti, (KupovinaObjekataTable) tvKupovinaObjekata));
        btIzaberiPolazak.setOnAction(new IzaberiDatumIVremePolaskaControl(cbNebeskaTela, dpOdabirDatuma, cbSati, cbMinuti, (KupovinaKarataTable) tvKupovinaKarata));
        HBox hBox1 = new HBox(10, new Label("Nebeska Tela: "), cbNebeskaTela, btNebeskoTeloFilter);
        HBox hBox2 = new HBox(10, new Label("Objekti: "), cbStambeniObjekti, btStambeniObjektiFilter);
        HBox hBox3 = new HBox(10, new Label("Datum polaska: "), dpOdabirDatuma, new Label("Vreme polaska: (sati, minuti)"), cbSati, cbMinuti, btIzaberiPolazak);
        VBox vBox1 = new VBox(10, new Label("Kupljeni objekti:"), tvKupovinaObjekata);
        VBox vBox2 = new VBox(10, new Label("Kupljene karte:"), tvKupovinaKarata);
        HBox hBox4 = new HBox(10, vBox1, vBox2);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
        VBox root = new VBox(hBox1, hBox2, hBox3, hBox4);
        root.setSpacing(20);
        root.setMinSize(350,350);
        root.setAlignment(Pos.CENTER);
        super.setScene(new Scene(root));
    }
}
