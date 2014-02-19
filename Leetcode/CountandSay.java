/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countandsay;

/**
 *The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Discuss


 * @author Xi Yu
 */
public class CountandSay {
    
    public String countAndSay(int n) {
       String ret = "1";
       int i = 1;
       while(i<n){
           ret = generate(ret);
           i++;
       }
       return ret;
    }
    
    private String generate(String s){
        String ret="";
        char pre = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length();i++){
            if(s.charAt(i) == pre){
                count ++;
            }   
            else{
                ret = ret+count+pre;  //+=不能使用 会显示时间超时 why？
                pre = s.charAt(i);//Use StringBuilder to improve the performance. In Java, operator "+="/append of String makes another copy of the string, which means a sequence of n operations will take time O(n^2). StringBuilder won't make new copies for appending.
                count = 1;
            }
        }
        ret = ret+count+pre;
        return ret;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
