/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stringtointegeratoi;

/**
 *
 * @author Xi Yu
 */
public class StringtoIntegerATOI {
    public int atoi(String s) {  //digits must in front of all characters?
        s = s.trim();  
        long value = 0;  
        boolean isPositive = true;  
          
        for (int i = 0; i < s.length(); i++) {  
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {    //process first char
                if (s.charAt(i) == '-') {  
                    isPositive = false;  
                }  
            } 
            else{
                if (s.charAt(i) < '0' || s.charAt(i) > '9') break;  
                value = 10 * value + s.charAt(i) - '0'; 
            }
        }  
        value = isPositive == true ? value : value * -1;  //process sign
        if (value < -2147483648) {    //process overflow
            return -2147483648;  
        } else if (value > 2147483647) {  
            return 2147483647;  
        } else {  
            return (int) value;  
        }  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
