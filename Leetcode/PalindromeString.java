/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palindromestring;
    
/**
 *
 * @author Xi Yu
 */
public class PalindromeString {
    public boolean isPalindrome(String s){  
        int i = 0;  
        int j = s.length()-1;  
        while(i<j){  
            if (s.charAt(i++) != s.charAt(j--)) return false;  
        }  
        return true;  
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PalindromeString test  = new PalindromeString();
        String input = "abcbaaaa";
        boolean result = test.isPalindrome(input);
        System.out.println(result);
    }
    
}
