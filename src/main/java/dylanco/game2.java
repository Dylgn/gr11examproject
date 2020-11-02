package dylanco;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;


public class game2 implements Initializable {

    @FXML private AnchorPane ancScene1;
    @FXML private AnchorPane ancScene2;
    @FXML private AnchorPane ancScene3;
    @FXML private AnchorPane ancScene4;

    @FXML private Polygon plyWall1;
    @FXML private Polygon plyWall2;
    @FXML private Polygon plyWall3;
    @FXML private Polygon plyWall4;
    @FXML private Polygon plyWall5;
    @FXML private Polygon plyWall6;
    @FXML private Polygon plyWall7;
    @FXML private Polygon plyWall8;
    @FXML private Polygon plyWall9;
    @FXML private Polygon plyWall10;
    @FXML private Polygon plyWall11;
    @FXML private Polygon plyWall12;
    @FXML private Polygon plyWall13;
    @FXML private Polygon plyWall14;
    @FXML private Polygon plyWall15;
    @FXML private Polygon plyWall16;
    @FXML private Polygon plyWall17;
    @FXML private Polygon plyWall18;
    @FXML private Polygon plyWall19;
    @FXML private Polygon plyWall20;
    @FXML private Polygon plyWall21;
    @FXML private Polygon plyWall22;
    @FXML private Polygon plyWall23;
    @FXML private Polygon plyWall24;
    @FXML private Polygon plyWall25;
    @FXML private Polygon plyWall26;
    @FXML private Polygon plyWall27;
    @FXML private Polygon plyWall28;
    @FXML private Polygon plyWall29;
    @FXML private Polygon plyWall30;
    @FXML private Polygon plyWall31;
    @FXML private Polygon plyWall32;
    @FXML private Polygon plyWall33;
    @FXML private Polygon plyWall34;
    @FXML private Polygon plyWall35;
    @FXML private Polygon plyWall36;
    @FXML private Polygon plyWall37;
    @FXML private Polygon plyWall38;
    @FXML private Polygon plyWall39;
    @FXML private Polygon plyWall40;
    @FXML private Polygon plyWall41;
    @FXML private Polygon plyWall42;
    @FXML private Polygon plyWall43;
    @FXML private Polygon plyWall44;
    @FXML private Polygon plyWall45;
    @FXML private Polygon plyWall46;

    @FXML private Polygon plyGround1;
    @FXML private Polygon plyGround2;
    @FXML private Polygon plyGround3;
    @FXML private Polygon plyGround4;

    @FXML private Polygon plySpike1;
    @FXML private Polygon plySpike2;
    @FXML private Polygon plySpike3;
    @FXML private Polygon plySpike4;
    @FXML private Polygon plySpike5;
    @FXML private Polygon plySpike6;
    @FXML private Polygon plySpike7;
    @FXML private Polygon plySpike8;
    @FXML private Polygon plySpike9;
    @FXML private Polygon plySpike10;
    @FXML private Polygon plySpike11;
    @FXML private Polygon plySpike12;
    @FXML private Polygon plySpike13;
    @FXML private Polygon plySpike14;
    @FXML private Polygon plySpike15;
    @FXML private Polygon plySpike16;
    @FXML private Polygon plySpike17;
    @FXML private Polygon plySpike18;
    @FXML private Polygon plySpike19;
    @FXML private Polygon plySpike20;
    @FXML private Polygon plySpike21;
    @FXML private Polygon plySpike22;
    @FXML private Polygon plySpike23;

    @FXML private AnchorPane ancPause;
    @FXML private Label lblDeaths;

    @FXML private AnchorPane ancSpike1;

    @FXML private Polygon plyFlag1;
    @FXML private Polygon plyFlag2;
    @FXML private Polygon plyFlag3;

    @FXML private ImageView imgKey1;
    @FXML private ImageView imgLock1;

    @FXML private ImageView imgKey2;
    @FXML private ImageView imgLock2;

    @FXML private ImageView imgKey3;
    @FXML private ImageView imgLock3;

    @FXML private ImageView imgKey4;
    @FXML private ImageView imgLock4;

    //Player
    @FXML private AnchorPane ancPlayer;
    @FXML private ImageView imgPlayer;
    @FXML private Polygon plyPlayer;
    //Enemies
    @FXML private ImageView imgEnemy1;
    @FXML private Polygon plyEnemy1;

    @FXML private ImageView imgEnemy2;
    @FXML private Polygon plyEnemy2;
    @FXML private Polygon plyBorder1;

    @FXML private ImageView imgEnemy3;
    @FXML private Polygon plyEnemy3;

