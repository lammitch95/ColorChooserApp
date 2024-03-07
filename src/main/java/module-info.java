module chooser.colorchooserapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens chooser.colorchooserapp to javafx.fxml;
    exports chooser.colorchooserapp;
}