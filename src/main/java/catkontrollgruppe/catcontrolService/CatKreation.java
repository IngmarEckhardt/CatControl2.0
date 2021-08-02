package catkontrollgruppe.catcontrolService;

import catkontrollgruppe.catController.CatTable;

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


    public CatKreation() {

        CatService catService = new CatService();
        int katzencount= catService.countCats()

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
                Catcontainer catcontainern = new Catcontainer(newCat);
            }
            br2.close();

        } catch (IOException ioAusnahme) {
            System.out.print("Datei konnte nicht geöffnet werden.");
        }
    }

    public CatKreation (String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        Catcontainer katzencontainern = new Catcontainer(newCat);

        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }
}
