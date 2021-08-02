package catkontrollgruppe.catcontrolService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class CatcontainerMonitor extends Thread {
    protected Thread t;
    protected String threadName;
    static boolean safe;

    public CatcontainerMonitor(String name) {
        threadName = name;
        System.out.println("Erzeuge " + threadName);
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public void run() {
        safe = true;

        System.out.println(CatService.catArray);
        Collections.sort(CatService.catArray, new SortierNamen());

        //Wenn der Flag für isSafe auf false steht läuft die schleife los
        try {
            for (int i = 0; true; i++) {
                if (!safe) {
                    System.out.println(CatService.catArray);
                    Collections.sort(CatService.catArray, new SortierNamen());
                    saveCompleteArray();
                    safe = true;
                    System.out.println("in der Schleife");
                }
                // Let the thread sleep for a while.
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
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

    public static boolean isSafe() {
        return safe;
    }

    public static void setSafe(boolean safer) {
        safe = safer;
    }
}