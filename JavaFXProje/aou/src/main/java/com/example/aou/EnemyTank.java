package com.example.aou;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Düşman Tank sınıfı
public class EnemyTank extends Tank {
    private ImageView tankImageView;
    private String currentDirection;
    private boolean isFiring;
    private Pane gamePane;
    public int health;
    private int dusmanhealth;

    public EnemyTank(double initialX, double initialY,Pane gamePane) {
        this.tankImageView = new ImageView(new Image(getClass().getResourceAsStream("/HtankU2.gif")));
        this.tankImageView.setTranslateX(initialX);
        this.tankImageView.setTranslateY(initialY);
        tankImageView.setFitWidth(50); // Örnek bir genişlik
        tankImageView.setFitHeight(50); // Örnek bir yükseklik
        this.currentDirection = "U";
        this.isFiring = false;
        this.gamePane = gamePane;
        this.health = 3; // Başlangıçta tankın canını 3 olarak ayarla
        this.dusmanhealth = 1;


        gamePane.getChildren().add(tankImageView);
    }
    public int getHealth() {
        return health;
    }
    public ImageView getImageView() {
        return tankImageView;
    }
    public void reduceHealth() {
        health--;
        if (health <= 0) {
            destroyTank();
        }
    }
    public void destroyTank() {
        // Remove tank's ImageView from the gamePane
        gamePane.getChildren().remove(tankImageView);

        // Additional cleanup or game-ending logic can be added here
    }
    public void move() {
        // Rastgele bir yönde hareket et
        Random random = new Random();
        int randomDirection = random.nextInt(4);
        switch (randomDirection) {
            case 0:
                changeTankDirection("U");
                tankImageView.setTranslateY(tankImageView.getTranslateY() - 20);
                break;
            case 1:
                changeTankDirection("D");
                tankImageView.setTranslateY(tankImageView.getTranslateY() + 20);
                break;
            case 2:
                changeTankDirection("R");
                tankImageView.setTranslateX(tankImageView.getTranslateX() + 20);
                break;
            case 3:
                changeTankDirection("L");
                tankImageView.setTranslateX(tankImageView.getTranslateX() - 20);
                break;
        }

        // Rastgele ateş et
        int fireProbability = random.nextInt(100);
        if (fireProbability < 5 && !isFiring) {
            fireBullet();
            isFiring = true;
        } else {
            isFiring = false;
        }
    }

    public void changeTankDirection(String direction) {
        if (!direction.equals(currentDirection)) {
            currentDirection = direction;
            String imagePath = "/Htank" + direction + "2.gif";
            tankImageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
        }
    }

    private void fireBullet() {
        Bullet bullet = new Bullet(tankImageView, currentDirection, Game.enemyTanks,gamePane);
        gamePane.getChildren().add(bullet.getImageView());

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), e -> {
            bullet.move();

            // Check for collision with enemy tanks
            Iterator<EnemyTank> iterator = Game.enemyTanks.iterator();
            while (iterator.hasNext()) {
                EnemyTank enemyTank = iterator.next();
                if (bullet.getBounds().intersects(enemyTank.getImageView().getBoundsInParent())) {
                    // Collision detected, reduce tank's health
                    enemyTank.reduceHealth();

                    // Remove tank if health <= 0
                    if (enemyTank.health <= 0) {
                        iterator.remove(); // Remove the tank from the list
                        gamePane.getChildren().remove(enemyTank.getImageView()); // Remove the tank from the pane
                    }

                    // Remove bullet
                    gamePane.getChildren().remove(bullet.getImageView());
                    timeline.stop(); // Stop the timeline if a collision occurs
                    return;
                }
            }

            // Check for other collision conditions or game-ending conditions here
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}