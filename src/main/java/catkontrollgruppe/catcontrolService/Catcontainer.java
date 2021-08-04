package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;

public class Catcontainer {
    private ObservableList<Cat> catlist;
    protected CatCache catCache = new CatCache();
    protected static boolean intendedDelete;

    public Catcontainer() {}


    public void CatKreation(String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        addCat(newCat);
        catlist = FXCollections.observableArrayList(catCache.getCatArray());
        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz " +
                "hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }

    protected void addCat(Cat newCat) {

        catCache.getCatArray().add(newCat);
        catlist = FXCollections.observableArrayList(catCache.getCatArray());
    }

    public ObservableList<Cat> getCatlist() {
        return catlist;
    }

    protected void deleteCat(Cat catDelete) {
        CatCache catCache = new CatCache();
        catCache.getCatArray().remove(catDelete);
        intendedDelete = true;
        catlist = FXCollections.observableArrayList(catCache.getCatArray());
    }
    protected void editCat (Cat catEDIT) {}
}