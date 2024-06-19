package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {

        private static Scene scene;

        public void start(Stage stage) {
                Pane racine = new Pane();
                int gridSize = 4;
                int cellSize = 100;
                int gapSize = 10;

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