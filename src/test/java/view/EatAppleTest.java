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
        eatApple.scorePlus();
        assertEquals(101,eatApple.getLength());
        assertEquals(1, eatApple.getScore());
        eatApple.eatApple();
        eatApple.scorePlus();
        assertEquals(102,eatApple.getLength());
        assertEquals(2, eatApple.getScore());
        eatApple.eatApple();
        eatApple.scorePlus();
        assertEquals(103,eatApple.getLength());
        assertEquals(3, eatApple.getScore());
        eatApple.eatApple();
        eatApple.scorePlus();
        assertEquals(104,eatApple.getLength());
        assertEquals(4, eatApple.getScore());
        assertEquals(104,eatApple.getLength());
        assertEquals(4, eatApple.getScore());
    }
}