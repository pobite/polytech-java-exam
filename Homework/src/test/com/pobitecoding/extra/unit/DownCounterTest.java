package test.com.pobitecoding.extra.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pobitecoding.extra.unit.DownCounter;

public class DownCounterTest {

    @Test
    public void counterDecreaseTest() {
        DownCounter downCounter = new DownCounter();
        downCounter.setCount(10);
        downCounter.count();
        assertEquals(9, downCounter.getCount());
    }
}