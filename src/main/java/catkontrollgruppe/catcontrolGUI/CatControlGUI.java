package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatCache;
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
import javafx.stage.StageStyle;

public class CatControlGUI extends Application {

    public static void main(final String[] args) {

        final CatCache catCache = new CatCache();
        catCache.start();
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {


        primaryStage.setTitle("CatControl");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(20);
        grid.setPadding(new Insets(10, 10, 10, 10));

        final Text titel = new Text("CatControl - Gibt dir die Kontrolle zurück");
        titel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(titel,0,0,3,2);

        final Button knopfDatabase = new Button("Katzen-Übersicht");
        grid.add(knopfDatabase, 0,3);
        final Button knopfNewCat = new Button ("Neue Katze hinzufügen");
        grid.add(knopfNewCat,1,3);
        final Button knopfChangeImpfung = new Button ("Katzen editieren");
        grid.add(knopfChangeImpfung,2,3);
        final Text catGame = new Text("CatControl - Singleplayerkampagne");
        catGame.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        grid.add(catGame,0,5,2,1);
        final Button knopfGame = new Button ("Play");
        grid.add(knopfGame,2,5);
        final Button knopfHilfe = new Button ("Hilfe");
        grid.add(knopfHilfe,0,8);
        final Button knopfQuit = new Button ("CatControl verlassen");
        grid.add(knopfQuit,2,8);

        knopfDatabase.setOnAction(actionEvent -> CatverwaltungGUI.neuesFenster(primaryStage));
        knopfNewCat.setOnAction(actionEvent -> KatzeneingabeGUI.neuesFenster(primaryStage));
        knopfChangeImpfung.setOnAction(actionEvent -> KatzeneditorGUI.neuesFenster(primaryStage));
        knopfGame.setOnAction(actionEvent -> {
            //KatzengameGUI.neuesFenster(primaryStage);
            final Cat cat = new Cat();
            cat.schnurren();
        });
        knopfHilfe.setOnAction(actionEvent -> {HilfefensterGUI.neuesFenster(primaryStage);

        });
        knopfQuit.setOnAction(actionEvent -> AbschiedsfensterGUI.neuesFenster(primaryStage));

        final Scene meineScene = new Scene(grid, 500, 300);
        primaryStage.setScene(meineScene);
        primaryStage.show();
    }
}