package primetime.rekondo.net.main;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public ScrollPane scroller;
    public AnchorPane table_anchor;
    public AnchorPane root;
    public TableView primeTable;
    public TableView relicTable;

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
}
