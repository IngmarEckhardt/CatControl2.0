package catkontrollgruppe.catController;

import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatService;
import catkontrollgruppe.catcontrolService.CatcontainerMonitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import java.util.ArrayList;

import static javafx.application.Application.launch;

public class CatTable {
    private int catcount;
    private boolean safeFlag;

    //constructor
    public CatTable() {
        launch();
    }

    public int getCatcount() {
        return catcount;
    }

    public void setCatcount(int catcount) {
        this.catcount = catcount;
    }

    public void start() {
    }

}
