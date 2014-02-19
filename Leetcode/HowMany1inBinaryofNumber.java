/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package howmany1inbinaryofnumber;

/**
 *任意给定一个32位无符号整数n，求n的二进制表示中1的个数，比如n = 5（0101）时，返回2，n = 15（1111）时，返回4
 * @author Xi Yu
 */
public class HowMany1inBinaryofNumber {

    /**为什么n &= (n – 1)能清除最右边的1呢？因为从二进制的角度讲，
     * n相当于在n - 1的最低位加上1。举个例子，8（1000）= 7（0111）+ 1（0001），
     * 所以8 & 7 = （1000）&（0111）= 0（0000），
     * 清除了8最右边的1（其实就是最高位的1，因为8的二进制中只有一个1）。
     * 再比如7（0111）= 6（0110）+ 1（0001），
     * 所以7 & 6 = （0111）&（0110）= 6（0110），清除了7的二进制表示中最右边的1（也就是最低位的1）
     * @param args the command line arguments
     */
    static int cal1(int x)
    {
    int count =0;
    while(x!=0)
    {
        count++;
        x&=(x-1);
    }
    return count;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        HowMany1inBinaryofNumber test = new HowMany1inBinaryofNumber();
        int result = cal1(15);
        System.out.println(result);
    }
    
}
