package catkontrollgruppe.catcontrolGUI;


import catkontrollgruppe.CatControl;
import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.SortName;
import javafx.collections.ObservableList;
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

public class EditMenuGUI {

    public void neuesFenster(Stage hauptFenster, ObservableList<Cat> cats) {
        CatControl catControl = new CatControl ();

        VBox vBox = new VBox();
        String ausgabe;
        Text katzennamen;

        Text titel = new Text ("Bei welcher Katze willst du die Daten aktualisieren?\n" +
                "Du kannst sowohl das Impfdatum wie auch jede andere Information, \n" +
                "bis hin zum ihrem Namen verändern.");
        titel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        vBox.getChildren().add(titel);

        Button[] buttonDelete = new Button[cats.size()];
        Button[] buttonEdit = new Button [cats.size()];
        cats.sort(new SortName());
        for (int i = 0; i < cats.size(); i++ ) {
            ausgabe =   "\n\n     "+ cats.get(i).getName()+"" +
                    "\nAlter: "+ cats.get(i).getAlter()+ " Jahr(e) " +
                    "\nImpfdatum: "+ cats.get(i).getImpfdatum() +
                    "\nGewicht: " + cats.get(i).getGewicht()+" kg" +
                    "\nIst rund: " + cats.get(i).isRund() +
                    "\nIst süß: " + cats.get(i).isSuess();

            katzennamen = new Text (ausgabe);
            vBox.getChildren().add(katzennamen);
            buttonDelete[i] = new Button("Katze Nr. " + (i+1) + " löschen");
            vBox.getChildren().add(buttonDelete[i]);
            buttonEdit[i] = new Button("Katze Nr. " + (i+1) + " editieren");
            vBox.getChildren().add(buttonEdit[i]);
        }

        Button buttonBack = new Button("Zurück");

        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(10));
        BorderPane borderPane = new BorderPane(scrollPane);
        borderPane.setPadding(new Insets(25));
        borderPane.setBottom(buttonBack);

        Stage editorWindow = new Stage();
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

        for (int i = 0; i < cats.size(); i++) {

            buttonDelete[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    final String text = ((Button)event.getSource()).getText();
                    final String text2 = text.replaceAll("[^0-9]", "");
                    final int position = Integer.parseInt(text2);
                    final Cat deleteCat = cats.get((position-1));
                    catControl.deleteCat(deleteCat);
                    editorWindow.close();
                    catControl.openEditMenuWindow(hauptFenster);
                    JOptionPane.showMessageDialog(null, "Die Katze wurde aus dem Datensatz entfernt");
                }
            });

            buttonEdit[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    final String text = ((Button)event.getSource()).getText();
                    final String text2 = text.replaceAll("[^0-9]", "");
                    final int position = Integer.parseInt(text2)-1;
                    catControl.openCatEditWindow (editorWindow, cats.get(position));
                }
            });
        }
    }
}