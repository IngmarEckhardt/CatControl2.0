package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatCache;
import catkontrollgruppe.catcontrolService.Catcontainer;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CatverwaltungGUI {

    public static void neuesFenster(Stage hauptFenster2) {
        Scene scene = new Scene(new Group(), 520, 450);
        Stage neuesWindow2 = new Stage();

        neuesWindow2.setTitle("Katzendatenbank");
        neuesWindow2.setScene(scene);
        neuesWindow2.initModality(Modality.WINDOW_MODAL);
        neuesWindow2.initOwner(hauptFenster2);
        neuesWindow2.setX(hauptFenster2.getX() + 20);
        neuesWindow2.setY(hauptFenster2.getY() + 20);

        Label label;
        label = new Label("Katzendatenbank");
        label.setFont(new Font("Arial", 14));
        TableView<Cat> table = new TableView();
        table.setEditable(true);

        Catcontainer catcontainer = new Catcontainer();
        ObservableList<Cat> catlist = catcontainer.getCatlist();

        TableColumn namenSpalte = new TableColumn<Cat, String>("Name");
        TableColumn alterSpalte = new TableColumn<Cat, String>("Alter");
        TableColumn impfdatumSpalte = new TableColumn<Cat, String>("Impfdatum");
        TableColumn gewichtSpalte = new TableColumn<Cat, String>( "Gewicht");
        TableColumn rundSpalte = new TableColumn<Cat, String>("rund");
        TableColumn suessSpalte = new TableColumn<Cat, String>( "suess");

        namenSpalte.setCellValueFactory(new PropertyValueFactory<Cat ,String>("name"));
        alterSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("alter"));
        impfdatumSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("impfdatum"));
        gewichtSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("gewicht"));
        rundSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("rund"));
        suessSpalte.setCellValueFactory(new PropertyValueFactory<Cat, String>("suess"));

        table.setItems(catlist);
        table.getColumns().addAll(namenSpalte, alterSpalte, impfdatumSpalte, gewichtSpalte, rundSpalte, suessSpalte);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 00, 20, 20));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        neuesWindow2.setScene(scene);
        neuesWindow2.show();
    }
}