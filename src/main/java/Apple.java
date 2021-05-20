
public class Apple {

    public int positionX;
    public int positionY;

    public Apple(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void positionApple() {
        positionX = Math.abs((int) (Math.random()*SnakeMain.WIDTH - 1));
        positionY = Math.abs((int) (Math.random()*SnakeMain.HEIGHT - 1));

    }

}
