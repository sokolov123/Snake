package controller;

import game.SnakeMain;
import model.Apple;
import model.Snake;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame{
    private JFrame jFrame;
    private Timer timer;
    private Snake s;
    private Apple apple;
    private int score;

    public GameOver(JFrame jFrame, Timer timer, Snake s, Apple apple, int score) throws HeadlessException {
        this.jFrame=jFrame;
        this.timer = timer;
        this.s = s;
        this.apple = apple;
        this.score = score;
    }

    public void diedSnake(){
        timer.stop();
        JOptionPane.showMessageDialog(null, "Game Over, noob \nYour score = " + score);
        JOptionPane.showMessageDialog(null, "New Game?");
        jFrame.setVisible(false); //небольшой кусочек который сделает так что окно моргнет, и занулятся данные
        s.length = 2;
        s.direction = 0;
        apple.positionApple();
        jFrame.setVisible(true);
        timer.start();

    }
}
