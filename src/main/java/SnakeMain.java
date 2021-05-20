import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeMain extends JPanel implements ActionListener {

    private static JFrame jFrame;

    public static final int WIDTH = 35;
    public static final int HEIGHT = 35;
    public static final int SCALE = 30;
    public static int speed = 8;

    Snake s = new Snake(9, 20, 9, 19);

    Timer timer = new Timer(1000/speed, (ActionListener) this); // таймер

    Apple apple = new Apple(Math.abs((int) (Math.random()*SnakeMain.WIDTH - 1)), Math.abs((int) (Math.random()*SnakeMain.HEIGHT - 1)));

    public SnakeMain() {
        timer.start();
        addKeyListener(new Key());
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

        g.setColor(Color.red); // яблоко надо было отрисовыввать чуть раньше змейки
        g.fillOval(apple.positionX*SCALE + 5, apple.positionY*SCALE + 5, SCALE - 7, SCALE - 7);

        for (int l = 1; l< s.length; l++) { //рисую саму змеюку
            g.setColor(Color.green);
            g.fillRect(s.snakeCordX[l]*SCALE + 3, s.snakeCordY[l]*SCALE + 3, SCALE - 5,SCALE - 5);
            g.setColor(Color.yellow);
            g.fillRect(s.snakeCordX[0]*SCALE + 3, s.snakeCordY[0]*SCALE + 3, SCALE - 5,SCALE - 5);
        }
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Snake"); //заголовок окна
        jFrame.setSize(SnakeMain.WIDTH*SnakeMain.SCALE+15, SnakeMain.HEIGHT*SnakeMain.SCALE+8);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //сворачивать при закрытии
        jFrame.setLocationRelativeTo(null); //будет размещаться по дефолту по середине
        jFrame.setVisible(true); //окно видимое
        jFrame.setResizable(false); //нельзя изменять размер окна

        jFrame.add(new SnakeMain()); //добавляю отрисовщик чтобы он собственно рисовал
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        if (s.snakeCordX[0] == apple.positionX && s.snakeCordY[0] == apple.positionY) {
            apple.positionApple();
            s.length++;
        }
        for (int l = 1; l< s.length; l++) { //рисую саму змеюку
            if (s.snakeCordX[l] == apple.positionX && s.snakeCordY[l] == apple.positionY) {
                apple.positionApple();
            }
            if (s.snakeCordX[0] == s.snakeCordX[l] && s.snakeCordY[0] == s.snakeCordY[l]) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Game Over, noob");
                jFrame.setVisible(false); //небольшой кусочек который сделает так что окно моргнет, и занулятся данные
                s.length = 2;
                s.direction = 0;
                apple.positionApple();
                jFrame.setVisible(true);
                timer.start();
            }
        }

        repaint();
    }

    public class Key extends KeyAdapter { // описываю изменение движения
        public void keyPressed (KeyEvent event) {
            int key = event.getKeyCode();
            if (key == KeyEvent.VK_UP && s.direction != 2) s.direction = 0;
            if (key == KeyEvent.VK_RIGHT && s.direction != 3) s.direction = 1;
            if (key == KeyEvent.VK_DOWN && s.direction != 0) s.direction = 2;
            if (key == KeyEvent.VK_LEFT && s.direction != 1) s.direction = 3;
        }
    }

}
