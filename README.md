# expleo-test

Problem 1: Detect Anagram

For this assignment I created the class AnagramChecker and the test class AnagramCheckerTest. 
In the AnagramChecker class there is only one method that returns a boolean and takes 2 String. 
For each String the method changes all character to lowercase, removes all black spaces, 
creates a Char array based on the String and then sorts them using the Arrays.sort method. 
After this it simply returns the comparison between the two arrays. 

Run the test in the class AnagramCheckerTest to test solution. 


Problem 2: Find all links on a web page

Since I haven't heard about this before I left this for last and since time was an issue I 
decided to focus on the other problems, hence no solution. 


Problem 3: Calculator

For these assignments I created 2 classes per level. One class called Calculator that had all the 
logic to come up with the solution for the mathematical expression and one CalculatorUsage class 
that took input from the user and used the Calculator class. 

Tests for these assignments is located in the CalculatorTest class. 

**************** Level 1 *****************
On the first level on this problem I created two methods in the Calculator class. One that received 
the mathematical expression, and a private support method that does the actual calculating. 
The first method finds out which mathematical operator that should be used and sends the appropriate 
arguments to the support method. Here it finds out the index of the operator in the expression String 
for use when later dividing the expression into two separate doubles for which to use in the operation.
Then it checks which character is in the parameter and executes the correct code for the operation 
and sends back a double with the answer. 

**************** Level 2 *****************
On the second level on the problem I added three instance objects. 
    * List of Character that will hold the mathematical operators
    * List of Doubles that will hold the operand values
    * StringBuilder that contains the mathematical expression

Here there are a few more steps. 
The main method uses other private method to help with the calculating.
It starts by removing all blank spaces and then checking the validity of the 
mathematical expression using the isCorrectExpression method that tests 
for a number of reasons why the mathematical expression should be deemed incorrect. 

Secondly it initiates the StringBuilder object with the expression given by the user. 

After this it calls the getLists method which fills up the two lists of operators and operands 
using another method separateValuesAndOperators to help with each step of the expression. 

After the two lists are complete it will return the results from the method getResult 
which uses another method getPartialResult that calculates a single expression like 2+4. 
Then it removes the used operand values and operators from the lists and returns the result, 
so it can be added in the lists of values in the beginning so another calculation can take place. 

It keeps doing this until the list of operators is empty and then the final result it sent back 
for display. 

