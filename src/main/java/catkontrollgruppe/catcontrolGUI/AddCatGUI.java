package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.CatControl;
import catkontrollgruppe.catcontrolService.Cat;
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

import javax.swing.*;

public class AddCatGUI {
    private Cat newCat = new Cat();

    public void neuesFenster(final Stage hauptFenster, Cat dummyCat) {
        newCat = dummyCat;
        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        final Scene scene = new Scene(grid, 400, 300);
        final Stage neuesWindow = new Stage();

        neuesWindow.setTitle("Katze hinzufügen");
        neuesWindow.setScene(scene);
        neuesWindow.initModality(Modality.WINDOW_MODAL);
        neuesWindow.initOwner(hauptFenster);
        neuesWindow.setX(hauptFenster.getX() +20);
        neuesWindow.setY(hauptFenster.getY() +20);

        final Text titel = new Text("Geben Sie die ihnen bekannten Daten ihrer Katze ein.");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(titel, 0, 0, 2, 1);

        final Label katzenname = new Label( "Name der Katze");
        grid.add(katzenname,0,2);
        final TextField eingabeKatzenname = new TextField();
        grid.add(eingabeKatzenname,2,2);
        final Label katzenalter = new Label( "Alter der Katze in Jahren");
        grid.add(katzenalter,0,3);
        final TextField eingabeKatzenalter = new TextField();
        grid.add(eingabeKatzenalter,2,3);
        final Label impfDatum = new Label( "Wann wurde die Katze zuletzt geimpft?(Monat Jahr)");
        grid.add(impfDatum,0,4);
        final TextField eingabeImpfung = new TextField();
        grid.add(eingabeImpfung,2,4);
        final Label gewicht = new Label( "Wie schwer ist die Katze? Format 0.00(kg)");
        grid.add(gewicht,0,5);
        final TextField eingabeGewicht = new TextField();
        grid.add(eingabeGewicht,2,5);
        final ToggleSwitch rund = new ToggleSwitch("Die Katze ist rund (on/off)");
        grid.add(rund,0,6);
        final ToggleSwitch suess = new ToggleSwitch("Die Katze ist suess (on/off)");
        grid.add(suess,0,7);

        final Button eingabeSpeichern = new Button ("Katze hinzufügen");
        grid.add(eingabeSpeichern,2,8);
        final Button eingabeAbbrechen = new Button ("Abbrechen");
        grid.add(eingabeAbbrechen,0,8);

        CatControl catControl = new CatControl ();
        eingabeSpeichern.setOnAction(actionEvent -> {
            newCat.setName(eingabeKatzenname.getText());
            try {
                newCat.setAlter(Integer.parseInt(eingabeKatzenalter.getText()));
                newCat.setImpfdatum(eingabeImpfung.getText());
                newCat.setGewicht(Double.parseDouble(eingabeGewicht.getText()));
                newCat.setRund(rund.isSelected());
                newCat.setSuess(suess.isSelected());
                catControl.addCat(newCat);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Bitte geben Sie nur zulässige Werte ein");
                neuesWindow.close();
                catControl.openNewCatWindow(neuesWindow);
            }
            neuesWindow.close();
        });
        eingabeAbbrechen.setOnAction(actionEvent -> neuesWindow.close());
        neuesWindow.show();;
    }
}