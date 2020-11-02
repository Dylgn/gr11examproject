module dylanco {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens dylanco to javafx.fxml;
    exports dylanco;
}