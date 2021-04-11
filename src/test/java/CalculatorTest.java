import Level1.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-11 <br>
 * Time: 20:03 <br>
 * Project: expleo-test <br>
 */
public class CalculatorTest {

    @Test
    public final void CalculatorTestLevel1(){
        Calculator calculator = new Calculator();
        try {
            assertEquals(2, calculator.evaluate("1+1"));
            assertEquals(6, calculator.evaluate("10-4"));
            assertEquals(10, calculator.evaluate("2*5"));
            assertEquals(3, calculator.evaluate("9/3"));
            assertNotEquals(5, calculator.evaluate("5+1"));
        }catch(Exception e){
            System.out.println("Wrong input");
        }
    }

    @Test
    public final void CalculatorTestLevel2(){
        Level2.Calculator calculator = new Level2.Calculator();
        try{
            assertEquals(3,calculator.evaluate("3+3+-3"));
            assertEquals(2,calculator.evaluate("3*2/3"));
            assertNotEquals(2,calculator.evaluate("5+4-3"));
        }catch (Exception e){
            System.out.println("Wrong input");
        }
    }

}
