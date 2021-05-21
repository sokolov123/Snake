package view;

import game.SnakeMain;
import model.Apple;
import model.Snake;

public class EatApple {

    private Snake s;
    private Apple apple;
    private int length;
    private int score;

    public EatApple(Snake s, Apple apple, int length, int score){
        this.length = length;
        this.s = s;
        this.apple = apple;
        this.score = score;
    }

    public void Eat(){
        if (s.snakeCordX[0] == apple.positionX && s.snakeCordY[0] == apple.positionY) {
            apple.positionApple();
            s.length++;
            SnakeMain.score++;
        }
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int eatApple(){
        return length++;
    }


    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int scorePlus(){
        return score++;
    }

}