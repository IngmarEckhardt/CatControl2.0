package catkontrollgruppe.catcontrolService;

import catkontrollgruppe.catController.CatTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class CatService {
    public static ArrayList<Cat> catArray = new ArrayList<>();

    public CatService() {
        CatTable catTable = new CatTable();





    }
    // Eine Methode welche die im Speicher vorhandenen Katzen zählt

    public int countCats() {
        String linie;
        int katzencount;
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.home") + File.separator + "Cats.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            linie = br.readLine();
            //Anzahl der Katzen im Datensatz wird ermittelt indem leere Zeilen vor den Datensätzen gezählt werden
            while (linie != null) {
                if ("".equals(linie)) {
                    katzencount++;
                }
                linie = br.readLine();
            }
            br.close();
        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
        return katzencount;
   }


    // Eine Methode um die Observable List zu speichern


    public void newCat(String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        katzencount += 1;
        catArray.add(newCat);
        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}






