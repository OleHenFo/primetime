package primetime.rekondo.net.main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Controller {
    public ScrollPane scroller;
    public AnchorPane table_anchor;
    public AnchorPane root;
    public TableView primeTable;
    public TableView relicTable;
    public TableColumn primeNames;
    private ArrayList<Prime> primes;
    private ObservableList<Prime> primeList;
    public TableColumn relicTier;
    public TableColumn relicType;
    private ArrayList<Relic> relics;
    private ObservableList<Relic> relicList;

    @FXML
    public void initialize(){
        fillPrimeTable();
        fillRelicTable();
    }

    @FXML
    private void showPrimeTable(){
        relicTable.setVisible(false);
        relicTable.setManaged(false);
        primeTable.setManaged(true);
        primeTable.setVisible(true);
    }
    @FXML
    private void showRelicTable(){
        primeTable.setManaged(false);
        primeTable.setVisible(false);
        relicTable.setVisible(true);
        relicTable.setManaged(true);
    }

    @FXML
    public void fillPrimeTable(){
        primes = Main.s.getPrimes();
        primeList = FXCollections.observableArrayList(primes);
        primeNames.setCellValueFactory(new PropertyValueFactory<Prime,String>("name"));
        primeTable.setItems(primeList);
    }

    @FXML
    public void fillRelicTable(){
        relics = Main.s.getRelics();
        relicList = FXCollections.observableArrayList(relics);
        relicTier.setCellValueFactory(new PropertyValueFactory<Relic,String>("tier"));
        relicType.setCellValueFactory(new PropertyValueFactory<Relic,String>("type"));
        relicTable.setItems(relicList);
    }
}
