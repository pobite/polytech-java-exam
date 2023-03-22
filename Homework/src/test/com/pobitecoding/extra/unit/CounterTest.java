package test.com.pobitecoding.extra.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pobitecoding.extra.unit.UpCounter;

public class CounterTest {

    @Test
    public void counterIncreaseTest() {
        UpCounter counter = new UpCounter();
        counter.setCount(10);
        counter.count();
        assertEquals(11, counter.getCount());
    }
}