package catkontrollgruppe.catcontrolService;

import java.io.*;

public class CatService {
    private static String linie;
    private static int katzencount;

    public CatService() {
    }

    // Eine Methode welche die im Speicher vorhandenen Katzen zählt
    public static int countCats() {

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.home") + File.separator + "Cats.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            linie = br.readLine();
            //Anzahl der Katzen im Datensatz wird ermittelt, indem leere Zeilen vor den Datensätzen gezählt werden
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







