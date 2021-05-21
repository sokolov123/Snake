package view;

import game.SnakeMain;
import model.Apple;

import java.awt.*;

public class PaintApple {

    private Apple apple;
    private int SCALE;
    private Graphics g;

    public PaintApple(Apple apple, int SCALE, Graphics g){
        this.apple = apple;
        this.SCALE = SCALE;
        this.g = g;
    }

    public void ApplePrinter() {
        g.setColor(Color.red); // яблоко надо было отрисовыввать чуть раньше змейки
        g.fillOval(apple.positionX * SCALE + 5, apple.positionY * SCALE + 5, SCALE - 7, SCALE - 7);
    }
}
