package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CatService {
    private ObservableList<Cat> catlist;
    protected CatCache catCache = new CatCache();
    protected static boolean intendedDelete;

    public CatService() {
    }

    public static void main(String[] args) {
        CatCache cache = new CatCache();
        cache.start();
    }

    public void CatKreation(final String name, final int alter, final String impfdatum, final double gewicht, final boolean rund, final boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        this.addCat(newCat);
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }

    protected void addCat(final Cat newCat) {

        this.catCache.getCatArray().add(newCat);
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }

    public ObservableList<Cat> getCatlist() {
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
        return this.catlist;
    }

    public void deleteCat(Cat catDelete) {
        this.catCache.getCatArray().remove(catDelete);
        CatService.intendedDelete = true;
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }
    protected void editCat (final Cat catEDIT) {}
}