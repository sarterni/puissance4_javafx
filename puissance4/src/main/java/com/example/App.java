package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {

        private static Scene scene;
        int gridSize = 6;
        int cellSize = 100;
        int gapSize = 10;

        public void start(Stage stage) {
                Pane racine = new Pane();
                Text text = new Text("Puissance 4");
                text.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                text.setFill(Color.BLACK);
                text.setX(350);
                text.setY(50);
                racine.getChildren().add(text);

                for (int col = 0; col < gridSize; col++) {
                        Button drop = new Button("Drop");
                        drop.setLayoutX(col * (cellSize + gapSize) + 100);
                        drop.setLayoutY(50);
                        final int column = col; // Colonne actuelle pour utilisation dans le lambda
                        drop.setOnAction(e -> {
                                // Créer un nouveau cercle chaque fois que le bouton est cliqué
                                Circle newCircle = new Circle(cellSize / 2.7);
                                newCircle.setFill(Color.RED);
                                // Positionner le cercle dans la colonne correspondante, à la dernière ligne
                                newCircle.setCenterX(column * (cellSize + gapSize) + 100 + cellSize / 2);
                                newCircle.setCenterY((gridSize - 1) * (cellSize + gapSize) + 100 + cellSize / 2);
                                racine.getChildren().add(newCircle);
                        });
                        racine.getChildren().add(drop);
                }

                for (int row = 0; row < gridSize; row++) {
                        for (int col = 0; col < gridSize; col++) {
                                Rectangle cell = new Rectangle(col * (cellSize + gapSize), row * (cellSize + gapSize),
                                                cellSize, cellSize);
                                cell.setFill(Color.WHITE);
                                cell.setStroke(Color.BLACK);
                                cell.setY(100);
                                cell.setX(100);
                                racine.getChildren().add(cell);
                                cell.setY(row * (cellSize + gapSize) + 100);
                                cell.setX(col * (cellSize + gapSize) + 100);
                        }
                }

                Circle circle = new Circle(150, 120, 50); // Position (150, 120) avec un rayon de 50
                circle.setFill(Color.WHITE); // Couleur initiale du cercle
                circle.setStroke(Color.BLACK); // Couleur du contour
                racine.getChildren().add(circle);
        
                // Création du bouton
                Button btnChangeToYellow = new Button("Changer couleur en jaune");
                btnChangeToYellow.setLayoutX(760); // Position X du bouton
                btnChangeToYellow.setLayoutY(160); // Position Y du bouton
        
                // Ajout du gestionnaire d'événements au bouton
                btnChangeToYellow.setOnAction(event -> {
                    circle.setFill(Color.YELLOW); // Change la couleur du cercle en jaune
                });
        
                racine.getChildren().add(btnChangeToYellow);

                Button btnChangeToRed = new Button("Changer couleur en rouge");
                btnChangeToRed.setLayoutX(760); // Position X du bouton
                btnChangeToRed.setLayoutY(200); // Position Y du bouton

                btnChangeToRed.setOnAction(event -> {
                    circle.setFill(Color.RED); // Change la couleur du cercle en rouge
                });

                racine.getChildren().add(btnChangeToRed);

                Scene scene = new Scene(racine, 1000, 800);

                stage.setScene(scene);
                stage.setTitle("Puissance 4");
                stage.show();
        }

        public static void main(String[] args) {
                launch();

        }
}