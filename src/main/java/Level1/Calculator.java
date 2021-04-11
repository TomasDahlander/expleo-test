package Level1;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-10 <br>
 * Time: 17:39 <br>
 * Project: expleo-test <br>
 */
public class Calculator {

    public double evaluate(String expression) throws Exception {
        expression = expression.replace(" ","");

        if(expression.contains("+")) return getResult(expression,'+');
        else if(expression.contains("*")) return getResult(expression,'*');
        else if(expression.contains("/")) return getResult(expression,'/');
        else return getResult(expression,'-');
    }

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

/*
calculator.evaluate("2+30"); // returns 32
calculator.evaluate("2 * 3"); // returns 6
calculator.evaluate("2 -3"); // returns -1
calculator.evaluate("2 / 3"); // returns 0.6666666...
 */