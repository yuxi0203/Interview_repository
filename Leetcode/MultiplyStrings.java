/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multiplystrings;

/**
 *Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 * @author Xi Yu
 *  直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。

    这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
 
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        for(int i = m-1; i>=0; i--){
            int carry = 0;
            for(int j = n-1; j>= 0; j--){
                int temp = (num2.charAt(j)-'0')*(num1.charAt(i)-'0') + carry + result[i+j+1];
                result[i+j+1] = temp%10;
                carry = temp/10;
            }
            result[i]=carry;
        }
        String res = "";
        for(int x : result){
            if(x!=0||!res.isEmpty()) res += x;
        }
        return (res.isEmpty())?"0":res;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
