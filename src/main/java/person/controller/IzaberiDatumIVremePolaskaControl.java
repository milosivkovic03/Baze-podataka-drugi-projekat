package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import person.model.NebeskoTelo;
import person.model.utility.JDBCUtils;
import person.view.KupovinaKarataTable;

import java.time.LocalDate;
import java.time.LocalTime;

public class IzaberiDatumIVremePolaskaControl implements EventHandler<ActionEvent> {
    private final ComboBox<NebeskoTelo> cbNebeskoTelo;
    private final DatePicker dpOdabirFatuma;
    private final ComboBox<Integer> cbSati;
    private final ComboBox<Integer> cbMinuti;
    private final KupovinaKarataTable kupovinaKarataTable;

    public IzaberiDatumIVremePolaskaControl(ComboBox<NebeskoTelo> cbNebeskoTelo, DatePicker dpOdabirFatuma, ComboBox<Integer> cbSati, ComboBox<Integer> cbMinuti, KupovinaKarataTable kupovinaKarataTable) {
        this.cbNebeskoTelo = cbNebeskoTelo;
        this.dpOdabirFatuma = dpOdabirFatuma;
        this.cbSati = cbSati;
        this.cbMinuti = cbMinuti;
        this.kupovinaKarataTable = kupovinaKarataTable;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        NebeskoTelo nebeskoTelo = cbNebeskoTelo.getValue();
        LocalDate datumPolaska = dpOdabirFatuma.getValue();
        int sati = cbSati.getValue();
        int minuti = cbMinuti.getValue();
        LocalTime vremePolaska = LocalTime.of(sati, minuti);
        kupovinaKarataTable.setItems(FXCollections.observableArrayList(JDBCUtils.selectPutovanja(datumPolaska, vremePolaska, nebeskoTelo)));
    }
}
