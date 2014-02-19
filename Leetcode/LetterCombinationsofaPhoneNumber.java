/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lettercombinationsofaphonenumber;
import java.util.ArrayList;
/**
 *Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
 * @author Xi Yu
 */
public class LetterCombinationsofaPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
         
        ArrayList<String> ret = new ArrayList<String>();
        rec(ret, digits.length(), ss, digits, new StringBuffer());
        return ret;
    }
     
    public static void rec(ArrayList<String> ret, int remain, String[] ss, String digits, StringBuffer sb){
        if(remain == 0){
            ret.add(sb.toString());
            return;
        }
         
        String s = ss[digits.charAt(0)-'0'];        //get 3 characters which map the digits
        //equal :String s = ss[Integer.parseInt(String.valueOf(digits.charAt(0)))];
         
        for(int i=0; i<s.length(); i++){
            sb = sb.append(s.charAt(i));
            rec(ret, remain-1, ss, digits.substring(1), sb);  //In next round, choose next digits number:using substring(index)
            sb.deleteCharAt(sb.length()-1);   
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        //System.out.println(ss[(int)test.charAt(0)]);
        //System.out.println(ss[test.charAt(0)-'0']);
    }
    
}
