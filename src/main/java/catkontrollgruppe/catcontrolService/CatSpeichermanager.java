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

    public void writeCats(final ObservableList<Cat> catArray) {
        try {
            final File datei = new File(System.getProperty("user.home") + File.separator + "Cats.json");
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(datei, catArray);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Cat> readCats() {
        final ArrayList<Cat> catlist = new ArrayList();
        final ObjectMapper mapper = new ObjectMapper();
        final File datei = new File(System.getProperty("user.home") + File.separator + "Cats.json");
        try {
            catlist.addAll(Arrays.asList(mapper.readValue(datei, Cat[].class)));

        } catch (final IOException e) {
            e.printStackTrace();
        }
        return catlist;
    }
}