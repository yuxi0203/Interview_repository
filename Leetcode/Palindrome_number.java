/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palindrome_number;

/**
 *
 * @author Xi Yu
 */
public class Palindrome_number {
    public boolean isPalindrome1(int x) {        // 左右比较
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(x == 0) return true;         //比较标准的比较，先遍历取得x是几位数， 以x/div来取得最左数字，x%10取个位数来比较
        else if(x < 0) return false;
        int div = 1;
        while(x/div >= 10)
        {
            div *=10;
        }
        while(x!=0)
        {
            int l = x/div;
            int r = x %10;
            if(l != r) return false;
            x = (x%div) /10;            //不用担心10101在比好第一次后，是否变成1和0比（因为忽略最左侧的0）， 因为是用除法取最左侧
            div/=100;                   //所以010变成10后再除以100，l依然是取0
        }
        return true;
    }
    
    public boolean isPalindrome2(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(x == 0) return true;         //该方法是以生成新数的方式检验，每次都生成个位数。由于对称，生成的数若和x相同则表示是对称的
        else if(x < 0) return false;
        int result = 0;
        int t = x;
        while(t>0)
        {
            result = result*10 + t%10;
            t/= 10;
        }
        return result == x;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
