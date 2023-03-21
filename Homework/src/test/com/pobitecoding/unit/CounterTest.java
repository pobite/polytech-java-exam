package test.com.pobitecoding.unit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.pobitecoding.unit.UpCounter;

public class CounterTest {

    @Test
    public void counterIncreaseTest() {
        UpCounter counter = new UpCounter();
        counter.setCount(10);
        counter.count();
        assertEquals(11, counter.getCount());
    }
}