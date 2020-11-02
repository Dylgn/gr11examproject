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

public class game1 implements Initializable {

    @FXML private Polygon plyGround1;
    @FXML private Polygon plyGround2;
    @FXML private Polygon plyGround3;

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

    @FXML private Polygon plySpike1;
    @FXML private Polygon plySpike2;
    @FXML private Polygon plySpike3;
    @FXML private Polygon plySpike4;
    @FXML private Polygon plySpike5;
    @FXML private Polygon plySpike6;
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

    @FXML private ImageView imgBackground;
    @FXML private ImageView imgTrophy;

    //Key and Lock
    @FXML private ImageView imgKey1;
    @FXML private ImageView imgKey2;
    @FXML private ImageView imgKey3;
    @FXML private ImageView imgLock1;
    @FXML private ImageView imgLock2;
    @FXML private ImageView imgLock3;

    //Moving Enemy And it's Boundaries
    @FXML private ImageView imgEnemy;
    @FXML private Polygon plyEnemy;
    @FXML private Polygon plyBorder1;
    @FXML private Polygon plyBox1;

    @FXML private ImageView imgEnemy1;
    @FXML private Polygon plyEnemy1;

    @FXML private ImageView imgEnemy2;
    @FXML private Polygon plyEnemy2;
    private double enemyGravity;
    private int enemyY;

    @FXML private ImageView imgEnemy3;
    @FXML private Polygon plyEnemy3;

    @FXML private ImageView imgEnemy4;
    @FXML private Polygon plyEnemy4;

    @FXML private ImageView imgEnemy5;
    @FXML private Polygon plyEnemy5;
    @FXML private Polygon plyBorder4;

    @FXML private ImageView imgEnemy6;
    @FXML private Polygon plyEnemy6;
    @FXML private Polygon plyBorder6;
    @FXML private Polygon plyBorder5;

    @FXML private ImageView imgEnemy7;
    @FXML private Polygon plyEnemy7;

    @FXML private Polygon plyBorder2;
    @FXML private Polygon plyBorder3;

    //All Sections of the Level
    @FXML private AnchorPane ancScene1;
    @FXML private AnchorPane ancScene2;
    @FXML private AnchorPane ancScene3;
    @FXML private AnchorPane ancScene4;

    //Checkpoints
    @FXML private Polygon plyFlag1;
    @FXML private Polygon plyFlag2;
    @FXML private Polygon plyFlag3;

    //Image, Shape & Anchor of Player
    //Image for Visuals, Polygon for Hitbox, Anchor for Movement
    @FXML private ImageView imgPlayer;
    @FXML private Polygon plyPlayer;
    @FXML private AnchorPane ancPlayer;

    //Variables for Timer
    private int x, y;
    private double gravity;
    private boolean canJump = true, canDJump = true;
    //Position of Last Checkpoint & In Which Pane
    private int flagPos[] = {14, 328};
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

    private int savedKeys[] = {0, 0, 0};

    //Array of Direction of moving enemies
    private int enemyMove[] = {-2, -2, -2, -2, -2, -2, -2};

    //If you are allowed to move (false when game is paused)
    private boolean canMove = true;
    //Player's Death count
    @FXML private AnchorPane ancPause;
    @FXML private Label lblDeaths;

