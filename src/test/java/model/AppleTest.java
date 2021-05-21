package model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AppleTest {

    @Test
    void getPositionX() {
        int x=100;
        int y=250;
        Apple apple=new Apple(x,y);
        assertEquals(x,apple.getPositionX());
    }

    @Test
    void setPositionX() {
        int x=100;
        int y=250;
        Apple apple=new Apple(x,y);
        apple.setPositionX(50);
        assertEquals(50,apple.getPositionX());

    }

    @Test
    void getPositionY() {
        int x=100;
        int y=250;
        Apple apple=new Apple(x,y);
        assertEquals(y,apple.getPositionY());
    }

    @Test
    void setPositionY() {
        int x=100;
        int y=250;
        Apple apple=new Apple(x,y);
        apple.setPositionY(20);
        assertEquals(20,apple.getPositionY());
    }

    @Test
    void positionApple() {
        int x=100;
        int y=250;
        Apple apple=new Apple(x,y);
        apple.positionApple();
        boolean chek=false;
        if (x!=apple.getPositionX() && y!=apple.getPositionY()){
            chek=true;
        }
        assertEquals(true,chek);
    }
}