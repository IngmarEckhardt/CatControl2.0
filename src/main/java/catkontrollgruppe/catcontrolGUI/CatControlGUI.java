package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatKreation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CatControlGUI extends Application {

    public static void main(String[] args) {
        CatKreation cats = new CatKreation();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("CatControl");

// Das Grid wird konstruiert
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(20);
        grid.setPadding(new Insets(10, 10, 10, 10));

//Das erste Textelement, Titel

        Text titel = new Text("CatControl - Gibt dir die Kontrolle zurück");
        titel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(titel,0,0,3,2);

// Menue-Buttons
        Button knopfDatabase = new Button("Katzen-Datenbank");
        grid.add(knopfDatabase, 0,3);
        Button knopfNewCat = new Button ("Neue Katze hinzufügen");
        grid.add(knopfNewCat,1,3);
        Button knopfChangeImpfung = new Button ("Impfdatum aktualisieren");
        grid.add(knopfChangeImpfung,2,3);
        Text catGame = new Text("CatControl - Singleplayerkampagne");
        catGame.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        grid.add(catGame,0,5,2,1);
        Button knopfGame = new Button ("Play");
        grid.add(knopfGame,2,5);
        Button knopfHilfe = new Button ("Hilfe");
        grid.add(knopfHilfe,0,8);
        Button knopfQuit = new Button ("CatControl verlassen");
        grid.add(knopfQuit,2,8);

//Button-Aktionen
        knopfDatabase.setOnAction(actionEvent -> CatverwaltungGUI.neuesFenster(primaryStage));
        knopfNewCat.setOnAction(actionEvent -> KatzeneingabeGUI.neuesFenster(primaryStage));
        knopfChangeImpfung.setOnAction(actionEvent -> {
            //ImpfaktualisierungGUI.neuesFenster(primaryStage);
        });
        knopfGame.setOnAction(actionEvent -> {
            //KatzengameGUI.neuesFenster(primaryStage);
            Cat cat = new Cat();
            cat.schnurren();
        });
        knopfHilfe.setOnAction(actionEvent -> {
            //HilfefensterGUI.neuesFenster(primaryStage);

        });
        knopfQuit.setOnAction(actionEvent -> {
            AbschiedsfensterGUI.neuesFenster(primaryStage);
            //JOptionPane.showMessageDialog(null, "Programm wird beendet.");
        });


// Die Scene wird initialisiert, mit dem grid befüllt und der Stage übergeben
        Scene meineScene = new Scene(grid, 500, 300);
        primaryStage.setScene(meineScene);
        primaryStage.show();
    }
}
