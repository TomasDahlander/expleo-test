package CalculatorTest.Level1;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-10 <br>
 * Time: 17:39 <br>
 * Project: expleo-test <br>
 */
public class Calculator1 {

    /**
     * Method that checks what operator should be used depending on the mathematical expression
     * and uses another method with specified arguments.
     * Expression should be as per format example: 2+3 or 6*22
     * @param expression A String that should contain a mathematical expression.
     * @return Double containing the result of the mathematical expression.
     * @throws Exception If the operation can't be performed due to wrong input parameters.
     */
    public double evaluate(String expression) throws Exception {
        expression = expression.replace(" ","");

        if(expression.contains("+")) return getResult(expression,'+');
        else if(expression.contains("*")) return getResult(expression,'*');
        else if(expression.contains("/")) return getResult(expression,'/');
        else return getResult(expression,'-');
    }

    /**
     * Support method that calculates an mathematical expression given as full expression
     * and a char indicating which operator should be used.
     * @param expression A String that should contain a mathematical expression.
     * @param operator A char that should be a mathematical operator like [+-/*].
     * @return Double containing the result of the mathematical expression.
     * @throws Exception If the operation can't be performed due to wrong input parameters.
     */
    private double getResult(String expression, char operator) throws Exception {
        int indexOfOperator = expression.lastIndexOf(operator);
        double firstNr = Double.parseDouble(expression.substring(0, indexOfOperator));
        double secondNr = Double.parseDouble(expression.substring(indexOfOperator+1));
        if(operator == '+') return firstNr + secondNr;
        else if (operator == '-') return firstNr - secondNr;
        else if (operator == '/') {
            if(secondNr == 0) throw new Exception();
            else return firstNr / secondNr;
        }
        else return firstNr * secondNr;
    }
}