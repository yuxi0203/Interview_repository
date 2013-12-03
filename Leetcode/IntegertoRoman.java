/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integertoroman;
import java.util.HashMap;
/**
 *Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 * @author Xi Yu
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int i=0;
        while (num>0) {
            int times = num / nums[i];
            num -= nums[i]*times;
            for (; times>0; times--) {
                res.append(symbols[i]);
            }
            ++i;
        }
        return res.toString(); 
    }
    
    public int romanToInt(String s) {
        if (s.length()==0) return 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
    
        int n = s.length();
        int sum = map.get(s.charAt(n-1));
        for (int i=n-2; i>=0; i--) {
            if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i)))
                sum += map.get(s.charAt(i));
            else
                sum -= map.get(s.charAt(i));
        }
        return sum;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
