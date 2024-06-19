package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

        private static Scene scene;
        int gridSize = 4;
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
                
                for (int row = 0; row < gridSize; row++) {
                        for (int col = 0; col < gridSize; col++) {
                                Rectangle cell = new Rectangle(col * (cellSize + gapSize), row * (cellSize + gapSize),
                                                cellSize, cellSize);
                                cell.setFill(Color.WHITE);
                                cell.setStroke(Color.BLACK);
                                racine.getChildren().add(cell);
                        }
                }

                Scene scene = new Scene(racine, 800, 500);
                stage.setScene(scene);
                stage.setTitle("Puissance 4");
                stage.show();
        }

        public static void main(String[] args) {
                launch();

        }
}