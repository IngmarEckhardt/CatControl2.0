package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Catcontainer {
    public static ObservableList<Cat> catlist;
    public Catcontainer() {}


    public void addCat(Cat newCat) {
        CatCache.getCatArray().add(newCat);
        catlist = FXCollections.observableArrayList(CatCache.getCatArray());
    }

    public static ObservableList<Cat> getCatlist() {
        return catlist;
    }

    protected void deleteCat(Cat catDelete) {

    }

    protected void editCat (Cat catEDIT) {

    }

}