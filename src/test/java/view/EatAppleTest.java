package view;

import model.Apple;
import model.Snake;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class EatAppleTest {
    private Apple apple;
    private Snake s;
    private int score;

    @Test
    void Eat() {
        int length=100;
        int score = 0;
        EatApple eatApple = new EatApple(s, apple, length, score);
        eatApple.eatApple();
        assertEquals(101,eatApple.getLength());
        eatApple.eatApple();
        assertEquals(102,eatApple.getLength());
        eatApple.eatApple();
        assertEquals(103,eatApple.getLength());
        eatApple.eatApple();
        assertEquals(104,eatApple.getLength());
        assertEquals(104,eatApple.getLength());
    }

    @Test
    void Score() {
        int length=100;
        int score = 0;
        EatApple eatApple = new EatApple(s, apple, length, score);
        eatApple.scorePlus();
        assertEquals(1, eatApple.getScore());
        eatApple.scorePlus();
        assertEquals(2, eatApple.getScore());
        eatApple.scorePlus();
        assertEquals(3, eatApple.getScore());
        eatApple.scorePlus();
        assertEquals(4, eatApple.getScore());
        assertEquals(4, eatApple.getScore());
    }
}