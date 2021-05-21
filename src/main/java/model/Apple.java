package model;

import game.SnakeMain;

public class Apple {

    public int positionX;
    public int positionY;

    public Apple(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void positionApple() {
        positionX = Math.abs((int) (Math.random()* SnakeMain.WIDTH - 1));
        positionY = Math.abs((int) (Math.random()* SnakeMain.HEIGHT - 1));

    }

}