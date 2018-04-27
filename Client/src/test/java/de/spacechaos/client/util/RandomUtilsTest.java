package de.spacechaos.client.util;

import de.spacechaos.client.GameUnitTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomUtilsTest extends GameUnitTest {

    @Test
    public void test(){
        assertEquals(1, RandomUtils.getRandomNumber(1, 1));

        int max = 100;
        int min = 5;
        for(int i = 0; i < max*10; ++i){
            assertTrue(RandomUtils.getRandomNumber(min, max) < max + 1);
            assertTrue(RandomUtils.getRandomNumber(min, max) > min - 1);
        }

        assertTrue(RandomUtils.rollTheDice(1));
    }

}