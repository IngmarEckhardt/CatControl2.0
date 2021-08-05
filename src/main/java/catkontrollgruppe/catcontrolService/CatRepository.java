package catkontrollgruppe.catcontrolService;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CatRepository {

    public CatRepository() {
    }

    public void writeCats(ObservableList<Cat> catArray) {
        try {
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
        File datei = new File(System.getProperty("user.home") + File.separator + "Cats.json");
        try {
            catlist.addAll(Arrays.asList(mapper.readValue(datei, Cat[].class)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return catlist;
    }
}