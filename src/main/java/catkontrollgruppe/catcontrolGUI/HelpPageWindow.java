package catkontrollgruppe.catcontrolGUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpPageWindow {
        public static void neuesFenster(final Stage hauptFenster) {
        final Stage helpWindow = new Stage();
        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        final Scene scene = new Scene(grid, 500, 280);
        helpWindow.setScene(scene);

        helpWindow.setTitle("Hilfe und Kontakt");
        helpWindow.initModality(Modality.WINDOW_MODAL);
        helpWindow.initOwner(hauptFenster);
        helpWindow.setX(hauptFenster.getX() + 40);
        helpWindow.setY(hauptFenster.getY() - 40);
        helpWindow.setOnCloseRequest( event -> {
            helpWindow.close();
        });

        final Text helpText = new Text("           Willkommen bei CatControl Hilfe und Kontakt \n \n" +
                        "\ndiese Seite ist nur rudimentär vorhanden und wird auch nicht entwickelt." +
                        "\n" +
                        "\nDieses Programm dient mir als Übungsplatz für den Einstieg in Java.\n" +
                        "\nAchtet bei der Ausführung darauf dass die Cats.json-Datei direkt in eurem" +
                        "\nNutzer-Verzeichnis ist. zB /user/MaxMustermann/Cats.json oder C:/Benutzer/" +
                        "\nMaxMustermann/Cats.json.\n \n" +
                        "\nKontakt zum Autor des Programms könnt ihr aufnehmen über die Email-Adresse " +
                        "\neckhardt.ingmar@gmx.de. Jobangebote sind auch Willkommen.");
        helpText.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        grid.add(helpText, 0, 0, 4, 1);
        final Button knopfOk = new Button("Ok");
        grid.add(knopfOk,1,1);
        knopfOk.setOnAction(actionEvent ->{ helpWindow.close();});
        helpWindow.show();
    }

}