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
    private ArrayList<Cat> catArrayTest = new ArrayList<>();
    private static ObservableList<Cat> catlist;
    private ObservableList<Cat> catlistTest;
    private boolean safed;

    protected static void addCat(Cat newCat) {
        catArray.add(newCat);
        Collections.sort(catArray, new SortierNamen());
        System.out.println("Catarray:"+ catArray);
    }

    public Catcontainer() {}

    protected void addToObsList() {
        catlist = FXCollections.observableArrayList(catArray);
        System.out.println("Observable List:" + catlist);
    }
    public static ArrayList<Cat> getCatArray() {
        return catArray;
    }

    public static ObservableList<Cat> getCatlist() {
        return catlist;
    }

    public void setCatArray(ArrayList<Cat> catArray) {
        this.catArray = catArray;
    }

    protected boolean isSafed() {
        return safed;
    }

    public void addCatArray(Cat[] newCatArray) {
        Collections.addAll(catArray, newCatArray);
        Collections.sort(catArray, new SortierNamen());
        catlist = FXCollections.observableArrayList(catArray);
        System.out.println(catArray);
        System.out.println(catlist);
    }

    public void run() {
        Collections.sort(catArray, new SortierNamen());
        System.out.println(catArray);
        System.out.println(catlist);
        try {
            for (int i = 0; true; i++) {
                if (!safed) {
                    System.out.println(catArray);
                    Collections.sort(catlist, new SortierNamen());
                    saveCompleteArray();
                    safed=true;
                }
                // Let the thread sleep for a while.
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread exiting.");
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
                }
                if (catlist.get(i).isSuess()) {
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