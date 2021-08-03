package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Catcontainer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AbschiedsfensterGUI {
    public static void neuesFenster(Stage hauptFenster) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(grid, 600, 300);
        Stage neuesWindow3 = new Stage();
        neuesWindow3.setScene(scene);

        neuesWindow3.setTitle("Auf Wiedersehen");
        neuesWindow3.initModality(Modality.WINDOW_MODAL);
        neuesWindow3.initOwner(hauptFenster);
        neuesWindow3.setX(hauptFenster.getX() + 10);
        neuesWindow3.setY(hauptFenster.getY() + 10);

        Text abschiedstext = new Text("Das Programm wird geschlossen");
        abschiedstext.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(abschiedstext, 0, 0, 4, 1);
        neuesWindow3.show();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(AbschiedsfensterGUI::closeCatControl, 1, TimeUnit.SECONDS);
    }

    protected static void closeCatControl()
    {System.exit(0);}
}