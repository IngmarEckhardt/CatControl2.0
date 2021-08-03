package catkontrollgruppe.catcontrolService;

import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CatSpeichermanager {

    public CatSpeichermanager() {
    }

    protected static void saveCompleteArray(ObservableList<Cat> speicherCats) {
        try {
            File datei = new File(System.getProperty("user.home") + File.separator + "Cats.txt");
            if (!datei.exists()) {
                datei.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    System.getProperty("user.home") + File.separator + "Cats.txt", false));
            for (int i = 0; i < speicherCats.size(); i++) {
                if (i > 0) {
                    bw.write("\n");
                }
                bw.write("\n" + speicherCats.get(i).getName());
                bw.write("\n" + speicherCats.get(i).getAlter());
                bw.write("\n" + speicherCats.get(i).getImpfdatum());
                bw.write("\n" + speicherCats.get(i).getGewicht());
                if (speicherCats.get(i).isRund()) {
                    bw.write("\n" + "true");
                } else {
                    bw.write("\n" + "false");
                } if (speicherCats.get(i).isSuess()) {
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
