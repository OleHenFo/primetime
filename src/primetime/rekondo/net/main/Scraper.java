package primetime.rekondo.net.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rekondo on 27.04.2017.
 *
 */
public class Scraper {
    private ArrayList<Prime> primes;
    private ArrayList<Relic> relics;

    public ArrayList<Relic> getRelics(){
        relics = new ArrayList<>();
        String url = "http://warframe.wikia.com/wiki/Void_Relic";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Cannot connect to Warframe wiki!");
        }
        Element container = doc.select("#mw-customcollapsible-rewarddrops").first();
        Elements tabbertabs = container.select(".tabbertab");
        Element list = tabbertabs.first();
        Element table = list.select("tbody").first();
        Elements rows = table.select("tr");
        for (Element row:rows){
            Elements data = row.select("td");
            if (data.first()!=null) {
                String tier = data.get(0).text();
                String type = data.get(1).text();
                relics.add(new Relic(tier,type,false));
            }
        }
        return relics;
    }

    public ArrayList<Prime> getPrimes() {
        primes = new ArrayList<>();
        String url = "http://warframe.wikia.com/wiki/Void_Relic";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Cannot connect to Warframe wiki!");
        }
        Element container = doc.select("#mw-customcollapsible-rewarddrops").first();
        Elements tabbertabs = container.select(".tabbertab");
        Element list = tabbertabs.last();
        Element table = list.select("tbody").first();
        Elements rows = table.select("tr");
        Elements previous = null;
        boolean first = true;
        for (Element row:rows){
            Elements data = row.select("td");
            if (data!=null&&data.first()!=null) {
                String name = data.get(0).text();
                if (first){
                    first = false;
                    primes.add(new Prime(name));
                } else if (!previous.get(0).text().equals(name)&&name.length()>6) {
                    primes.add(new Prime(name));
                }
            }
            previous = data;
        }
        return primes;
    }

    public void getData(){
        String url = "http://warframe.wikia.com/wiki/Void_Relic";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Cannot connect to Warframe wiki!");
        }
        Element container = doc.select("#mw-customcollapsible-rewarddrops").first();
        Elements tabbertabs = container.select(".tabbertab");
        Element list = tabbertabs.first();
        Elements rows = list.select("tr");
        for (Element row:rows){
            System.out.println(row.toString());
        }
    }
}
