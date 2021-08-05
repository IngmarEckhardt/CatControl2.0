package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.CatControl;
import catkontrollgruppe.catcontrolService.Cat;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

public class MenuGUI extends Application {

    public void startGUI() {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        CatControl catControl = new CatControl();

        primaryStage.setTitle("CatControl");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15.0);
        grid.setVgap(20.0);
        grid.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));

        Text titel = new Text("CatControl - Gibt dir die Kontrolle zurück");
        titel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(titel,0,0,3,2);

        Button knopfDatabase = new Button("Katzen-Übersicht");
        grid.add(knopfDatabase, 0,3);
        Button knopfNewCat = new Button ("Neue Katze hinzufügen");
        grid.add(knopfNewCat,1,3);
        Button knopfChangeImpfung = new Button ("Katzen editieren");
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

        knopfDatabase.setOnAction((ActionEvent actionEvent) -> {
            catControl.openDBWindow(primaryStage);
        });
        knopfNewCat.setOnAction((ActionEvent actionEvent) -> {
            catControl.openNewCatWindow(primaryStage);
        });
        knopfChangeImpfung.setOnAction(actionEvent -> {
            catControl.openEditMenuWindow(primaryStage);
        });
        knopfHilfe.setOnAction(actionEvent -> {
            catControl.openHelpPage(primaryStage);
        });
        knopfQuit.setOnAction(actionEvent -> {
            catControl.openEndscreen(primaryStage);
        });
        knopfGame.setOnAction(actionEvent -> {
            Cat cat = new Cat();
            cat.schnurren();
        });

        Scene meineScene = new Scene(grid, 500, 300);
        primaryStage.setScene(meineScene);
        primaryStage.show();
    }
}