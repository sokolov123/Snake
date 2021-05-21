package view;

import model.Apple;
import model.Snake;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class EatAppleTest {
    private Apple apple;
    private Snake s;

    @Test
    void Eat() {
        int length=100;
        EatApple eatApple = new EatApple(s, apple, length);
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
}