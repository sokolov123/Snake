package model;

import game.SnakeMain;

public class Snake {
    public int length = 2;
    public int direction = 0;

    public int snakeCordX[] = new int[1225];
    public int snakeCordY[] = new int[1225];

    public Snake(int x1, int y1, int x2, int y2) {
        snakeCordX[0] = x1;
        snakeCordX[1] = x2;
        snakeCordY[0] = y1;
        snakeCordY[1] = y2;
    }

    public void move() {
        for (int l = length; l > 0; l--) { // делаю штобы остальная змейка шла за головой
            snakeCordX[l] = snakeCordX[l-1];
            snakeCordY[l] = snakeCordY[l-1];
        }

        if(direction == 0) snakeCordY[0]--;  // движение вверх
        if(direction == 1) snakeCordX[0]++;  // движение вправо
        if(direction == 2) snakeCordY[0]++;  // движение вниз
        if(direction == 3) snakeCordX[0]--;  // движение влево

        if (snakeCordX[0] > SnakeMain.WIDTH - 1) snakeCordX[0] = 0; //делаю переходы
        if (snakeCordX[0] < 0) snakeCordX[0] = SnakeMain.WIDTH - 1;

        if (snakeCordY[0] > SnakeMain.HEIGHT - 2) snakeCordY[0] = 0;
        if (snakeCordY[0] < 0) snakeCordY[0] = SnakeMain.HEIGHT - 2;
    }
}