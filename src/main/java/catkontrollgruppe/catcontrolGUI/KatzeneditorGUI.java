package catkontrollgruppe.catcontrolGUI;


import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.Catcontainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.List;

public class KatzeneditorGUI {
    private int katzenID;

    public static void neuesFenster(Stage hauptFenster) {
        final VBox vBox = new VBox();
        String ausgabe;
        Text katzennamen;

        final Text titel = new Text ("Bei welcher Katze willst du die Daten aktualisieren?\n" +
                "Du kannst sowohl das Impfdatum wie auch jede andere Information, \n" +
                "bis hin zum ihrem Namen verändern.");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        vBox.getChildren().add(titel);

        final Catcontainer catcontainer = new Catcontainer();
        final List<Cat> catlist = catcontainer.getCatlist();

        final Button[] buttonDelete = new Button[catlist.size()];
        final Button[] buttonEdit = new Button [catlist.size()];

        for (int i = 0; i < catlist.size(); i++ ) {
            ausgabe =   "\n\n     "+catlist.get(i).getName()+"" +
                    "\nAlter: "+ catlist.get(i).getAlter()+ " Jahr(e) " +
                    "\nImpfdatum: "+ catlist.get(i).getImpfdatum() +
                    "\nGewicht: " + catlist.get(i).getGewicht()+" kg" +
                    "\nIst süß: " + catlist.get(i).isSuess() +
                    "\nIst rund: " + catlist.get(i).isRund();

            katzennamen = new Text (ausgabe);
            vBox.getChildren().add(katzennamen);
            buttonDelete[i] = new Button("Katze Nr. " + (i+1) + " löschen");
            vBox.getChildren().add(buttonDelete[i]);
            buttonEdit[i] = new Button("Katze Nr. " + (i+1) + " editieren");
            vBox.getChildren().add(buttonEdit[i]);
        }

        final Button buttonBack = new Button("Zurück");

        final ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(10));
        final BorderPane borderPane = new BorderPane(scrollPane);
        borderPane.setPadding(new Insets(25));
        borderPane.setBottom(buttonBack);

        final Stage editorWindow = new Stage();
        editorWindow.setTitle("Editiere die Katzen");
        editorWindow.initModality(Modality.WINDOW_MODAL);
        editorWindow.setOnCloseRequest(actionEvent -> editorWindow.close());
        editorWindow.initOwner(hauptFenster);
        editorWindow.setX(+ 40);
        editorWindow.setY(+ 20);

        final Scene scene = new Scene(borderPane, 450, 520);
        editorWindow.setScene(scene);
        editorWindow.show();

        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent evt) {editorWindow.close();}
        });

        for (int i = 0; i < catlist.size(); i++) {

            buttonDelete[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    final String text = ((Button)event.getSource()).getText();
                    final String text2 = text.replaceAll("[^0-9]", "");
                    final int position = Integer.parseInt(text2);
                    final Cat deleteCat = catlist.get((position-1));
                    catcontainer.deleteCat(deleteCat);
                    editorWindow.close();
                    JOptionPane.showMessageDialog(null, "Die Katze wurde aus dem Datensatz entfernt");
                }
            });
            buttonEdit[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    final String text = ((Button)event.getSource()).getText();
                    final String text2 = text.replaceAll("[^0-9]", "");
                    final int position = Integer.parseInt(text2)-1;
                    CatEditGUI.neuesFenster(editorWindow, position);
                }
            });
        }
    }
}