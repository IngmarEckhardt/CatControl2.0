package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Catcontainer;
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

public class CatEditGUI {

    public static void neuesFenster(final Stage hauptFenster, final int catID) {
        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        final Scene scene = new Scene(grid, 600, 350);
        final Stage neuesWindow = new Stage();

        neuesWindow.setTitle("Katze hinzufügen");
        neuesWindow.setScene(scene);
        neuesWindow.initModality(Modality.WINDOW_MODAL);
        neuesWindow.initOwner(hauptFenster);
        neuesWindow.setX(hauptFenster.getX() - 300);
        neuesWindow.setY(hauptFenster.getY()+20);

        final Text titel = new Text("Geben Sie die veränderten Werte der Katze ein " +
                "\noder lassen das Feld leer wenn sich nichts verändert hat");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(titel, 0, 0, 2, 1);

        final Catcontainer catcontainer = new Catcontainer();

        final Label katzenname = new Label("Name der Katze");
        grid.add(katzenname, 0, 2);
        final TextField eingabeKatzenname = new TextField();
        eingabeKatzenname.setText(catcontainer.getCatlist().get(catID).getName());
        grid.add(eingabeKatzenname, 1, 2);

        final Label katzenalter = new Label("Alter der Katze in Jahren");
        grid.add(katzenalter, 0, 3);
        final TextField eingabeKatzenalter = new TextField();
        eingabeKatzenalter.setText(""+catcontainer.getCatlist().get(catID).getAlter());
        grid.add(eingabeKatzenalter, 1, 3);

        final Label impfDatum = new Label("Wann wurde die Katze zuletzt geimpft?\n(Monat Jahr)");
        grid.add(impfDatum, 0, 4);
        final TextField eingabeImpfung = new TextField();
        eingabeImpfung.setText(catcontainer.getCatlist().get(catID).getImpfdatum());
        grid.add(eingabeImpfung, 1, 4);

        final Label gewicht = new Label("Wie schwer ist die Katze? Format 0.00(kg)");
        grid.add(gewicht, 0, 5);
        final TextField eingabeGewicht = new TextField();
        eingabeGewicht.setText(""+catcontainer.getCatlist().get(catID).getGewicht());
        grid.add(eingabeGewicht, 1, 5);

        final ToggleSwitch rund = new ToggleSwitch("neu: Die Katze ist rund (on/off)");
        if (catcontainer.getCatlist().get(catID).isRund()==true) {
            rund.setSelected(true);
        }
        grid.add(rund, 1, 6);

           final ToggleSwitch suess = new ToggleSwitch("neu: Katze ist suess (on/off)");
        if (catcontainer.getCatlist().get(catID).isSuess()==true) {
            suess.setSelected(true);
        }
        grid.add(suess, 1, 7);

        final Button eingabeSpeichern = new Button("Speichern.");
        grid.add(eingabeSpeichern, 1, 8);
        final Button eingabeAbbrechen = new Button("Abbrechen");
        grid.add(eingabeAbbrechen, 0, 8);

        eingabeSpeichern.setOnAction(actionEvent -> {
            final String catName = eingabeKatzenname.getText();
            final int alter = Integer.parseInt(eingabeKatzenalter.getText());
            final String impfung = eingabeImpfung.getText();
            final double katzenGewicht = Double.parseDouble(eingabeGewicht.getText());
            final boolean rUnd = rund.isSelected();
            final boolean sUss = suess.isSelected();
            catcontainer.CatKreation(catName, alter, impfung, katzenGewicht, rUnd, sUss);
            neuesWindow.close();
        });
        eingabeAbbrechen.setOnAction(actionEvent -> neuesWindow.close());
        neuesWindow.show();
    }
}