    MediaPlayer theme;

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
            //Changes Background Image
            if (flagScene == ancScene1 || flagScene == ancScene2 || flagScene == ancScene4) {
                changeImage(imgBackground, "/levelOneBG.png");
            } else if (flagScene == ancScene3) {
                changeImage(imgBackground, "/levelOneBG-2.png");
            }
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
            moveEnemy(imgEnemy, plyEnemy, 0, plyBorder1, plyBox1);
            //New Checkpoints
            checkpoint(plyFlag1, 489, 315, ancScene1);
            //Restricted Areas
            if (getX(ancPlayer) < 0) {
                setX(ancPlayer, getX(ancPlayer) - x);
            } else if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        } else if (ancScene2.isVisible()) {
            //Moving Enemies
            moveEnemy(imgEnemy1, plyEnemy1, 1, plyWall12, plyWall13);
            jumpEnemy(imgEnemy2, plyEnemy2);
            moveEnemy(imgEnemy4, plyEnemy4, 3, plyWall10, plyWall9);

        } else if (ancScene3.isVisible()) {
            //Checkpoint
            checkpoint(plyFlag2, 131, 332, ancScene3);
            //Enemies
            moveEnemy(imgEnemy3, plyEnemy3, 2, plyBorder2, plyBorder3);
            //Restricted
            if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        } else if (ancScene4.isVisible()) {
            //Enemies
            moveEnemy(imgEnemy5, plyEnemy5, 4, plyWall35, plyBorder4);
            moveEnemy(imgEnemy6, plyEnemy6, 5, plyBorder6, plyBorder5);
            moveEnemy(imgEnemy7, plyEnemy7, 6, plyWall32, plyWall38);
            //Checkpoint
            checkpoint(plyFlag3, 322, 218, ancScene4);
            //Restricted Area Upward
            if (getY(ancPlayer) < 0) {
                setY(ancPlayer, getY(ancPlayer) - y);
                preventJump();
            }
        }

        //Going to new Sections
        if (getX(ancPlayer) + ancPlayer.getWidth() > 850) {
            //Going out of bounds to the right
            if (ancScene1.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene2);
                setX(ancPlayer, 0);
            } else if (ancScene2.isVisible()) {
                changeScene(ancScene4);
                setX(ancPlayer, 0);
            }
        } else if (getX(ancPlayer) < 0) {
            //Going out of bounds to the left
            if (ancScene2.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene1);
                setX(ancPlayer, 850 - ancPlayer.getWidth());
            } else if (ancScene4.isVisible()) {
                changeScene(ancScene2);
                setX(ancPlayer, 850 - ancPlayer.getWidth());
            }
        } else if (getY(ancPlayer) < 0) {
            //Going out of bounds upward
            if (ancScene2.isVisible()) {
                //Changes visibility of Scenes
                changeScene(ancScene3);
                setY(ancPlayer, 425 - ancPlayer.getHeight());
                if (checkCollision(plyPlayer, walls)) {
                    //If you get put into a wall
                    setY(ancPlayer, 0);
                    changeScene(ancScene2);
                    y = 0;
                    canJump = false;
                } else {
                    changeImage(imgBackground, "/levelOneBG-2.png");
                }
            }
        } else if (getY(ancPlayer) > 425) {
            //Going out of bounds downward
            if (ancScene3.isVisible()) {
                setY(ancPlayer, 0);
                changeScene(ancScene2);
                y = 0;
                canJump = false;
                changeImage(imgBackground, "/levelOneBG.png");
            }
        }

        //Getting the Trophy and Beating Level
        if (collision(ancPlayer, imgTrophy) && ancScene4.isVisible() && goOnce) {
            //goOnce used to only run this once
            //Would run twice if not put
            goOnce = false;
            theme.stop();
            timer.stop();
            MainApp.win = true;
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
                //Sets to 1 if only Key is Invisible (acquired)
                savedKeys[i] = 1;
                if (!locks.get(i).isVisible()) {
                    //Sets to 2 if Lock is also Invisible
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

    private void jumpEnemy(ImageView enemyImage, Polygon enemyPolygon) {
        if (y == -4) {
            //Jumps when you jump
            enemyY = -4;
        }
        setY(enemyImage, getY(enemyImage) + enemyY);
        setY(enemyPolygon, getY(enemyPolygon) + enemyY);
        //Follows Gravity
        if (enemyGravity < 20) {
            enemyGravity += 0.1;
        }
        setY(enemyImage, getY(enemyImage) + enemyGravity);
        setY(enemyPolygon, getY(enemyPolygon) + enemyGravity);
        //Collision Check
        if (checkCollision(enemyPolygon, walls)) {
            setY(enemyImage, getY(enemyImage) - enemyGravity);
            setY(enemyPolygon, getY(enemyPolygon) - enemyGravity);
            enemyGravity = 0;
            enemyY = 0;
        }

    }
    private void moveEnemy(ImageView enemyImage, Polygon enemyPolygon, int arrayPos, Polygon leftPoly, Polygon rightPoly) {
        //Moves Enemies
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
    private boolean checkCollision(Shape block1, ArrayList<Polygon> list) {
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
                    enemyGravity = 0;
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
            if (event.getCode() == KeyCode.F2) {
                changeScene(ancScene4);
            }
            if (event.getCode() == KeyCode.F1) {
                gravity = 0;
            }
            if (event.getCode() == KeyCode.F3) {
                for (ImageView image : keys) {
                    image.setVisible(false);
                }
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
            timer.stop();
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

        //Plays some music
        theme = new MediaPlayer((new Media(getClass().getResource("/levelOne.mp3").toString())));
        theme.setVolume(MainApp.volume);
        theme.setCycleCount(MediaPlayer.INDEFINITE);
        theme.play();

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        flagScene = ancScene1;

        //Adding Walls to List
        walls.add(plyGround1);
        walls.add(plyGround2);
        walls.add(plyGround3);
        walls.add(plyWall1);
        walls.add(plyWall2);
        walls.add(plyWall3);
        walls.add(plyWall4);
        walls.add(plyWall5);
        walls.add(plyBox1);
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
        //Adding Spikes to list
        spikes.add(plySpike1);
        spikes.add(plySpike2);
        spikes.add(plySpike3);
        spikes.add(plySpike4);
        spikes.add(plySpike5);
        spikes.add(plySpike6);
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
        //Adding Scenes to List
        scenes.add(ancScene1);
        scenes.add(ancScene2);
        scenes.add(ancScene3);
        scenes.add(ancScene4);
        //Key/Lock Combos
        keys.add(imgKey1);
        keys.add(imgKey2);
        keys.add(imgKey3);
        locks.add(imgLock1);
        locks.add(imgLock2);
        locks.add(imgLock3);

        spikes.add(plyEnemy);
        spikes.add(plyEnemy1);
        spikes.add(plyEnemy2);
        spikes.add(plyEnemy3);
        spikes.add(plyEnemy4);
        spikes.add(plyEnemy5);
        spikes.add(plyEnemy6);
        spikes.add(plyEnemy7);

        //Automatically set the first scene and hides all others
        changeScene(ancScene1);

        ancPause.setVisible(false);
    }    
}
