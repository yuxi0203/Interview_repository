/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valid_parentheses;
import java.util.Stack;
/**
 *Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 *The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author Xi Yu
 */
public class Valid_Parentheses {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Character> temp = new Stack<Character>();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                temp.push(c);
            }
            else
            {
                if(temp.size() == 0) return false;
                char top = temp.pop();
                if (c == ')') {
                    if(top != '(') return false;
                } else if ( c == ']' ) {
                    if(top != '[') return false;
                } else if ( c == '}' ){
                    if(top != '{') return false;
                }
            }
        }
        return temp.size() == 0;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
