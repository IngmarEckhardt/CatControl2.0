package catkontrollgruppe.catcontrolService;

import catkontrollgruppe.catController.CatTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CatService {
    protected int katzencount;

    public static ArrayList<Cat> catArray = new ArrayList<>();

    public CatService() {
        CatTable catTable = new CatTable();
        catKreation();

        CatcontainerMonitor catMonitor = new CatcontainerMonitor("catMonitor");
        catMonitor.start();




    }



    //  Die Katzen werden aus dem Speicher heraus erzeugt

    public void catKreation() {
        String linie;
        String name;
        int alter;
        String impfdatum;
        double gewicht;
        boolean rund;
        boolean suess;

        countCats();

        try {
            FileInputStream fis2 = new FileInputStream(System.getProperty("user.home") + File.separator + "Cats.txt");
            InputStreamReader isr2 = new InputStreamReader(fis2);
            BufferedReader br2 = new BufferedReader(isr2);

            for (int i = 0; i < katzencount; i++) {
                linie = br2.readLine();
                linie = br2.readLine();
                name = linie;
                linie = br2.readLine();
                alter = Integer.parseInt(linie);
                linie = br2.readLine();
                impfdatum = linie;
                linie = br2.readLine();
                gewicht = Double.parseDouble(linie);
                linie = br2.readLine();
                rund = Boolean.parseBoolean(linie);
                linie = br2.readLine();
                suess = Boolean.parseBoolean(linie);

                Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
                CatTable catTable = new CatTable();


                //Zur Kontrolle der Objekterzeugung in der Alpha-Programm-Phase im Terminal
                System.out.println("Die Katze " + newCat + " wurde erzeugt.");
                catArray.add(newCat);
            }
            br2.close();

        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
    }
    // Eine Methode welche die im Speicher vorhandenen Katzen zählt

    public int countCats() {
        String linie;
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
   }


    // Eine Methode um die Observable List zu speichern


    public void newCat(String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        katzencount += 1;
        catArray.add(newCat);
        CatcontainerMonitor.setSafe() = false;
        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setCatlist(ObservableList<Cat> catlist) {
        this.catlist = catlist;
    }

    public ObservableList<catkontrollgruppe.catcontrolService.Cat> getCatlist() {
        return catlist;
    }

    public void addCat(Cat cat) {
        catArray.add(cat);
        catlist = FXCollections.observableArrayList(catarray);
        //catlist.add(cat);
        System.out.println("Inhalt des Catarrays" + catarray + ". Inhalt der observeableList" + catlist);

    }

    public static boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}






