package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Cat;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CatDataGUI {

    public static void neuesFenster(final Stage menuWindow, ObservableList<Cat> cats) {
        final Scene scene = new Scene(new Group(), 520, 450);
        final Stage neuesWindow2 = new Stage();

        neuesWindow2.setTitle("Katzendatenbank");
        neuesWindow2.setScene(scene);
        neuesWindow2.initModality(Modality.WINDOW_MODAL);
        neuesWindow2.initOwner(menuWindow);
        neuesWindow2.setX(menuWindow.getX() + 20);
        neuesWindow2.setY(menuWindow.getY() + 20);

        final Label label;
        label = new Label("Katzendatenbank");
        label.setFont(new Font("Arial", 14));
        final TableView<Cat> table = new TableView<>();
        table.setEditable(true);

        final TableColumn<Cat, String> namenSpalte = new TableColumn<>("Name");
        final TableColumn<Cat, String> alterSpalte = new TableColumn<>("Alter");
        final TableColumn<Cat, String> impfdatumSpalte = new TableColumn<>("Impfdatum");
        final TableColumn<Cat, String> gewichtSpalte = new TableColumn<>( "Gewicht");
        final TableColumn<Cat, String> rundSpalte = new TableColumn<>("rund");
        final TableColumn<Cat, String> suessSpalte = new TableColumn<>( "suess");

        namenSpalte.setCellValueFactory(new PropertyValueFactory<Cat ,String>("name"));
        alterSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("alter"));
        impfdatumSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("impfdatum"));
        gewichtSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("gewicht"));
        rundSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("rund"));
        suessSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("suess"));

        table.setItems(cats);
        table.getColumns().addAll(namenSpalte, alterSpalte, impfdatumSpalte, gewichtSpalte, rundSpalte, suessSpalte);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Button backToMenu = new Button ("Zur??ck");

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(label, table, backToMenu);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        neuesWindow2.setScene(scene);
        neuesWindow2.show();
    }
}