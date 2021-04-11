package Level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-11 <br>
 * Time: 09:40 <br>
 * Project: expleo-test <br>
 */
public class Calculator {

    public double evaluate(String expression) throws Exception {
        expression = expression.replace(" ","");

        char[] sequence = expression.toCharArray();

        List<Character> chars;
        List<Double> numbers;

        if(expression.contains("+") || expression.contains("-")){
            chars = getOperatorList(expression,'+','-','*','/');
        }
        else{
            chars = getOperatorList(expression,'*','/','+','-');
        }
        numbers = getNumberList(expression);
        return getResult(chars,numbers);
    }

    private List<Character> getOperatorList(String expression, char operator1, char operator2, char wrongOperator1, char wrongOperator2) throws Exception {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            char operator = expression.charAt(i);
            if(operator == operator1 || operator == operator2) list.add(operator);
            else if(operator == wrongOperator1 || operator == wrongOperator2) throw new Exception("Expression can't mix operators (+,-) with (*,/)");
        }
        return list;
    }

    private List<Double> getNumberList(String expression){
        List<Double> list = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            try{
                list.add(Double.parseDouble(String.valueOf(expression.charAt(i))));
            }catch(Exception e) {
                // continue with next char in list
            }
        }
        return list;
    }

    private double getResult(List<Character> chars, List<Double> numbers) throws Exception {
        double answer = 0;
        while(chars.size() > 0){
            double operator1 = numbers.remove(0);
            double operator2 = numbers.remove(0);
            char c = chars.remove(0);
            answer = getPartialResult(operator1,operator2,c);
            numbers.add(0,answer);
        }
        return answer;
    }

    private double getPartialResult(double operator1, double operator2, char operator) throws Exception {
        if(operator2 == 0 && operator == '/') throw new Exception("Can't divide by zero");
        switch (operator) {
            case '+': return operator1 + operator2;
            case '-': return operator1 - operator2;
            case '*': return operator1 * operator2;
            default: return operator1 / operator2;
        }
    }
}


/*
calculator.evaluate("2+30+4"); // returns 36
calculator.evaluate("2 - 3 + 4 + 15"); // returns 18
calculator.evaluate("2 * 3 * 4"); // returns 24
calculator.evaluate("2 * 3 / 4 * 20”); // returns 30
 */