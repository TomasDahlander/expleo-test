package CalculatorTest.Level3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-11 <br>
 * Time: 09:40 <br>
 * Project: expleo-test <br>
 * Class that functions as a calculator for single String mathematical expression <br>
 */
public class Calculator3 {

    List<Character> chars = new ArrayList<>();
    List<Double> numbers = new ArrayList<>();
    StringBuilder string;

    /**
     * Method that checks what operator should be used depending on the mathematical expression
     * and uses another method with specified arguments.
     * Expression should be as per format example: 2+30-4+-2 or 2*4*2/3
     * @param expression A String that should contain a mathematical expression.
     * @return Double containing the result of the mathematical expression.
     * @throws Exception If the operation can't be performed due to wrong input parameters.
     */
    public double evaluate(String expression) throws Exception {
        expression = expression.replace(" ","");

        if(!isCorrectExpression(expression))
            throw new IllegalArgumentException("Expression can't start with [+,*,/] or end with an operator or contain a letter.");
        string = new StringBuilder(expression);

        getLists();
        return getResult();
    }

    /**
     * Method that check whether a mathematical expression is correct or not.
     * @param expression String that should contain a correct mathematical expression.
     * @return A boolean if the mathematical expression passes the test.
     */
    private boolean isCorrectExpression(String expression){
        boolean containsLetter = expression.matches(".*[a-zA-ZåäöÅÄÖ,]+.*");
        if(containsLetter) return false;
        char firstC = expression.charAt(0);
        char lastC = expression.charAt(expression.length()-1);
        if(firstC == '*' || firstC == '/' || firstC == '+') return false;
        else if(lastC == '+' || lastC == '-' || lastC == '*' || lastC == '/') return false;
        else return true;
    }

    /**
     * Method that checks if the first character is a minus sign and sends the appropriate arguments
     * to the separateValuesAndOperators method to fill up the classes lists correctly.
     */
    private void getLists(){
        while(string.length() > 0){
            if(string.charAt(0) == '-'){
                separateValuesAndOperators(1,"-");
            }
            else separateValuesAndOperators(0,"");
        }
    }

    /**
     * Method that based on the parameters starts to check the mathematical expressions first
     * or second character and fills up the classes lists accordingly.
     * @param startIndex int that's indicating if there is a minus sign before the first digit
     * @param startValue String with the start value for the current operand. Either blank or "-"
     */
    private void separateValuesAndOperators(int startIndex, String startValue){
        char operator;
        for (int i = startIndex; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i)) || string.charAt(i) == '.'){
                startValue += string.charAt(i);
            }
            else {
                operator = string.charAt(i);
                chars.add(operator);
                numbers.add(Double.parseDouble(startValue));
                string.delete(0,i+1);
                return;
            }
        }
        numbers.add(Double.parseDouble(startValue));
        string.delete(0,string.length());
    }

    /**
     * Method that goes through both lists of operators and values and sends one expression
     * at a time to the getPartialResult where this is calculated and then these are removed from the lists.
     * @return A double with the final result of the mathematical expression.
     * @throws Exception if the used method getPartialResult throws and exception.
     */
    private double getResult() throws Exception {

        for(int i = chars.size()-1; i >= 0; i--){
            if(chars.get(i) == '*' || chars.get(i) == '/'){
                double operator1 = numbers.remove(i);
                double operator2 = numbers.remove(i);
                char c = chars.remove(i);
                double firstPrecedenceResult = getPartialResult(operator1,operator2,c);
                numbers.add(i,firstPrecedenceResult);
            }
        }

        while(chars.size() > 0){
            double operator1 = numbers.remove(0);
            double operator2 = numbers.remove(0);
            char c = chars.remove(0);
            double result = getPartialResult(operator1,operator2,c);
            numbers.add(0,result);
        }
        double answer = numbers.get(0);
        numbers.clear();
        return answer;
    }

    /**
     * Method that
     * @param operator1 The first value of the mathematical expression.
     * @param operator2 The second value of the mathematical expression.
     * @param operator The character for which mathematical operator should be used.
     * @return A double with the result of a mathematical expression.
     * @throws Exception if division with zero occurs.
     */
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