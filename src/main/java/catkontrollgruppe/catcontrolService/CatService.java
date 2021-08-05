package catkontrollgruppe.catcontrolService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CatService {

    private ObservableList<Cat> catlist;
    protected CatCache catCache = new CatCache();
    protected static boolean intendedDelete;


    public CatService() {
    }

    public void startService() {
        CatCache cache = new CatCache();
        cache.start();
    }


    public void CatKreation(String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {

        Cat newCat = new Cat(name, alter, impfdatum, gewicht, rund, suess);
        this.addCat(newCat);
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }

    public void addCat(Cat newCat) {

        catCache.getCatArray().add(newCat);
        catlist = FXCollections.observableArrayList(catCache.getCatArray());
    }

    public ObservableList<Cat> getCatlist() {
        catlist = FXCollections.observableArrayList(catCache.getCatArray());
        return catlist;
    }

    public void deleteCat(Cat catDelete) {
        this.catCache.getCatArray().remove(catDelete);
        CatService.intendedDelete = true;
        this.catlist = FXCollections.observableArrayList(this.catCache.getCatArray());
    }
    protected void editCat (final Cat catEDIT) {}
}