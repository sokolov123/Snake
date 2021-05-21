package game;

import controller.GameOver;
import controller.Key;
import model.Apple;
import model.Snake;
import view.EatApple;
import view.PaintApple;
import view.PaintSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeMain extends JPanel implements ActionListener {

    private static JFrame jFrame;

    public static final int WIDTH = 35;
    public static final int HEIGHT = 35;
    public static final int SCALE = 30;
    public static int speed = 8;
    public static int score = 0;

    Snake s = new Snake(9, 20, 9, 19);

    Timer timer = new Timer(1000/speed, (ActionListener) this); // таймер

    Apple apple = new Apple(Math.abs((int) (Math.random()*SnakeMain.WIDTH - 1)), Math.abs((int) (Math.random()*SnakeMain.HEIGHT - 1)));

    public SnakeMain() {
        timer.start();
        addKeyListener(new Key(s));
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);

        for (int x = 0; x < WIDTH*SCALE; x+=SCALE){ //отрисовываем клеточки
            g.setColor(Color.DARK_GRAY);
            g.drawLine(x, 0, x,HEIGHT*SCALE);
        }
        for (int y = 0; y < WIDTH*SCALE; y+=SCALE){ //отрисовываем клеточки теперь по y
            g.setColor(Color.DARK_GRAY);
            g.drawLine(0, y,WIDTH*SCALE, y);
        }

        PaintApple paintApple = new PaintApple(apple, SCALE, g);
        paintApple.ApplePrinter();

        PaintSnake paintSnake = new PaintSnake(apple, SCALE, g, s);
        paintSnake.SnakePrinter();
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Snake"); //заголовок окна
        jFrame.setSize(SnakeMain.WIDTH*SnakeMain.SCALE+15, SnakeMain.HEIGHT*SnakeMain.SCALE+58);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //сворачивать при закрытии
        jFrame.setLocationRelativeTo(null); //будет размещаться по дефолту по середине
        jFrame.setResizable(false); //нельзя изменять размер окна
        jFrame.add(new SnakeMain()); //добавляю отрисовщик чтобы он собственно рисовал
        jFrame.setVisible(true); //окно видимое
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();

        EatApple eatApple = new EatApple(s, apple, s.length, score);
        eatApple.Eat();

        for (int l = 1; l< s.length; l++) { //рисую саму змеюку
            if (s.snakeCordX[l] == apple.positionX && s.snakeCordY[l] == apple.positionY) {
                apple.positionApple();
            }
            if (s.snakeCordX[0] == s.snakeCordX[l] && s.snakeCordY[0] == s.snakeCordY[l]) {
                GameOver gameOver = new GameOver(jFrame,timer,s,apple, score);
                gameOver.diedSnake();

            }
        }
        repaint();
    }
}