/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package distinctsubsequences;

/**
 *Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
* 
* 给一个序列S和他的子序列T， 检验序列S的所有子序列中含有多少个子序列T
 * @author Xi Yu
 * 
 * 解法1： DFS得出S所有的子序列，然后一一对照
 * 解法2：利用DP的思想 http://blog.csdn.net/abcbc/article/details/8978146
 */
public class DistinctSubsequences {
     public int numDistinct(String S, String T) {
        int[][] dp = new int[T.length()+1][S.length()+1];
        dp[0][0] = 1;
        for(int i = 0; i<= T.length(); i++){  //when S is null; no match 
            dp[i][0] = 0;
        }
        for(int j = 0; j<= S.length(); j++){  //when T is null; 1 match
            dp[0][j] = 1;
        }
        for (int i = 1; i<= T.length(); i++){
            for (int j = 1; j<=S.length(); j++){
                dp[i][j] = dp[i][j-1];
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i][j]+dp[i-1][j-1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }


/*      r a b b b i t
      1 1 1 1 1 1 1 1
    r 0 1 1 1 1 1 1 1
    a 0 0 1 1 1 1 1 1
    b 0 0 0 1 2 3 3 3
    b 0 0 0 0 1 3 3 3
    i 0 0 0 0 0 0 3 3
    t 0 0 0 0 0 0 0 3  
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
