package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Collections;

public class CatCache extends Thread {
    private Thread t;
    private boolean intendedDelete;
    private static ArrayList<Cat> catArray = new ArrayList<>();
    private ObservableList<Cat> speicherCache;

    public CatCache() {
    }

    public ArrayList<Cat> getCatArray() {
        return catArray;
    }

    protected void setCatArray(ArrayList<Cat> catArray) {
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
        CatSpeichermanager catSpeichermanager = new CatSpeichermanager();
        catSpeichermanager.readCats();
        speicherCache = FXCollections.observableArrayList(catArray);
        intendedDelete = false;
        try {
            while (true) {
                intendedDelete = Catcontainer.intendedDelete;
                if (!intendedDelete) {
                    if (catArray.size() != speicherCache.size()) {
                        if (catArray.size() > speicherCache.size()) {
                            System.out.println("Das Catarray" +catArray +"ist größer als der Cache, Cache erneut geschrieben und CatArray gespeichtert");
                            speicherCache = FXCollections.observableArrayList(catArray);
                            Collections.sort(speicherCache, new SortierNamen());
                            catSpeichermanager.writeCats(speicherCache);
                        } else {
                            System.out.println("Der Cache ist größer als das Catarray, der Cache wurde gespeichert, das catarray neu geschrieben");
                            Collections.sort(speicherCache, new SortierNamen());
                            catSpeichermanager.writeCats(speicherCache);
                            for (int i = 0; i < speicherCache.size(); i++) {
                                catArray.set(i, speicherCache.get(i));
                            }
                        }
                    }
                } else {
                    System.out.println("Intenteded delete steht auf true und der Cache wird geleert und aus dem verkleinerten Catarray befüllt.");
                    speicherCache.clear();
                    speicherCache = FXCollections.observableArrayList(catArray);
                    Collections.sort(speicherCache, new SortierNamen());
                    catSpeichermanager.writeCats(speicherCache);
                    intendedDelete = false;
                }
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("ContainerMonitorthread interrupted.");
        }
        System.out.println("Containermonitorthread exiting.");
    }
}