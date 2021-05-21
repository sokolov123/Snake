package view;

import model.Apple;
import model.Snake;

import java.awt.*;

public class PaintSnake {

    private Apple apple;
    private int SCALE;
    private Snake s;
    private Graphics g;

    public PaintSnake(Apple apple, int SCALE, Graphics g, Snake s){
        this.apple = apple;
        this.SCALE = SCALE;
        this.g = g;
        this.s = s;
    }

    public void SnakePrinter() {
        for (int l = 1; l< s.length; l++) { //рисую саму змеюку
            g.setColor(Color.green);
            g.fillRect(s.snakeCordX[l]*SCALE + 3, s.snakeCordY[l]*SCALE + 3, SCALE - 5,SCALE - 5);
            g.setColor(Color.yellow);
            g.fillRect(s.snakeCordX[0]*SCALE + 3, s.snakeCordY[0]*SCALE + 3, SCALE - 5,SCALE - 5);
        }
    }
}