package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Catcontainer extends Thread {
    private Thread t;
    private static ArrayList<Cat> catArray = new ArrayList<>();
    private static ObservableList<Cat> catlist;
    private ObservableList<Cat> speicherCache;

    public Catcontainer() {}

    protected static void addCat(Cat newCat) {
        catArray.add(newCat);
    }

    protected void addToObsList() {
        catlist = FXCollections.observableArrayList(catArray);
    }
    public static ObservableList<Cat> getCatlist() {
        return catlist;
    }

    public static ArrayList<Cat> getCatArray() {
        return catArray;
    }

    // Ein eigener Thread der die Datenbank cached und die Speichermethode auslöst bei Bedarf
    public void run() {

        try {
            while (true) {
                /* Schleife prüft beide Arrays gegeneinander, wählt die größere zum Speichern, cacht sie dafür in einem
                weiteren ObservableArray. Die Liste kann somit auf neue Katzen reagieren. Die Löschung einer Katze muss
                 noch implementiert werden.*/
                if (catArray.size()!=catlist.size()) {
                    if (catArray.size()>catlist.size()) {
                        speicherCache = FXCollections.observableArrayList(catArray);
                        Collections.sort(speicherCache, new SortierNamen());
                        saveCompleteArray();
                        catlist.addAll(0,speicherCache);
                    }
                    else {
                        speicherCache.addAll(0, catlist);
                        Collections.sort(speicherCache, new SortierNamen());
                        saveCompleteArray();
                        catArray.addAll(0,speicherCache);
                    }
                }
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("ContainerMonitorthread interrupted.");
        }
        System.out.println("Containermonitorthread exiting.");
    }

    public void start() {
        System.out.println("Starting ContainerMonitorThread");
        if (t == null) {
            t = new Thread(this, "Containermonitorthread");
            t.start();
        }
    }

    protected void saveCompleteArray() {
        try {
            File datei = new File(System.getProperty("user.home") + File.separator + "Cats.txt");
            if (!datei.exists()) {
                datei.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    System.getProperty("user.home") + File.separator + "Cats.txt", false));
            for (int i = 0; i < speicherCache.size(); i++) {
                if (i > 0) {
                    bw.write("\n");
                }
                bw.write("\n" + speicherCache.get(i).getName());
                bw.write("\n" + speicherCache.get(i).getAlter());
                bw.write("\n" + speicherCache.get(i).getImpfdatum());
                bw.write("\n" + speicherCache.get(i).getGewicht());
                if (speicherCache.get(i).isRund()) {
                    bw.write("\n" + "true");
                } else {
                    bw.write("\n" + "false");
                } if (speicherCache.get(i).isSuess()) {
                    bw.write("\n" + "true");
                } else {
                    bw.write("\n" + "false");
                }
            }
            bw.close();
        } catch (IOException ioAusnahme) {
            System.out.print("Fehler beim Öffnen der Datei");
        }
    }
}