package catkontrollgruppe.catcontrolGUI;

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

public class QuitCControlGUI {
    public void neuesFenster(Stage hauptFenster) {

        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(12);
        grid.setHgap(12);
        grid.setPadding(new Insets(10, 10, 10, 10));

        final Scene scene = new Scene(grid, 400, 120);
        final Stage neuesWindow3 = new Stage();
        neuesWindow3.setScene(scene);
        neuesWindow3.setOnCloseRequest(actionEvent -> {System.exit(0);});

        neuesWindow3.setTitle("Auf Wiedersehen");
        neuesWindow3.initModality(Modality.WINDOW_MODAL);
        neuesWindow3.initOwner(hauptFenster);
        neuesWindow3.setX(hauptFenster.getX() + 40);
        neuesWindow3.setY(hauptFenster.getY() + 20);

        final Text abschiedstext = new Text("Das Programm wird geschlossen");
        abschiedstext.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(abschiedstext, 0, 0, 4, 1);
        neuesWindow3.show();

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(QuitCControlGUI::closeCatControl, 800, TimeUnit.MILLISECONDS);
    }

    protected static void closeCatControl()
    {System.exit(0);}
}