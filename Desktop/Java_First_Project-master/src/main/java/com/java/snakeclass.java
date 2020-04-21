package com.java;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;
import static com.java.Main.cornersize;


enum Dir {
    left, right, up, down
}

//Główna klasa naszego węża
public class snakeclass {
    public Dir direction = Dir.left;
    public List<Corner> snake = new ArrayList<>();
    public boolean gameOver = false;
    public Color color = Color.WHITE;
    public int snakeNum = 0;
    // wąż jest zbudowany z kwadratów o współżednych x i y
    public static class Corner {
        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    public void nowywaz( int width,int height){
        snake.add(new snakeclass.Corner(width / 2, height / 2));
    }

//  poruszanie się węzem i jego obsługa
    public void ruchweza(GraphicsContext gc,int height, int width){
        if (gameOver) {
            gc.setFont(new Font("", 30));
            gc.setFill(color);
            gc.fillText("GAME OVER", width * cornersize + 15, height * cornersize / 4 * (snakeNum-1)+80 );
            return;
        }

        //Kierunek poruszania się węża
        switch (direction) {
            case up:
                snake.add(new snakeclass.Corner(snake.get(snake.size()-1).x,snake.get(snake.size()-1).y-1));
                if (snake.get(snake.size()-1).y < 0) {
                    gameOver = true;
                }
                break;
            case down:
                snake.add(new snakeclass.Corner(snake.get(snake.size()-1).x,snake.get(snake.size()-1).y+1));
                if (snake.get(snake.size()-1).y > height) {
                    gameOver = true;
                }
                break;
            case left:
                snake.add(new snakeclass.Corner(snake.get(snake.size()-1).x-1,snake.get(snake.size()-1).y));
                if (snake.get(snake.size()-1).x < 0) {
                    gameOver = true;
                }
                break;
            case right:
                snake.add(new snakeclass.Corner(snake.get(snake.size()-1).x+1,snake.get(snake.size()-1).y));
                if (snake.get(snake.size()-1).x > width) {
                    gameOver = true;
                }
                break;
        }

        //Sprawdzenie czy wszedł sam w siebie
        if(snake.size()>1){
            for (int i = 0 ; i < snake.size() - 1 ; i++ ){
                if (snake.get(snake.size() - 1).x == snake.get(i).x && snake.get(snake.size() - 1).y == snake.get(i).y ) {
                    gameOver = true;
                }
            }
        }

        for (Corner c : snake) {
            gc.setFill(color.LIGHTGREEN);
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
            gc.setFill(color);
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);
        }
        //Pomalowanie głowy węża na inny kolor
        gc.setFill(Color.GOLD);
        gc.fillRect(snake.get(snake.size()-1).x * cornersize , snake.get(snake.size()-1).y * cornersize ,
                cornersize - 5, cornersize - 5);

    }



}