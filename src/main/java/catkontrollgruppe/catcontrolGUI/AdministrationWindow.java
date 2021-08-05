package catkontrollgruppe.catcontrolGUI;

import catkontrollgruppe.catcontrolService.Cat;
import catkontrollgruppe.catcontrolService.CatService;
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

public class AdministrationWindow {

    public static void neuesFenster(final Stage hauptFenster2) {
        final Scene scene = new Scene(new Group(), 520, 450);
        final Stage neuesWindow2 = new Stage();

        neuesWindow2.setTitle("Katzendatenbank");
        neuesWindow2.setScene(scene);
        neuesWindow2.initModality(Modality.WINDOW_MODAL);
        neuesWindow2.initOwner(hauptFenster2);
        neuesWindow2.setX(hauptFenster2.getX() + 20);
        neuesWindow2.setY(hauptFenster2.getY() + 20);

        final Label label;
        label = new Label("Katzendatenbank");
        label.setFont(new Font("Arial", 14));
        final TableView<Cat> table = new TableView<>();
        table.setEditable(true);

        final CatService catService = new CatService();
        final ObservableList<Cat> catlist = catService.getCatlist();

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

        table.setItems(catlist);
        table.getColumns().addAll(namenSpalte, alterSpalte, impfdatumSpalte, gewichtSpalte, rundSpalte, suessSpalte);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        neuesWindow2.setScene(scene);
        neuesWindow2.show();
    }
}