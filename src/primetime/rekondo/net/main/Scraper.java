package primetime.rekondo.net.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Rekondo on 27.04.2017.
 *
 */
public class Scraper {
    private ArrayList<Prime> primes;
    private ArrayList<Relic> relics;

    public static void getData(){
        String url = "http://warframe.wikia.com/wiki/Void_Relic";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Cannot connect to Warframe wiki!");
        }
        Element container = doc.select("#mw-customcollapsible-rewarddrops").first();
        Elements lists = container.select(".tabbertab");
        Element simple = lists.last();
        Elements rows = simple.select("tr");

    }
}
