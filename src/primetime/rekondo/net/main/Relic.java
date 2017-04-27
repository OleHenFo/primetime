package primetime.rekondo.net.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created by Rekondo on 27.04.2017.
 *
 */
public class Relic {
    private StringProperty tier;
    private StringProperty type;
    private StringProperty odds;
    private ArrayList<Prime> rewards;
    private boolean vaulted;

    public Relic(String tier, String type, String odds, ArrayList<Prime> rewards, boolean vaulted) {
        this.tier = new SimpleStringProperty(tier);
        this.type = new SimpleStringProperty(type);
        this.odds = new SimpleStringProperty(odds);
        this.rewards = rewards;
        this.vaulted = vaulted;
    }

    public Relic(String tier, String type, String odds, boolean vaulted) {
        this.tier = new SimpleStringProperty(tier);
        this.type = new SimpleStringProperty(type);
        this.odds = new SimpleStringProperty(odds);
        this.rewards = null;
        this.vaulted = vaulted;
    }

    public void setRewards(ArrayList<Prime> rewards) {
        this.rewards = rewards;
    }

    public void addRewards(ArrayList<Prime> rewards) {
        this.rewards.addAll(rewards);
    }

    public void addReward(Prime reward) {
        this.rewards.add(reward);
    }

    public String getTier() {
        return tier.get();
    }

    public String getType() {
        return type.get();
    }

    public String getOdds() {
        return odds.get();
    }

    public boolean isVaulted() {
        return vaulted;
    }
}
