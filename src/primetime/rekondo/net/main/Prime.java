package primetime.rekondo.net.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created by Rekondo on 27.04.2017.
 *
 */
public class Prime {
    private StringProperty name;
    private ArrayList<Relic> relics;
    private boolean vaulted;

    public Prime(String name, ArrayList<Relic> relics, boolean vaulted) {
        this.name = new SimpleStringProperty(name);
        this.relics = relics;
        this.vaulted = vaulted;
    }

    public Prime(String name) {
        this.name = new SimpleStringProperty(name);
        this.relics = null;
    }

    public String getName() {
        return name.get();
    }

    public ArrayList<Relic> getRelics() {
        return relics;
    }

    public boolean isVaulted() {
        return vaulted;
    }
}
