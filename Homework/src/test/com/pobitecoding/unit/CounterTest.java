package test.com.pobitecoding.unit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.pobitecoding.unit.Counter;

public class CounterTest {

    @Test
    public void counterIncreaseTest() {
        Counter counter = new Counter();
        counter.setCount(10);
        counter.increase();
        assertEquals(11, counter.getCount());
    }
}