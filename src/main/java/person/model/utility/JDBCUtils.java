package person.model.utility;

import javafx.scene.control.Alert;
import person.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Korisnik> selectFromKorisnik(String korisnickoIme, String lozinka)
    {
        List<Korisnik> korisnici = new ArrayList<>();
        String query = "select * from Korisnik where korisnicko_ime like ? and lozinka like ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, korisnickoIme);
            statement.setString(2, lozinka);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int korisnikId = resultSet.getInt(1);
                String korisnickoIme1 = resultSet.getString(2);
                String lozinka1 = resultSet.getString(3);
                Korisnik korisnik = new Korisnik(korisnikId, korisnickoIme1, lozinka1);
                korisnici.add(korisnik);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return korisnici;
    }
    public static boolean postojeciKorisnik(String korisnickoIme)
    {
        String query = "select korisnicko_ime from Korisnik where korisnicko_ime like ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, korisnickoIme);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String korisnickoIme1 = resultSet.getString(1);
                if (korisnickoIme.equals(korisnickoIme1))
                {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static void insertIntoKorisnik(String ime, String prezime, int jmbg, LocalDate datumRodjenja, String korisnickoIme, String lozinka) {
        if (!postojeciKorisnik(korisnickoIme))
        {
            String query1 = "insert into Korisnik (korisnicko_ime, lozinka)" +
                    "values (?, ?)";
            String query3 = "select id_korisnika from Korisnik where korisnicko_ime like ?";
            String query2 = "insert into Osoba(ime, prezime, JMBG, datum_rodjenja,id_korisnika)" +
                    "values (?, ?, ?, str_to_date(?, '%m/%d/%Y'),?)";
            try {
                PreparedStatement statement1 = connection.prepareStatement(query1);
                PreparedStatement statement3 = connection.prepareStatement(query3);
                PreparedStatement statement2 = connection.prepareStatement(query2);
                connection.setAutoCommit(false);
                statement1.setString(1, korisnickoIme);
                statement1.setString(2, lozinka);
                statement1.executeUpdate();
                connection.commit();
                statement3.setString(1,korisnickoIme);
                ResultSet resultSet = statement3.executeQuery();
                int idKorisnika = 0;
                while(resultSet.next()){
                    idKorisnika = resultSet.getInt(1);
                }
                statement2.setString(1, ime);
                statement2.setString(2, prezime);
                statement2.setInt(3, jmbg);
                statement2.setString(4,
                        datumRodjenja.getMonthValue() + "/" +
                                datumRodjenja.getDayOfMonth() + "/" + datumRodjenja.getYear());
                statement2.setInt(5,idKorisnika);
                statement2.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Korisnik vec postoji");
            error.setHeaderText(null);
            error.setContentText("Korisnik vec postoji");
            error.showAndWait();
        }
    }
    public static List<NebeskoTelo> selectNastanjivaNebeskaTela() {
        List<NebeskoTelo> nebeskaTela = new ArrayList<>();
        String query = "select * from nebesko_telo as telo where (udaljenost_od_zvezde between 100000000 and 200000000)\n" +
                " and (min_temperatura between 150 and 250) and (max_temperatura between 250 and 350) and (max_temperatura - min_temperatura <= 120 )\n" +
                " and (procenat_kiseonika between 15 and 25) and ((procenat_kiseonika + procenat_drugog_gasa) between 90 and 99)\n" +
                " and (gravitaciono_polje < 1000) and (brzina_orbitiranja between 25 and 35) and (SELECT COUNT(id_osobe) FROM osoba " +
                "JOIN korisnik ON osoba.id_korisnika = korisnik.id_korisnika JOIN putovanje ON korisnik.id_korisnika = putovanje.id_korisnika " +
                "WHERE (TIMESTAMPDIFF(YEAR, datum_rodjenja, CURRENT_DATE) <= 40)  AND (telo.id_nebeskog_tela = putovanje.id_nebeskog_tela) " +
                "AND (osoba.datum_smrti is NOT null) AND (TIMESTAMPDIFF(YEAR, putovanje.datum_polaska, osoba.datum_smrti) <= 1) " +
                "AND (year(osoba.datum_smrti) = year(CURRENT_DATE) - 1)) <= 20";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nebeskoTeloId = resultSet.getInt(1);
                String nebeskoTeloNaziv = resultSet.getString(2);
                int udaljenostOdZvezde = resultSet.getInt(3);
                int minTemperatura = resultSet.getInt(4);
                int maxTemperatura = resultSet.getInt(5);
                int procenatKiseonika = resultSet.getInt(6);
                int procenatDrugogGasa = resultSet.getInt(7);
                int gravitacionoPolje = resultSet.getInt(8);
                int brzina_orbitiranja = resultSet.getInt(9);
                NebeskoTelo nebeskoTelo = new NebeskoTelo(nebeskoTeloId, nebeskoTeloNaziv, udaljenostOdZvezde, minTemperatura, maxTemperatura, procenatKiseonika, procenatDrugogGasa, gravitacionoPolje, brzina_orbitiranja);
                nebeskaTela.add(nebeskoTelo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nebeskaTela;
    }
    public static List<StambeniObjekat> selectStambeniObjekatNaNebeskomTelu(NebeskoTelo nebeskoTelo){
        List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
        String query = "select id_objekta,adresa,tip_objekta.naziv_tipa,nebesko_telo.naziv_nebeskog_tela from stambeni_objekat join nebesko_telo on " +
                "stambeni_objekat.id_nebeskog_tela = nebesko_telo.id_nebeskog_tela" +
                "            join tip_objekta on stambeni_objekat.id_tipa = tip_objekta.id_tipa " +
                "            where nebesko_telo.id_nebeskog_tela = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1, nebeskoTelo.getNebeskoTeloId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int objekatId = resultSet.getInt(1);
                String adresa = resultSet.getString(2);
                String nazivTipa = resultSet.getString(3);
                String nazivNebeskogTela = resultSet.getString(4);

                StambeniObjekat stambeniObjekat = new StambeniObjekat(objekatId,adresa,nazivNebeskogTela,nazivTipa);
                stambeniObjekti.add(stambeniObjekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }
    public static List<StambeniObjekat> selectIzabraniObjekat(int idObjekta)
    {
        List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
        String query = "select id_objekta, adresa, naziv_tipa from stambeni_objekat " +
                "join tip_objekta on stambeni_objekat.id_tipa = tip_objekta.id_tipa where id_objekta = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, idObjekta);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int objekatId = resultSet.getInt(1);
                String adresa = resultSet.getString(2);
                String nazivTipa = resultSet.getString(3);
                StambeniObjekat stambeniObjekat = new StambeniObjekat(objekatId, adresa, nazivTipa);
                stambeniObjekti.add(stambeniObjekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }
    public static List<Putovanje> selectPutovanja(LocalDate datum, LocalTime vreme, NebeskoTelo nebeskoTelo){
        List<Putovanje> putovanja = new ArrayList<>();
        String query = "select id_putovanja, naziv_prevoza from Putovanje join Prevozno_sredstvo " +
                "on Putovanje.sifra_prevoza = Prevozno_sredstvo.sifra_prevoza " +
                "where id_nebeskog_tela = ? and datum_polaska = ? and vreme_polaska = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1,nebeskoTelo.getNebeskoTeloId());
            statement.setDate(2, Date.valueOf(datum));
            statement.setTime(3, Time.valueOf(vreme));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int idPutovanja = resultSet.getInt(1);
                String prevoz = resultSet.getString(2);
                Putovanje putovanje = new Putovanje(idPutovanja, prevoz);
                putovanja.add(putovanje);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return putovanja;
    }
    private JDBCUtils() {

    }
}
