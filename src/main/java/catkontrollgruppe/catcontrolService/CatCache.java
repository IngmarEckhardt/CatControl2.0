package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

import static catkontrollgruppe.catcontrolService.Catcontainer.catlist;

public class CatCache extends Thread {
    private Thread t;
    private static ArrayList<Cat> catArray = new ArrayList<>();
    private ObservableList<Cat> speicherCache;

    public CatCache() {
    }

    protected static ArrayList<Cat> getCatArray() {
        return catArray;
    }

    protected static void setCatArray(ArrayList<Cat> catArray) {
        CatCache.catArray = catArray;
    }

    public void start() {
        System.out.println("Starting ContainerMonitorThread");
        if (t == null) {
            t = new Thread(this, "Containermonitorthread");
            t.start();
        }
    }

    public void run() {
        speicherCache = FXCollections.observableArrayList(catArray);
        try {
            while (true) {
                /* Schleife prüft beide Arrays gegeneinander, wählt die größere zum Speichern, cacht sie dafür in einem
                weiteren ObservableArray. Die Liste kann somit auf neue Katzen reagieren. Die Löschung einer Katze muss
                 noch implementiert werden.*/
                if (catArray.size()!=speicherCache.size()) {
                    if (catArray.size()>speicherCache.size()) {
                        speicherCache = FXCollections.observableArrayList(catArray);
                        Collections.sort(speicherCache, new SortierNamen());
                        CatSpeichermanager.saveCompleteArray(speicherCache);
                        catlist.setAll(speicherCache);
                    }
                    else {
                        speicherCache = FXCollections.observableArrayList(catlist);
                        Collections.sort(speicherCache, new SortierNamen());
                        CatSpeichermanager.saveCompleteArray(speicherCache);
                        for(int i =0 ; i < speicherCache.size(); i++) {
                            catArray.set(i, speicherCache.get(i));
                        }
                    }
                }
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("ContainerMonitorthread interrupted.");
        }
        System.out.println("Containermonitorthread exiting.");
    }
}
