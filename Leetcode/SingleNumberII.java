/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singlenumberii;
import java.util.ArrayList;
/**
 *Given an array of integers, every element appears three times except for one. Find that single one.
 * @author Xi Yu
 */
public class SingleNumberII {

    /**
     * @param args the command line arguments
     */
     public int singleNumber(int[] A) {     //用3个整数来表示INT的各位的出现次数情况，one表示出现了1次，two表示出现了2次。当出现3次的时候该位清零。最后答案就是one的值。
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < A.length; i++) {    
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
     
    public int singleNumber32bit(int[] A) {  //2nd solution: Each int consists of 32bit. For each bit, go through numbers and if the count is multiple of 3, 
                                               //the result should have that bit set.
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (0x1 << i)) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res |= (0x1 << i);
            }
        }
        return res;
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
       
        
    }
    
}
