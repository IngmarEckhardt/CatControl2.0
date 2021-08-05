package catkontrollgruppe;

import catkontrollgruppe.catcontrolGUI.*;
import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatService;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class CatControl {
    private ObservableList<Cat> cats;
    private CatService catService = new CatService();
    private Cat dummyCat = new Cat ();

    public static void main(String[] args) {
        CatService catService = new CatService();
        catService.startService();
        MenuGUI menuGUI = new MenuGUI();
        menuGUI.startGUI();
    }

    public void openDBWindow(Stage menuStage){
        cats = catService.getCatlist();
        CatDataGUI.neuesFenster(menuStage, cats);
    }

    public void openNewCatWindow (Stage menuStage) {
        AddCatGUI inputScreen = new AddCatGUI();
        inputScreen.neuesFenster(menuStage, dummyCat);
    }
    public void openEditMenuWindow (Stage menuStage) {
        cats = catService.getCatlist();
        EditMenuGUI editMenuGUI = new EditMenuGUI();
        editMenuGUI.neuesFenster(menuStage, cats);
    }
    public void openCatEditWindow(Stage stage, Cat catToEdit) {
        CatEditGUI.neuesFenster(stage, catToEdit);
        cats = catService.getCatlist();
    }

    public void openHelpPage (Stage menustage) {
        HelpPageGUI helpPageGUI = new HelpPageGUI();
        helpPageGUI.neuesFenster(menustage);
    }

    public void openEndscreen (Stage menustage) {
        QuitCControlGUI quitCControlGUI = new QuitCControlGUI();
        quitCControlGUI.neuesFenster(menustage);
    }

    public ObservableList<Cat> addCat(Cat catToAdd) {
        catService.addCat(catToAdd);
        cats = catService.getCatlist();
        return cats;
    }

    public ObservableList<Cat> deleteCat(Cat catToRemove) {
        catService.deleteCat(catToRemove);
        cats = catService.getCatlist();
        return cats;
    }

    public ObservableList<Cat> updateCat (Cat catToRemove, Cat catToUpdate) {
        catService.deleteCat(catToRemove);
        catService.addCat(catToUpdate);
        cats = catService.getCatlist();
        return cats;
    }
}
