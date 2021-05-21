package controller;

import model.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Key extends KeyAdapter { // описываю изменение движения

    private Snake s;

    public Key(Snake s) {
        this.s = s;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_UP && s.direction != 2) s.direction = 0;
        if (key == KeyEvent.VK_RIGHT && s.direction != 3) s.direction = 1;
        if (key == KeyEvent.VK_DOWN && s.direction != 0) s.direction = 2;
        if (key == KeyEvent.VK_LEFT && s.direction != 1) s.direction = 3;
    }
}