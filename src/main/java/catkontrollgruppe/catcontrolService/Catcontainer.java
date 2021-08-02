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
    private ArrayList<Cat> catArray = new ArrayList<>();
    private ObservableList<Cat> catlist;
    private boolean safed;

    public Catcontainer(Cat newCat) {
        catArray.add(newCat);
        Collections.sort(CatService.catArray, new SortierNamen());
        catlist = FXCollections.observableArrayList(catArray);
        System.out.println(catArray);
        System.out.println(catlist);
    }
    public Catcontainer(Cat[] catcollection) {
        Collections.addAll(catArray, catcollection);
        Collections.sort(CatService.catArray, new SortierNamen());
        catlist = FXCollections.observableArrayList(catArray);
        System.out.println(catArray);
        System.out.println(catlist);
    }

    protected void saveCompleteArray() {
        try {
            File datei = new File(System.getProperty("user.home") + File.separator + "Cats.txt");
            if (!datei.exists()) {
                datei.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    System.getProperty("user.home") + File.separator + "Cats.txt", false));
            for (int i = 0; i < CatService.catArray.size(); i++) {
                if (i > 0) {
                    bw.write("\n");
                }
                bw.write("\n" + CatService.catArray.get(i).getName());
                bw.write("\n" + CatService.catArray.get(i).getAlter());
                bw.write("\n" + CatService.catArray.get(i).getImpfdatum());
                bw.write("\n" + CatService.catArray.get(i).getGewicht());
                if (CatService.catArray.get(i).isRund()) {
                    bw.write("\n" + "true");
                } else {
                    bw.write("\n" + "false");
                }
                if (CatService.catArray.get(i).isSuess()) {
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

    protected boolean isSafed() {
        return safed;
    }
}