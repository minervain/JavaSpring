package com.example.aou;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Iterator;
import java.util.List;

public class Bullet {

    private ImageView imageView;
    private String direction;
    private Pane gamePane;
    private List<EnemyTank> enemyTanks;

    public Bullet(ImageView tankImageView, String direction, List<EnemyTank> enemyTanks, Pane gamePane) {
        this.direction = direction;
        this.enemyTanks = enemyTanks;
        this.gamePane = gamePane;

        this.imageView = new ImageView(new Image(getClass().getResourceAsStream("/star.png")));
        imageView.setTranslateX(tankImageView.getTranslateX());
        imageView.setTranslateY(tankImageView.getTranslateY());
        this.imageView.setFitWidth(10); // Uygun bir genişlik belirle
        this.imageView.setFitHeight(10); // Uygun bir yükseklik belirle
    }
    public Bullet(String direction) {
        this.direction = direction;
    }
    private void checkCollision() {
        Iterator<EnemyTank> iterator = enemyTanks.iterator();
        while (iterator.hasNext()) {
            EnemyTank enemyTank = iterator.next();
            if (isCollidingWithTank(enemyTank)) {
                // Mermi tanka çarptı, tankın canını azalt
                enemyTank.reduceHealth();

                // Remove tank if health <= 0
                if (enemyTank.health <= 0) {
                    iterator.remove(); // Remove the tank from the list
                    gamePane.getChildren().remove(enemyTank.getImageView()); // Remove the tank from the pane
                }

                // Remove bullet
                gamePane.getChildren().remove(imageView);
                return;
            }
        }

        if (Game.playerTank != null && isCollidingWithTank(Game.playerTank)) {
            // Mermi oyuncu tankına çarptı, oyuncu tankının canını azalt
            Game.playerTank.reduceHealth();
            // Mermiyi yok et
            destroyBullet();
        }
    }


    public void move() {
        System.out.println("Mermi hareket ediyor. X: " + imageView.getTranslateX() + " Y: " + imageView.getTranslateY());

        switch (direction) {
            case "U":
                imageView.setTranslateY(imageView.getTranslateY() - 12);
                break;
            case "D":
                imageView.setTranslateY(imageView.getTranslateY() + 12);
                break;
            case "R":
                imageView.setTranslateX(imageView.getTranslateX() + 12);
                break;
            case "L":
                imageView.setTranslateX(imageView.getTranslateX() - 12);
                break;
        }

        // Mermi her hareket ettiğinde çarpışmayı kontrol et
        checkCollision();
    }


    private boolean isCollidingWithTank(Tank tank) {
        if (tank != null) {
            return imageView.getBoundsInParent().intersects(tank.getImageView().getBoundsInParent());
        }
        return false;
    }

    private void destroyBullet() {
        // Mermiyi yok etme kodları...
        gamePane.getChildren().remove(imageView);
    }


    public ImageView getImageView() {
        return imageView;
    }
    public Bounds getBounds() {
        return imageView.getBoundsInParent();
    }
}