package test.com.pobitecoding.banktest;

import static org.junit.Assert.*;
import org.junit.Test;
import com.pobitecoding.banktest.Bank;

public class BankTest {

    @Test
    public void nameTest() {
        Bank bank = new Bank();
        
        // 3글자로 했을 경우
        bank.setName("기업은");
        assertEquals("기업행", bank.getName());
    }
}