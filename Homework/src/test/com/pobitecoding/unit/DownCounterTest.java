package test.com.pobitecoding.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.pobitecoding.unit.DownCounter;

public class DownCounterTest {

    @Test
    public void counterDecreaseTest() {
        DownCounter downCounter = new DownCounter();
        downCounter.setCount(10);
        downCounter.count();
        assertEquals(9, downCounter.getCount());
    }
}