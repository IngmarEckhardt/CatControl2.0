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
        CatCache.catArray.sort(new SortName());
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
        CatRepository catRepository = new CatRepository();
        catArray = catRepository.readCats();
        ObservableList<Cat> speicherCache = FXCollections.observableArrayList(catArray);
        boolean intendedDelete;
        try {
            while (true) {
                intendedDelete = CatService.intendedDelete;
                if (!intendedDelete) {
                    if (catArray.size() != speicherCache.size()) {
                        if (catArray.size() > speicherCache.size()) {
                            speicherCache = FXCollections.observableArrayList(CatCache.catArray);
                            speicherCache.sort(new SortName());
                            catRepository.writeCats(speicherCache);
                        } else {
                            speicherCache.sort(new SortName());
                            catRepository.writeCats(speicherCache);
                            for (int i = 0; i < speicherCache.size(); i++) {
                                catArray.set(i, speicherCache.get(i));
                            }
                        }
                    }
                } else {
                    speicherCache.clear();
                    speicherCache = FXCollections.observableArrayList(catArray);
                    speicherCache.sort(new SortName());
                    catRepository.writeCats(speicherCache);
                    CatService.intendedDelete = false;
                }
                Thread.sleep(200);
            }
        } catch (final InterruptedException e) {
            System.out.println("ContainerMonitorthread interrupted.");
        }
        System.out.println("Containermonitorthread exiting.");
    }
}