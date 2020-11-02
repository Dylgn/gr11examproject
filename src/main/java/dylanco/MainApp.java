package dylanco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;


public class MainApp extends Application {
    private static Stage stage;
    public static int deaths = 0;
    public static double volume = 0.5;
    public static boolean win = false;
    public static boolean cheat = false;
    public static boolean win2 = false;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        setRoot("primary","Main Menu");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        scene.getRoot().requestFocus();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void changeVolume(MediaPlayer theme) {
        try {
            //User-Input Volume
            TextInputDialog dialog = new TextInputDialog(Double.toString(MainApp.volume * 100));
            dialog.setTitle("Volume");
            dialog.setHeaderText("Volume should be between 0-100");
            dialog.setContentText("New Volume: ");
            Optional<String> result = dialog.showAndWait();

            //Enabling Cheats
            if (result.isPresent()) {
                if (result.get().equals("/cheat")) {
                    cheat = true;
                    win = true;
                }

                if (Double.parseDouble(result.get()) > 100 || Double.parseDouble(result.get()) < 0) {
                    //Error if not within 0-100
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Error");
                    error.setHeaderText(null);
                    error.setContentText("Value not recognized!\nVolume should be between 0-100");
                    error.showAndWait();
                } else {
                    //Changes Volume
                    MainApp.volume = Double.parseDouble(result.get()) / 100;
                    theme.setVolume(MainApp.volume);
                }
            }
        } catch (NumberFormatException e) {
            //Doesn't receive a double
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setContentText("Value not recognized!\nVolume should be between 0-100");
            error.showAndWait();
        }
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
