/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluatereversepolishnotation;
import java.util.*;
/**Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author Xi Yu
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<tokens.length;i++){
            if(tokens[i].matches("^-?\\d+$")){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                switch(tokens[i]){
                    case "+":
                        result = num1+num2;
                        break;
                    case "-":
                        result = num1-num2;
                        break;
                    case "*":
                        result = num1*num2;
                        break;
                    case "/":
                        result = num1/num2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        String[] input = {"2","3","-"};

        System.out.println(test.evalRPN(input));
//        Stack<Integer> test = new Stack<Integer>();
//        int i = -1;
//        test.push(i);
//        System.out.println(test.peek());
    }
    
}
