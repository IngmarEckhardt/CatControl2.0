package catkontrollgruppe.catcontrolService;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CatSpeichermanager {

    public CatSpeichermanager() {
    }

    public void writeCats(ObservableList<Cat> catArray) {
        try {
            System.out.println("Das" + catArray + "wird neu geschrieben");
            File datei = new File(System.getProperty("user.home") + File.separator + "Cats.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(datei, catArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Cat> readCats() {
        ArrayList<Cat> catlist = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Hier läuft es noch");
        File datei = new File(System.getProperty("user.home") + File.separator + "Cats.json");
        try {
            System.out.println(Arrays.asList(mapper.readValue(datei, Cat[].class)));
            catlist.addAll(Arrays.asList(mapper.readValue(datei, Cat[].class)));
            System.out.println(catlist);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return catlist;
    }
}