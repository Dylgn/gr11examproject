package dylanco;
/*
Dylan Grinton
1/7/2020

 */
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class FXMLController implements Initializable {

    MediaPlayer theme;
    @FXML private Label lblDeaths;
    @FXML private Button btnTwo;
    @FXML private ImageView imgTrophy;

    @FXML
    void start(ActionEvent event) throws IOException {
        theme.stop();
        MainApp.setRoot("game1", "Cube Man");
    }

    @FXML
    void two(ActionEvent event) throws IOException {
        theme.stop();
        MainApp.setRoot("game2", "Cube Man");
    }

    @FXML
    void quit(ActionEvent event) {
        //Alert Box Confirmation
        Alert exitConfirm = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        exitConfirm.setTitle("Confirmation");
        exitConfirm.setHeaderText("Are you sure you want to exit?");
        exitConfirm.setContentText("All your progress will be lost!");
        Optional<ButtonType> result = exitConfirm.showAndWait();

        if (result.get() == ButtonType.YES) {
            //Exit Game if User Agrees
            System.exit(0);
        }
    }

    @FXML
    void volume (ActionEvent event) {
        MainApp.changeVolume(theme);

        if (MainApp.cheat) {
            btnTwo.setDisable(false);
        }
    }

    @FXML
    void credits(ActionEvent event) {
        //Credits
        Alert creditBox = new Alert(Alert.AlertType.INFORMATION);
        creditBox.setTitle("Credits");
        creditBox.setHeaderText(null);
        creditBox.setContentText("Developed by Dylan Grinton\nTextures by https://opengameart.org/users/bevouliincom\n" +
                "Game Music by https://opengameart.org/users/codemanu\n" +
                "Menu Music by https://opengameart.org/users/mrpoly");
        creditBox.showAndWait();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        theme = new MediaPlayer((new Media(getClass().getResource("/menu.wav").toString())));
        theme.setVolume(MainApp.volume);
        theme.setCycleCount(MediaPlayer.INDEFINITE);
        theme.play();

        lblDeaths.setText("Deaths: " + MainApp.deaths);

        if (MainApp.win) {
            btnTwo.setDisable(false);
        }
        if (MainApp.win2) {
            imgTrophy.setVisible(true);
        }
    }    
}
