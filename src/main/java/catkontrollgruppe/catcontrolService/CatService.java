package catkontrollgruppe.catcontrolService;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatService {
    private int katzencount;

    public CatService() {
        this.katzencount = 0;
        catKreation();

    }
    public void newCat(String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        katzencount += 1;
        CatTable.add(newCat);
        safe = false;
        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }
    public void catKreation() {
        String linie;
        String name;
        int alter;
        String impfdatum;
        double gewicht;
        boolean rund;
        boolean suess;

        countCats();
        // Die Katzen werden aus dem Speicher heraus erzeugt
        try {

            FileInputStream fis2 = new FileInputStream("src/main/java/catcontrolgroup/catcontrolfxgui/Cats.txt");
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
                CatTable.addCat(newCat);

                //Zur Kontrolle der Objekterzeugung in der Alpha-Programm-Phase im Terminal
                System.out.println("Die Katze " + newCat + " wurde erzeugt.");
            }
            br2.close();

        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
    }

    public int countCats() {
        String linie;
        try {
            FileInputStream fis = new FileInputStream("src/main/java/catcontrolgroup/catcontrolfxgui/Cats.txt");
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

}