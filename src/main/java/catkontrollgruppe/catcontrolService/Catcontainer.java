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
                if (catArray.size()!=catlist.size()) {
                    if (catArray.size()>catlist.size()) {
                        Collections.sort(catArray, new SortierNamen());
                        addToObsList();
                        saveCompleteArray();
                    }
                    else {
                        Collections.sort(catlist, new SortierNamen());
                        saveCompleteArray();
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
            for (int i = 0; i < catlist.size(); i++) {
                if (i > 0) {
                    bw.write("\n");
                }
                bw.write("\n" + catlist.get(i).getName());
                bw.write("\n" + catlist.get(i).getAlter());
                bw.write("\n" + catlist.get(i).getImpfdatum());
                bw.write("\n" + catlist.get(i).getGewicht());
                if (catlist.get(i).isRund()) {
                    bw.write("\n" + "true");
                } else {
                    bw.write("\n" + "false");
                } if (catlist.get(i).isSuess()) {
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