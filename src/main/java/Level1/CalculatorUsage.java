package Level1;

import java.util.Scanner;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-10 <br>
 * Time: 19:39 <br>
 * Project: expleo-test <br>
 */
public class CalculatorUsage {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner input = new Scanner(System.in);

        System.out.print("Write a math expression to solve example: 3+7\nWrite exit to quit: ");
        while(true) {
            String expression = input.nextLine();
            if(expression.equalsIgnoreCase("exit")) System.exit(0);
            try{
                double answer = calculator.evaluate(expression);
                System.out.println(Math.round(answer*100)/100.0);
            }catch(Exception e){
                System.out.println("Must enter a math expression in format example: 3 + 4\nand you can't divide by zero");
            }
            System.out.print("Write next math expression: ");
        }
    }
}
