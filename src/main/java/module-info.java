module catkontrollgruppe.catcontrol2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens catkontrollgruppe.catcontrolGUI to javafx.fxml;
    exports catkontrollgruppe.catcontrolGUI;
    opens catkontrollgruppe.catController to javafx.fxml;
    exports catkontrollgruppe.catController;
    opens catkontrollgruppe.catcontrolService to javafx.fxml;
    exports catkontrollgruppe.catcontrolService;

}