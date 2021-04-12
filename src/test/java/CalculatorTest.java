
import CalculatorTest.Level1.Calculator1;
import CalculatorTest.Level2.Calculator2;
import CalculatorTest.Level3.Calculator3;
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
        Calculator1 calculator = new Calculator1();
        try {
            assertEquals(32, calculator.evaluate("2+30"));
            assertEquals(6, calculator.evaluate("2 * 3"));
            assertEquals(-1, calculator.evaluate("2 - 3"));
            assertEquals(3, calculator.evaluate("9 / 3"));
            assertNotEquals(5, calculator.evaluate("5+1"));
        }catch(Exception e){
            System.out.println("Wrong input");
        }
    }

    @Test
    public final void CalculatorTestLevel2(){
        Calculator2 calculator = new Calculator2();
        try{
            assertEquals(4,calculator.evaluate("3+3+-2"));
            assertEquals(36,calculator.evaluate("2+30+4"));
            assertEquals(18,calculator.evaluate("2 - 3 + 4 + 15"));
            assertEquals(24,calculator.evaluate("2 * 3 * 4"));
            assertEquals(30,calculator.evaluate("2 * 3 / 4 * 20"));
            assertNotEquals(2,calculator.evaluate("5+4-3"));
        }catch (Exception e){
            System.out.println("Wrong input");
        }
    }

    @Test
    public final void CalculatorTestLevel3(){
        Calculator3 calculator = new Calculator3();
        try{
            assertEquals(122,calculator.evaluate("2+3*40"));
            assertEquals(10,calculator.evaluate("2 * 3 + 4"));
            assertEquals(3.5,calculator.evaluate("2 / 4 + 4 - 1"));
            assertEquals(-10,calculator.evaluate("2 - 3 * 4"));
            assertNotEquals(2,calculator.evaluate("5+4-3"));
        }catch (Exception e){
            System.out.println("Wrong input");
        }
    }
}