    @FXML private ImageView imgEnemy4;
    @FXML private Polygon plyEnemy4;

    @FXML private ImageView imgEnemy5;
    @FXML private Polygon plyEnemy5;

    //Variables for Timer
    private int x, y;
    private double gravity;
    private boolean canJump = true, canDJump = true;
    //Position of Last Checkpoint & In Which Pane
    private int flagPos[] = {10, 326};
    private AnchorPane flagScene;

    //Player Images
    private Image playerIdle = new Image(getClass().getResource("/player.png").toString());

    //Timers for basic functions & player walking animation
    private Timeline timer;

    //ArrayList of All Walls, Spikes & Scenes
    ArrayList<Polygon> walls = new ArrayList();
    ArrayList<Polygon> spikes = new ArrayList();
    ArrayList<AnchorPane> scenes = new ArrayList();
    //ArrayList of Key and Lock Combos
    ArrayList<ImageView> keys = new ArrayList();
    ArrayList<ImageView> locks = new ArrayList();
    private int savedKeys[] = {0, 0, 0, 0};

    //Array of last Polygons hit by moving enemies
    private int enemyMove[] = {-2, -2, -2, -2, -2};

    //If you are allowed to move (false when game is paused)
    private boolean canMove = true;

    MediaPlayer theme;

    @FXML private ImageView imgTrophy;
    boolean goOnce = true;

