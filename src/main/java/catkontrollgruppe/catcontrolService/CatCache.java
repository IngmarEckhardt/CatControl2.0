package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class CatCache extends Thread {
    private Thread t;
    private static ArrayList<Cat> catArray = new ArrayList<>();

    public CatCache() {
    }

    public ArrayList<Cat> getCatArray() {
        CatCache.catArray.sort(new SortierNamen());
        return CatCache.catArray;
    }

    protected void setCatArray(final ArrayList<Cat> catArray) {
        CatCache.catArray = catArray;
    }

    public void start() {
        System.out.println("Starting ContainerMonitorThread");
        if (this.t == null) {
            this.t = new Thread(this, "Containermonitorthread");
            this.t.start();
        }
    }

    public void run() {
        final CatSpeichermanager catSpeichermanager = new CatSpeichermanager();
        CatCache.catArray = catSpeichermanager.readCats();
        ObservableList<Cat> speicherCache = FXCollections.observableArrayList(CatCache.catArray);
        boolean intendedDelete;
        try {
            while (true) {
                intendedDelete = Catcontainer.intendedDelete;
                if (!intendedDelete) {
                    if (CatCache.catArray.size() != speicherCache.size()) {
                        if (CatCache.catArray.size() > speicherCache.size()) {
                            speicherCache = FXCollections.observableArrayList(CatCache.catArray);
                            speicherCache.sort(new SortierNamen());
                            catSpeichermanager.writeCats(speicherCache);
                        } else {
                            speicherCache.sort(new SortierNamen());
                            catSpeichermanager.writeCats(speicherCache);
                            for (int i = 0; i < speicherCache.size(); i++) {
                                CatCache.catArray.set(i, speicherCache.get(i));
                            }
                        }
                    }
                } else {
                    speicherCache.clear();
                    speicherCache = FXCollections.observableArrayList(CatCache.catArray);
                    speicherCache.sort(new SortierNamen());
                    catSpeichermanager.writeCats(speicherCache);
                    Catcontainer.intendedDelete = false;
                }
                Thread.sleep(200);
            }
        } catch (final InterruptedException e) {
            System.out.println("ContainerMonitorthread interrupted.");
        }
        System.out.println("Containermonitorthread exiting.");
    }
}