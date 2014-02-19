/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestpalindromicsubstring;
    
/**
 *Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author Xi Yu  最长子回文
 */
public class LongestPalindromicSubstring {
    boolean[][] dp;  
      
    public String longestPalindrome(String s)  
    {  
        if(s.length() == 0)  
        {  
            return "";  
        }  
        if(s.length() == 1)  
        {  
            return s;  
        }  
  
        dp = new boolean[s.length()][s.length()];  
          
        int i,j;  
          
        for( i = 0; i < s.length(); i++)  
        {  
            for( j = 0; j < s.length(); j++)  
            {  
                if(i >= j)  
                {  
                    dp[i][j] = true; //当i == j 的时候，只有一个字符的字符串; 当 i > j 认为是空串，也是回文  
  
                }  
                else  
                {  
                    dp[i][j] = false; //其他情况都初始化成不是回文  
                }  
            }  
        }  
          
        int k;  
        int maxLen = 1;  
        int rf = 0, rt = 0;  
        for( k = 1; k < s.length(); k++)  
        {  
            for( i = 0;  k + i < s.length(); i++)  
            {  
                j = i + k;  
                if(s.charAt(i) != s.charAt(j)) //对字符串 s[i....j] 如果 s[i] != s[j] 那么不是回文  
                {  
                    dp[i][j] = false;  
                }  
                else  //如果s[i] == s[j] 回文性质由 s[i+1][j-1] 决定  
                {  
                    dp[i][j] = dp[i+1][j-1];  
                    if(dp[i][j])  
                    {  
                        if(k + 1 > maxLen)  
                        {  
                            maxLen = k + 1;  
                            rf = i;  
                            rt = j;  
                        }  
                    }  
                }  
            }  
        }  
        return s.substring(rf, rt+1);  
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
