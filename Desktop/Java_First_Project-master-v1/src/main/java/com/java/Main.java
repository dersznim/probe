package com.java;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class Main extends Application {
    // variable
    static int speed = 5;
    public static int width = 100;
    static int height = 100;
    static int cornersize = 10;
    static Random rand = new Random();
    static List<snakeclass> Snakes = new ArrayList<>();
    static int inter_width = 200;


    public void start(Stage primaryStage) {
        try {
            VBox root = new VBox();
            Canvas c = new Canvas(width * cornersize + inter_width, height * cornersize);
            GraphicsContext gc = c.getGraphicsContext2D();
            root.getChildren().add(c);

            new AnimationTimer() {
                long lastTick = 0;

                // Metoda odświeżająca klatki co określony czas
                public void handle(long now) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }

                    if (now - lastTick > 1000000000 / speed) {
                        lastTick = now;
                        tick(gc);
                    }
                }

            }.start();

            Scene scene = new Scene(root, width * cornersize + inter_width, height * cornersize);


            // dodanie/stworzenie obiektów węzy do listy
            for (int i = 1; i<5; i++){
                Snakes.add(new snakeclass());
                Snakes.get(i-1).snakeNum=i;
            }
            //Przepraszamy :(
            // Przypisanie wartości początkowych do węzy
            Snakes.get(0).nowywaz(width, height);
            Snakes.get(0).color = Color.BLACK;
            Snakes.get(0).direction=Dir.left;

            Snakes.get(1).nowywaz(width, height);
            Snakes.get(1).color = Color.BLUE;
            Snakes.get(1).direction=Dir.right;

            Snakes.get(2).nowywaz(width, height);
            Snakes.get(2).color = Color.RED;
            Snakes.get(2).direction=Dir.up;

            Snakes.get(3).nowywaz(width, height);
            Snakes.get(3).color = Color.BLUEVIOLET;
            Snakes.get(3).direction=Dir.down;



            // Kontrola poruszania się wężami
            scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
                        if (key.getCode() == KeyCode.W) {
                            Snakes.get(0).direction = Dir.up;
                        }
                        if (key.getCode() == KeyCode.A) {
                            Snakes.get(0).direction= Dir.left;
                        }
                        if (key.getCode() == KeyCode.S) {
                            Snakes.get(0).direction= Dir.down;
                        }
                        if (key.getCode() == KeyCode.D) {
                            Snakes.get(0).direction = Dir.right;
                        }


                        if (key.getCode() == KeyCode.T) {
                            Snakes.get(1).direction = Dir.up;
                        }
                        if (key.getCode() == KeyCode.F) {
                            Snakes.get(1).direction= Dir.left;
                        }
                        if (key.getCode() == KeyCode.G) {
                            Snakes.get(1).direction= Dir.down;
                        }
                        if (key.getCode() == KeyCode.H) {
                            Snakes.get(1).direction = Dir.right;
                        }


                        if (key.getCode() == KeyCode.I) {
                            Snakes.get(2).direction = Dir.up;
                        }
                        if (key.getCode() == KeyCode.J) {
                            Snakes.get(2).direction= Dir.left;
                        }
                        if (key.getCode() == KeyCode.K) {
                            Snakes.get(2).direction= Dir.down;
                        }
                        if (key.getCode() == KeyCode.L) {
                            Snakes.get(2).direction = Dir.right;
                        }


                        if (key.getCode() == KeyCode.F1) {
                            Snakes.get(3).direction = Dir.up;
                        }
                        if (key.getCode() == KeyCode.NUMPAD1) {
                            Snakes.get(3).direction= Dir.left;
                        }
                        if (key.getCode() == KeyCode.NUMPAD2) {
                            Snakes.get(3).direction= Dir.down;
                        }
                        if (key.getCode() == KeyCode.NUMPAD3) {
                            Snakes.get(3).direction = Dir.right;
                        }

                    }
            );

            // Pierdy do wyświetlania
            primaryStage.setScene(scene);
            primaryStage.setTitle("SNAKE GAME");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // tick - metoda wykonywana co klatkę odpowiedzialna za PORUSZANIE się węży
    // i za WYŚWIETLANIE OBRAZU
    public static void tick(GraphicsContext gc) {
        // fill
        // background
        gc.setFill(Color.GREY);
        gc.fillRect(0, 0, width * cornersize, height * cornersize);

        //interfejs background
        gc.setFill(Color.BLACK);
        gc.fillRect(width * cornersize ,0 , inter_width, height * cornersize);

        //player okienko
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(width * cornersize + 5, 5                             , inter_width-10, ((height * cornersize)/4)-10);
        gc.fillRect(width * cornersize + 5, (height * cornersize)/4+5, inter_width-10, ((height * cornersize)/4)-10);
        gc.fillRect(width * cornersize + 5, (height * cornersize)/2+5, inter_width-10, ((height * cornersize)/4)-10);
        gc.fillRect(width * cornersize + 5, (height * cornersize)/4*3+5, inter_width-10, ((height * cornersize)/4)-10);
        //Dane w okienkach graczy
        // score



        // Wyświetlanie wyników
        for(snakeclass d : Snakes) {
            gc.setFill(d.color);
            gc.setFont(new Font("", 20));
            gc.fillText("Score: " + d.snake.size(), width * cornersize + 15, height * cornersize / 4 * (d.snakeNum-1)+30);
        }


        for(int i = 0; i<4; i++) {
            Snakes.get(i).ruchweza(gc, height, width);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}