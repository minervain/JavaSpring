package com.example.aou;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;



import static com.example.aou.Game.enemyTanks;

public class TankGame extends Application {

    private ImageView tankImageView;
    private Pane gamePane;
    private String currentDirection = "U";
    private boolean isFiring = false;

    private ProgressBar healthBar;
    private int playerHealth = 3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane startPane = createStartPane(primaryStage);
        Scene startScene = new Scene(startPane, 1620, 920, Color.BLACK);
        primaryStage.setTitle("Tank Oyunu - Başlangıç Ekranı");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    private StackPane createStartPane(Stage primaryStage) {
        StackPane startPane = new StackPane();
        startPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Image backgroundImage = new Image(getClass().getResourceAsStream("/aoulogo.jpg"));
        ImageView backgroundImageView = new ImageView(backgroundImage);
        startPane.getChildren().add(backgroundImageView);

        Button startButton = new Button("Oyuna Başla");
        startButton.setOnAction(event -> startGame(primaryStage));
        startButton.setStyle("-fx-font-size: 20; -fx-background-color: gray;");
        startButton.setTextFill(Color.WHITE);
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(startButton);

        startPane.getChildren().add(vbox);

        return startPane;
    }

    private void createEnemyTanks() {
        for (int i = 0; i < 3; i++) {
            double initialX = Math.random() * 1600;
            double initialY = Math.random() * 900;
            EnemyTank enemyTank = new EnemyTank(initialX, initialY, gamePane);
            enemyTanks.add(enemyTank);
        }
    }
    private void moveEnemyTanks() {
        for (EnemyTank enemyTank : enemyTanks) {
            enemyTank.move();
        }
    }
    private void startGame(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene gameScene = new Scene(root, 1620, 920, Color.BLACK);

        gamePane = new Pane();
        root.getChildren().add(gamePane);

        tankImageView = new ImageView(new Image(getClass().getResourceAsStream("/HtankU.gif")));
        gamePane.getChildren().add(tankImageView);


        healthBar = new ProgressBar(1.0);
        healthBar.setPrefSize(200, 20);
        healthBar.setStyle("-fx-accent: red;");
        healthBar.setTranslateX(1400);
        healthBar.setTranslateY(13);
        gamePane.getChildren().add(healthBar);
        Image hpImage = new Image(getClass().getResourceAsStream("/hp.png"));
        ImageView hpImageView = new ImageView(hpImage);
        hpImageView.setFitWidth(30);
        hpImageView.setFitHeight(30);
        hpImageView.setTranslateX(1360);
        hpImageView.setTranslateY(10);
        gamePane.getChildren().add(hpImageView);


        gameScene.setOnKeyPressed(this::handleKeyPress);
        gameScene.setOnKeyReleased(this::handleKeyRelease);

        primaryStage.setScene(gameScene);
        createEnemyTanks();

        Timeline enemyTankMovement = new Timeline(new KeyFrame(Duration.millis(200), e -> {
            moveEnemyTanks();
        }));
        enemyTankMovement.setCycleCount(Timeline.INDEFINITE);
        enemyTankMovement.play();
    }

    private void moveTank(double deltaX, double deltaY) {
        tankImageView.setTranslateX(tankImageView.getTranslateX() + deltaX);
        tankImageView.setTranslateY(tankImageView.getTranslateY() + deltaY);
    }

    private void handleKeyPress(KeyEvent event) {
        KeyCode code = event.getCode();
        switch (code) {
            case UP:
                changeTankDirection("U");
                moveTank(0, -10);
                break;
            case DOWN:
                changeTankDirection("D");
                moveTank(0, 10);
                break;
            case RIGHT:
                changeTankDirection("R");
                moveTank(10, 0);
                break;
            case LEFT:
                changeTankDirection("L");
                moveTank(-10, 0);
                break;
            case SHIFT:
                if (!isFiring) {
                    fireBullet();
                    isFiring = true;
                }
                break;
        }
    }

    private void handleKeyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            isFiring = false;
        }
    }

    private void changeTankDirection(String direction) {
        if (!direction.equals(currentDirection)) {
            currentDirection = direction;
            String imagePath = "/Htank" + direction + ".gif";
            tankImageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
        }
    }

    private void fireBullet() {
        if (playerHealth > 0) {
            Bullet bullet = new Bullet(tankImageView, currentDirection, enemyTanks,gamePane);
            gamePane.getChildren().add(bullet.getImageView());

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(40), e -> {
                bullet.move();
                // Check for collisions or out-of-bounds here if needed
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();



            if (playerHealth == 0) {
                // Game over logic here
                // You may want to reset the game or show a game over screen
            }
        }
    }




}

