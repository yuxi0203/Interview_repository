/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package add_binary;

/**
 *Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * @author Xi Yu
 */
public class Add_Binary {
     public String addBinary(String a, String b) {   //和加法器运算相似，但是有一个需要注意的地方是string需要给短的补0
        if(a == null || b == null) return null;
        int m = a.length();
        int n = b.length();
        if(m == 0 || n == 0) return null;
        int carry = 0;          //carry是进位
        String rl = "";
        for (int i = 0; i < Math.max(m, n); i++){
            int p = (i < m) ? a.charAt(m - 1 - i) - '0' : 0;
            int q = (i < n) ? b.charAt(n - 1 - i) - '0' : 0;
            int temp = carry + p + q;
            rl = temp % 2 + rl;  //整数和字符相加，整数在字符串前表示将整数加在字符串左侧
            carry = temp / 2;        //只有在temp是2或3时，才会添加一个carry=1 
        }
        return (carry == 0) ? rl : "1" + rl;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
