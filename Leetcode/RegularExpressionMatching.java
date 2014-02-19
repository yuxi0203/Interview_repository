/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regularexpressionmatching;

/**
 *Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * @author Xi Yu
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
 
        //p's length 1 is special case    
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));    
 
        }else{
            int len = s.length();
 
            int i = -1; 
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("abccca", "abc*a"));
    }
    
}
