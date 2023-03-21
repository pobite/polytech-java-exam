package test.com.pobitecoding.bank;

import static org.junit.Assert.*;
import org.junit.Test;
import com.pobitecoding.bank.Bank;

public class BankTest {

    @Test
    public void nameTest() {
        Bank bank = new Bank();
        
        // 4글자로 했을 경우
        bank.setName("기업은행");
        assertEquals("기업은행", bank.getName());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void throwsExcpetionWithThreeCharName() {
        // 4글자로 했을 경우
        Bank bank = new Bank();
        bank.setName("기업은행");
        assertEquals("기업은행", bank.getName());
    }
}