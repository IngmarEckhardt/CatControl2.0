package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;

public class Catcontainer {
    private ObservableList<Cat> catlist;
    protected CatCache catCache = new CatCache();
    protected static boolean intendedDelete;

    public Catcontainer() {}


    public void CatKreation(final String name, final int alter, final String impfdatum, final double gewicht, final boolean rund, final boolean suess) {

        final Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        this.addCat(newCat);
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
        JOptionPane.showMessageDialog(null, "Die Katze " + newCat + " wurde erzeugt und dem Datensatz " +
                "hinzugefügt", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }

    protected void addCat(final Cat newCat) {

        this.catCache.getCatArray().add(newCat);
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }

    public ObservableList<Cat> getCatlist() {
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
        return this.catlist;
    }

    public void deleteCat(final Cat catDelete) {
        this.catCache.getCatArray().remove(catDelete);
        Catcontainer.intendedDelete = true;
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }
    protected void editCat (final Cat catEDIT) {}
}