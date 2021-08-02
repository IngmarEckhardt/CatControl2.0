package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.CatService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

public class KatzeneingabeGUI {
    public static void neuesFenster(Stage hauptFenster) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(grid, 400, 300);
        Stage neuesWindow = new Stage();

        neuesWindow.setTitle("Katze hinzufügen");
        neuesWindow.setScene(scene);
        neuesWindow.initModality(Modality.WINDOW_MODAL);
        neuesWindow.initOwner(hauptFenster);
        neuesWindow.setX(hauptFenster.getX() + 150);
        neuesWindow.setY(hauptFenster.getY() + 100);


        Text titel = new Text("Geben Sie die ihnen bekannten Daten ihrer Katze ein.");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(titel, 0, 0, 2, 1);

        //Die Eingabemaske
        Label katzenname = new Label( "Name der Katze");
        grid.add(katzenname,0,2);
        TextField eingabeKatzenname = new TextField();
        grid.add(eingabeKatzenname,2,2);

        Label katzenalter = new Label( "Alter der Katze in Jahren");
        grid.add(katzenalter,0,3);
        TextField eingabeKatzenalter = new TextField();
        grid.add(eingabeKatzenalter,2,3);

        Label impfDatum = new Label( "Wann wurde die Katze zuletzt geimpft?(Monat Jahr)");
        grid.add(impfDatum,0,4);
        TextField eingabeImpfung = new TextField();
        grid.add(eingabeImpfung,2,4);

        Label gewicht = new Label( "Wie schwer ist die Katze? Format 0.00(kg)");
        grid.add(gewicht,0,5);
        TextField eingabeGewicht = new TextField();
        grid.add(eingabeGewicht,2,5);

        ToggleSwitch rund = new ToggleSwitch("Die Katze ist rund (on/off)");
        grid.add(rund,0,6);
        ToggleSwitch suess = new ToggleSwitch("Die Katze ist suess (on/off)");
        grid.add(suess,0,7);

        //Speichern und Abbrechen-Button
        Button eingabeSpeichern = new Button ("Katze hinzufügen");
        grid.add(eingabeSpeichern,2,8);

        Button eingabeAbbrechen = new Button ("Abbrechen");
        grid.add(eingabeAbbrechen,0,8);

         eingabeSpeichern.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String catName = eingabeKatzenname.getText();
                int alter = Integer.parseInt(eingabeKatzenalter.getText());
                String impfung = eingabeImpfung.getText();
                double katzenGewicht = Double.parseDouble(eingabeGewicht.getText());
                boolean rUnd = rund.isSelected();
                boolean sUss = suess.isSelected();
                CatService catService = new CatService();
                catService.newCat(catName,alter,impfung,katzenGewicht,rUnd,sUss);
                neuesWindow.close();
                //FensterGespeichert.neuesFenster(hauptFenster);
            }
        });
        eingabeAbbrechen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                neuesWindow.close();
            }
        });
        neuesWindow.show();
    }

}