    private void timer() throws IOException {
        //Moves Player's X and Y
        setX(ancPlayer, getX(ancPlayer) + x);
        setY(ancPlayer, getY(ancPlayer) + y);

        //Horizontal Bounce Back
        if (checkCollision(plyPlayer, walls)) {
            setX(ancPlayer, getX(ancPlayer) - x);
            //If Still In Collision (Usually for Y-Value)
            if (checkCollision(plyPlayer, walls)) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        }

        //Resets Player when You Hit a Spike
        if (checkCollision(plyPlayer, spikes)) {
            //Resets Jumping
            y = 0;
            //Resets Keys/Locks
            resetKeys();
            //Resets Position to Last Checkpoint
            setX(ancPlayer, flagPos[0]); setY(ancPlayer, flagPos[1]);
            changeScene(flagScene);
            //Increase Deaths
            MainApp.deaths++;

        }

        //Increases Gravity As You Fall (Maximum of 20)
        if (gravity < 20) {
            gravity += 0.1;
        }
        setY(ancPlayer, getY(ancPlayer) + gravity);

        //Resets Falling Speed Once you hit a Wall (Or Go Below Map)
        //Gravity must also be greater than Player Jump Height
        if ((checkCollision(plyPlayer, walls) || getY(ancPlayer) + 45 > 650) && Math.abs(y) <= gravity) {
            setY(ancPlayer, getY(ancPlayer) - gravity);
            gravity = 0;
            y = 0;
            //Resets Jump & Double Jump
            canJump = true;
            canDJump = true;
            //Resets Image only If it isn't Idle
            if (imgPlayer.getImage() != playerIdle) {
                imgPlayer.setImage(playerIdle);
            }
        } else {
            //Can't Jump in midair
            canJump = false;
        }

        //Method for Checking For Key Collecting & Lock Unlocking
        unlock();

        //Scene-specific Actions
        if (ancScene1.isVisible()) {
            //Moving Enemies
            moveEnemy(imgEnemy1, plyEnemy1, 0, plySpike1, plyWall4);
            //Checkpoints
            checkpoint(plyFlag1, 561, 242, ancScene1);
            //Restricted Areas
            if (getX(ancPlayer) < 0) {
                setX(ancPlayer, getX(ancPlayer) - x);
            } else if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        } else if (ancScene2.isVisible()) {
            //Restricted Areas
            if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
            moveEnemy(imgEnemy2, plyEnemy2, 1, plyWall18, plyBorder1);
            //Moving Spike
            setX(ancSpike1, getX(ancSpike1) - 3);
            if (collision(plySpike12, plyWall14)) {
                setX(ancSpike1, 796);
                //Random Location
                setY(ancSpike1, ThreadLocalRandom.current().nextInt(266,340+1));
            }
        } else if (ancScene3.isVisible()) {
            //Checkpoints
            checkpoint(plyFlag2, 226, 313, ancScene3);
            //Moving Enemies
            moveEnemy(imgEnemy3, plyEnemy3, 2, plyWall24, plyWall30);
            moveEnemy(imgEnemy4, plyEnemy4, 3, plyWall27, plyWall32);
            //Restricted Areas
            if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        } else if (ancScene4.isVisible()) {
            //Checkpoints
            checkpoint(plyFlag3, 355, 188, ancScene4);
            //Enemies
            moveEnemy(imgEnemy5, plyEnemy5, 4, plyWall33, plyWall34);
            //Restricted Areas
            if (getX(ancPlayer) > 850) {
                setX(ancPlayer, getX(ancPlayer) - x);
            } else if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        }

        if (getX(ancPlayer) + ancPlayer.getWidth() > 850) {
            //Going out of bounds to the right
            if (ancScene1.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene2);
                setX(ancPlayer, 0);
                if (checkCollision(plyPlayer, walls)) {
                    //If you get put into a wall
                    setX(ancPlayer, 850 - ancPlayer.getWidth());
                    changeScene(ancScene1);
                }
            } else if (ancScene2.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene3);
                setX(ancPlayer, 0);
                if (checkCollision(plyPlayer, walls)) {
                    //If you get put into a wall
                    setX(ancPlayer, 850 - ancPlayer.getWidth());
                    changeScene(ancScene2);
                }
            }
        } else if (getX(ancPlayer) < 0) {
            //Going out of bounds to the left
            if (ancScene2.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene1);
                setX(ancPlayer, 850 - ancPlayer.getWidth());
            } else if (ancScene3.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene2);
                setX(ancPlayer, 850 - ancPlayer.getWidth());
            } else if (ancScene4.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene3);
                setX(ancPlayer, 850 - ancPlayer.getWidth());
                if (checkCollision(plyPlayer, walls)) {
                    //If you get put into a wall
                    setX(ancPlayer, 0);
                    changeScene(ancScene4);
                }
            }
        }
        //Getting the Trophy and Beating Level
        if (collision(ancPlayer, imgTrophy) && ancScene4.isVisible() && goOnce) {
            //goOnce used to only run this once
            //Would run twice if not put
            goOnce = false;
            theme.stop();
            timer.stop();
            MainApp.win2 = true;
            MainApp.setRoot("primary", "Main Menu");
            setX(ancPlayer, 0);
            setY(ancPlayer, 327);
        }
    }

    private void unlock() {
        //Checks all key/lock combos to unlock
        int i = 0;
        while (i < keys.size()) {
            //Collects Key if Visible (if key is visible & parent(scene) is visible)
            if (collision(ancPlayer, keys.get(i)) && keys.get(i).isVisible() && keys.get(i).getParent().isVisible()) {
                keys.get(i).setVisible(false);
            }
            //Removes Lock If You Have Key
            if (collision(ancPlayer, locks.get(i)) && locks.get(i).isVisible() && !keys.get(i).isVisible()) {
                locks.get(i).setVisible(false);
            } else if (collision(ancPlayer, locks.get(i)) && locks.get(i).isVisible() && locks.get(i).getParent().isVisible()) {
                //Push Back if still Visible and AnchorPane is Still Visible
                setX(ancPlayer, getX(ancPlayer) - x);
            }
            i++;
        }
    }

    private void updateKeys() {
        //Updates Keys/Locks Gained So They Do Not Get Reset on Death
        int i = 0;
        //savedKeys is set to 0 on Default
        while (i < keys.size()) {
            if (!keys.get(i).isVisible()) {
                //Sets to 1 if only Key is Visible
                savedKeys[i] = 1;
                if (!locks.get(i).isVisible()) {
                    //Sets to 2 if Lock is also Visible
                    savedKeys[i] = 2;
                }
            }
            i++;
        }
    }

    private void resetKeys() {
        //Resets Keys On Death
        int i = 0;
        while (i < keys.size()) {
            if (savedKeys[i] == 0) {
                //if None are Saved
                keys.get(i).setVisible(true);
                locks.get(i).setVisible(true);
            } else if (savedKeys[i] == 1) {
                //if Only Key
                locks.get(i).setVisible(true);
            }
            //Keep Invisible if savedKeys == 2 since both are saved
            i++;
        }
    }

    private void checkpoint(Polygon flag, int posX, int posY, AnchorPane scene) {
        if (collision(plyPlayer, flag)) {
            //Changes position array (0 - x, 1 -y) & scene where the flag is
            flagPos[0] = posX;
            flagPos[1] = posY;
            flagScene = scene;
            updateKeys();
        }
    }

    private void preventJump() {
        //Prevents Jumping
        y = 0;
        gravity = 0;
        canJump = false;
    }

    private void changeImage(ImageView image, String file) {
        image.setImage(new Image(getClass().getResource(file).toString()));
    }

    private void moveEnemy(ImageView enemyImage, Polygon enemyPolygon, int arrayPos, Polygon leftPoly, Polygon rightPoly) {
        //Moves Moving Enemies
        if (enemyMove[arrayPos] == -2) {
            //Moves Enemy
            setX(enemyImage, getX(enemyImage) + enemyMove[arrayPos]);
            setX(enemyPolygon, getX(enemyPolygon) + enemyMove[arrayPos]);
            //If Enemy Reaches its Boundary, Go other Way
            if (collision(enemyPolygon, leftPoly)) {
                enemyMove[arrayPos] = 2;
                enemyImage.setRotationAxis(new Point3D(0, 90, 1));
                enemyImage.setRotate(180);
            }
            //Moving Opposite Way
        } else if (enemyMove[arrayPos] == 2) {
            setX(enemyImage, getX(enemyImage) + enemyMove[arrayPos]);
            setX(enemyPolygon, getX(enemyPolygon) + enemyMove[arrayPos]);

            if (collision(enemyPolygon, rightPoly)) {
                enemyMove[arrayPos] = -2;
                enemyImage.setRotationAxis(new Point3D(0, 90, 1));
                enemyImage.setRotate(0);
            }
        }
    }

    private void changeScene(AnchorPane active) {
        //Change scenes
        for (AnchorPane scene : scenes) {
            //Makes all scenes invisible except for the given scene
            scene.setVisible(false);
        }
        active.setVisible(true);
    }

    //Change Object's X Values
    private static void setX(Node block1, double locX) { block1.setTranslateX(locX - block1.getLayoutX()); }
    private static double getX(Node block1) { return block1.getTranslateX() + block1.getLayoutX(); }

    //Change Object's Y Values
    public static void setY(Node block1, double locY) { block1.setTranslateY(locY - block1.getLayoutY()); }
    public static double getY(Node block1) { return block1.getTranslateY() + block1.getLayoutY(); }

    //Collison & Collision Checks
    public static boolean collision(Shape block1, Shape block2) {
//If the objects can be changed to shapes just see if they intersect
        Shape a = Shape.intersect(block1, block2);
        return a.getBoundsInLocal().getWidth() != -1;
    }
    public static boolean collision(Node block1, Node block2) {
//returns true if the areas intersect, false if they dont
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }
    private static boolean checkCollision(Shape block1, ArrayList<Polygon> list) {
        for (Polygon element : list) {
            //Checks collision for each and checks if parent of parent of element is visible (Different Sections)
            if (collision(block1, element) && element.getParent().getParent().isVisible()) {
                return true;
            }
        }
        return false;
    }

    //KeyPress / KeyRelease in MainApp
    @FXML
    void keyPress(KeyEvent event) {
        //Only runs if canMove is true
        if (canMove) {
            //Movement for player
            if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.SPACE) {
                if (canJump) {
                    //Jumps Only if Able to
                    y = -4;
                    imgPlayer.setImage(new Image(getClass().getResource("/playerJump.png").toString()));
                    canDJump = true;
                } else if (y == -4 && canDJump) {
                    //Double Jumps (if Possible) by Reseting gravity
                    y = -4;
                    gravity = 0;
                    canDJump = false;
                    imgPlayer.setImage(new Image(getClass().getResource("/playerDJump.png").toString()));
                }
            }
            if (event.getCode() == KeyCode.A) {
                x = -2;
                imgPlayer.setRotationAxis(new Point3D(0, 90, 1));
                imgPlayer.setRotate(180);
            }
            if (event.getCode() == KeyCode.D) {
                x = 2;
                imgPlayer.setRotationAxis(new Point3D(0, 90, 1));
                imgPlayer.setRotate(0);
            }
        }

        //Pause
        if (event.getCode() == KeyCode.ESCAPE) {
            //Checks if Timer is Paused
            if (timer.getStatus() == Animation.Status.PAUSED) {
                //Plays if Paused
                timer.play();
                canMove = true;
                ancPause.setVisible(false);
            } else {
                timer.pause();
                canMove = false;
                ancPause.setVisible(true);
                lblDeaths.setText("Deaths: " + MainApp.deaths);
            }

        }
        //Cheat
        if (MainApp.cheat) {
            if (event.getCode() == KeyCode.F1) {
                gravity = 0;
            }
            if (event.getCode() == KeyCode.F2) {
                flagPos[0] = 226;
                flagPos[1] = 313;
                flagScene = ancScene3;
            }
            if (event.getCode() == KeyCode.F3) {
                for (ImageView image : keys) {
                    image.setVisible(false);
                }
            }
            if (event.getCode() == KeyCode.F4) {
                changeScene(ancScene4);
            }
        }
    }

    @FXML
    void keyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.A) { x = 0; }
        if (event.getCode() == KeyCode.D) { x = 0; }
    }

    @FXML
    void lblResume(MouseEvent event) {
        timer.play();
        canMove = true;
        ancPause.setVisible(false);
    }

    @FXML
    void lblReturn(MouseEvent event) throws IOException {
        //Alert Box Confirmation
        Alert exitConfirm = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        exitConfirm.setTitle("Confirmation");
        exitConfirm.setHeaderText("Are you sure you want to return to menu");
        exitConfirm.setContentText("All your progress will be lost!");
        Optional<ButtonType> result = exitConfirm.showAndWait();

        if (result.get() == ButtonType.YES) {
            //Exit Level if User Agrees
            theme.stop();
            MainApp.setRoot("primary", "Main Menu");
        }

    }

    @FXML
    void lblVolume(MouseEvent event) {
        MainApp.changeVolume(theme);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Try/Catch Required for Moving Screens in Game
        timer = new Timeline(new KeyFrame(Duration.millis(10), ae -> {
            try {
                timer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        theme = new MediaPlayer((new Media(getClass().getResource("/levelTwo.mp3").toString())));
        theme.setVolume(MainApp.volume);
        theme.setCycleCount(MediaPlayer.INDEFINITE);
        theme.play();

        ancPause.setVisible(false);

        flagScene = ancScene1;

        //Walls
        walls.add(plyGround1);
        walls.add(plyGround2);
        walls.add(plyGround3);
        walls.add(plyGround4);
        walls.add(plyWall1);
        walls.add(plyWall2);
        walls.add(plyWall3);
        walls.add(plyWall4);
        walls.add(plyWall5);
        walls.add(plyWall6);
        walls.add(plyWall7);
        walls.add(plyWall8);
        walls.add(plyWall9);
        walls.add(plyWall10);
        walls.add(plyWall11);
        walls.add(plyWall12);
        walls.add(plyWall13);
        walls.add(plyWall14);
        walls.add(plyWall15);
        walls.add(plyWall16);
        walls.add(plyWall17);
        walls.add(plyWall18);
        walls.add(plyWall19);
        walls.add(plyWall20);
        walls.add(plyWall21);
        walls.add(plyWall22);
        walls.add(plyWall23);
        walls.add(plyWall24);
        walls.add(plyWall25);
        walls.add(plyWall26);
        walls.add(plyWall27);
        walls.add(plyWall28);
        walls.add(plyWall29);
        walls.add(plyWall30);
        walls.add(plyWall31);
        walls.add(plyWall32);
        walls.add(plyWall33);
        walls.add(plyWall34);
        walls.add(plyWall35);
        walls.add(plyWall36);
        walls.add(plyWall37);
        walls.add(plyWall38);
        walls.add(plyWall39);
        walls.add(plyWall40);
        walls.add(plyWall41);
        walls.add(plyWall42);
        walls.add(plyWall43);
        walls.add(plyWall44);
        walls.add(plyWall45);
        walls.add(plyWall46);
        //Spikes
        spikes.add(plySpike1);
        spikes.add(plySpike2);
        spikes.add(plySpike3);
        spikes.add(plySpike4);
        spikes.add(plySpike5);
        spikes.add(plySpike6);
        spikes.add(plySpike7);
        spikes.add(plySpike8);
        spikes.add(plySpike9);
        spikes.add(plySpike10);
        spikes.add(plySpike11);
        spikes.add(plySpike12);
        spikes.add(plySpike13);
        spikes.add(plySpike14);
        spikes.add(plySpike15);
        spikes.add(plySpike16);
        spikes.add(plySpike17);
        spikes.add(plySpike18);
        spikes.add(plySpike19);
        spikes.add(plySpike20);
        spikes.add(plySpike21);
        spikes.add(plySpike22);
        spikes.add(plySpike23);

        spikes.add(plyEnemy1);
        spikes.add(plyEnemy2);
        spikes.add(plyEnemy3);
        spikes.add(plyEnemy4);
        spikes.add(plyEnemy5);
        //Keys & Locks
        keys.add(imgKey1);
        keys.add(imgKey2);
        keys.add(imgKey3);
        keys.add(imgKey4);

        locks.add(imgLock1);
        locks.add(imgLock2);
        locks.add(imgLock3);
        locks.add(imgLock4);
        //Scenes
        scenes.add(ancScene1);
        scenes.add(ancScene2);
        scenes.add(ancScene3);
        scenes.add(ancScene4);

        changeScene(ancScene1);
    }
}
