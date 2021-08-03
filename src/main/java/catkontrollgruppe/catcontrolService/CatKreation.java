package catkontrollgruppe.catcontrolService;

import javax.swing.*;
import java.io.*;

public class CatKreation {
    String linie;
    String name;
    int alter;
    String impfdatum;
    double gewicht;
    boolean rund;
    boolean suess;
    /* Auslesen der gespeicherten Katzen zu Beginn des Programms Erzeugung als Objekt, Einordnen in ArrayList, Erzeugung
    der ObservableList. Die Cats.txt gehört ins User-Home-Verzeichnis. */

    public CatKreation() {
        Catcontainer catcontainern = new Catcontainer();
        int catcount = CatService.countCats();
        try {
            FileInputStream fis2 = new FileInputStream(System.getProperty("user.home") + File.separator + "Cats.txt");
            InputStreamReader isr2 = new InputStreamReader(fis2);
            BufferedReader br2 = new BufferedReader(isr2);

            for (int i = 0; i < catcount; i++) {
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
                catcontainern.addCat(newCat);
            }
            CatCache catCache = new CatCache();
            catCache.start();
            br2.close();
        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
    }

    public CatKreation (String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        Catcontainer catcontainern = new Catcontainer();
        catcontainern.addCat(newCat);
        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz " +
                "hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }
}
