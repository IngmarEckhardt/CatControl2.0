package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.CatControl;
import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatService;
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

public class CatEditGUI {

    public static void neuesFenster(Stage hauptFenster, Cat catToEdit) {
        CatControl catControl = new CatControl();
        final Cat originalCat = catToEdit;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(grid, 600, 350);
        Stage neuesWindow = new Stage();

        neuesWindow.setTitle("Katze editieren");
        neuesWindow.setScene(scene);
        neuesWindow.initModality(Modality.WINDOW_MODAL);
        neuesWindow.initOwner(hauptFenster);
        neuesWindow.setX(hauptFenster.getX() + 250);
        neuesWindow.setY(hauptFenster.getY() + 10);

        Text titel = new Text("Geben Sie die veränderten Werte der Katze ein " +
                "\noder lassen Sie das Feld unverändert");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(titel, 0, 0, 2, 1);

        CatService catService = new CatService();

        Label katzenname = new Label("Name der Katze");
        grid.add(katzenname, 0, 2);
        TextField eingabeKatzenname = new TextField();
        eingabeKatzenname.setText(catToEdit.getName());
        grid.add(eingabeKatzenname, 1, 2);

        Label katzenalter = new Label("Alter der Katze in Jahren");
        grid.add(katzenalter, 0, 3);
        TextField eingabeKatzenalter = new TextField();
        eingabeKatzenalter.setText(""+ catToEdit.getAlter());
        grid.add(eingabeKatzenalter, 1, 3);

        Label impfDatum = new Label("Wann wurde die Katze zuletzt geimpft?\n(Monat Jahr)");
        grid.add(impfDatum, 0, 4);
        TextField eingabeImpfung = new TextField();
        eingabeImpfung.setText(catToEdit.getImpfdatum());
        grid.add(eingabeImpfung, 1, 4);

        Label gewicht = new Label("Wie schwer ist die Katze? Format 0.00(kg)");
        grid.add(gewicht, 0, 5);
        TextField eingabeGewicht = new TextField();
        eingabeGewicht.setText(""+ catToEdit.getGewicht());
        grid.add(eingabeGewicht, 1, 5);

        ToggleSwitch rund = new ToggleSwitch("neu: Die Katze ist rund (on/off)");
        if (catToEdit.isRund()) {rund.setSelected(true);}
        grid.add(rund, 1, 6);

        ToggleSwitch suess = new ToggleSwitch("neu: Katze ist suess (on/off)");
        if (catToEdit.isSuess()) {suess.setSelected(true);}
        grid.add(suess, 1, 7);

        Button eingabeSpeichern = new Button("Speichern.");
        grid.add(eingabeSpeichern, 1, 8);
        Button eingabeAbbrechen = new Button("Abbrechen");
        grid.add(eingabeAbbrechen, 0, 8);

        eingabeSpeichern.setOnAction(actionEvent -> {
            catToEdit.setName(eingabeKatzenname.getText());
            try {
                catToEdit.setAlter(Integer.parseInt(eingabeKatzenalter.getText()));
                catToEdit.setImpfdatum(eingabeImpfung.getText());
                catToEdit.setGewicht(Double.parseDouble(eingabeGewicht.getText()));
                catToEdit.setRund(rund.isSelected());
                catToEdit.setSuess(suess.isSelected());
                catControl.updateCat(originalCat, catToEdit);

            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Bitte geben Sie nur zulässige Werte ein");
            }
            hauptFenster.close();
            catControl.openEditMenuWindow(hauptFenster);
            neuesWindow.close();

        });
        eingabeAbbrechen.setOnAction(actionEvent -> neuesWindow.close());
        neuesWindow.show();
    }
}