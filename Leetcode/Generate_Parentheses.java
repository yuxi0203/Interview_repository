/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generate_parentheses;
 import java.util.ArrayList;
/**
 *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * @author Xi Yu
 */
public class Generate_Parentheses {
     public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) return result;
        generateRecursion("",0,0,n,result);
        return result;
    }
    
    private void generateRecursion(String str, int l, int r, int n, ArrayList<String> result)
    {
        if(l>n) return;                                         //巧妙的递归 
        if(l == n && r == n)                    //尽可能输出"（"， 直到"（"个数为n 再输出一个"）"，其后由于递归影响，
        {                                       //继续尽可能输出"（"直到（n-1)，然后反复这过程
            result.add(str);
        }
        else
        {
            generateRecursion(str+"(",l+1,r,n,result);
            if(l>r)
            {
                generateRecursion(str+")",l,r+1,n,result);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
