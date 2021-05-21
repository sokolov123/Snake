package view;

import game.SnakeMain;
import model.Apple;
import model.Snake;

public class EatApple {

    private Snake s;
    private Apple apple;
    private int length;

    public EatApple(Snake s, Apple apple, int length){
        this.length = length;
        this.s = s;
        this.apple = apple;
    }

    public void Eat(){
        if (s.snakeCordX[0] == apple.positionX && s.snakeCordY[0] == apple.positionY) {
            apple.positionApple();
            s.length++;
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

}