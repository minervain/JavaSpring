package com.example.aou;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayerTank extends Tank {
    private ImageView tankImageView;
    private Pane gamePane;
    private int health;
    private ProgressBar healthBar;
    private int playerHealth = 3;

    public PlayerTank(double initialX, double initialY, Pane gamePane) {
        System.out.println("PlayerTank oluşturuluyor. X: " + initialX + " Y: " + initialY);

        this.tankImageView = new ImageView(new Image(getClass().getResourceAsStream("/HtankU.gif")));
        this.tankImageView.setFitWidth(50); // Uygun bir genişlik belirle
        this.tankImageView.setFitHeight(50); // Uygun bir yükseklik belirle
        this.tankImageView.setTranslateX(initialX);
        this.tankImageView.setTranslateY(initialY);
        this.gamePane = gamePane;
        this.health = 3;

        gamePane.getChildren().add(tankImageView);
    }

    public ImageView getImageView() {
        return tankImageView;
    }

    public void reduceHealth() {
        health--;
        if (health <= 0) {
            // Oyuncu tankının canı 0 veya daha az oldu, oyunu bitirme işlemleri
            gameOver();
        }
        // Can azaldıktan sonra sağlık çubuğunu güncelle
        updateHealthDisplay();
    }
    private void updateHealthDisplay() {
        healthBar.setProgress((double) playerHealth / 3.0);
    }

    private void gameOver() {
        // Oyunun bitiş kodları...
        System.out.println("Game Over!");
    }
}
