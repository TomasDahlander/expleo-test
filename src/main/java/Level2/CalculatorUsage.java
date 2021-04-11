package Level2;

import java.util.Scanner;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-11 <br>
 * Time: 09:41 <br>
 * Project: expleo-test <br>
 */
public class CalculatorUsage {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner input = new Scanner(System.in);
        while(true) {
            String expression = input.nextLine();
            try {
                double answer = calculator.evaluate(expression);
                System.out.println(answer);
            }catch(IndexOutOfBoundsException e){
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


/*
calculator.evaluate("2+30+4"); // returns 36
calculator.evaluate("2 - 3 + 4 + 15"); // returns 18
calculator.evaluate("2 * 3 * 4"); // returns 24
calculator.evaluate("2 * 3 / 4 * 20”); // returns 30
 */