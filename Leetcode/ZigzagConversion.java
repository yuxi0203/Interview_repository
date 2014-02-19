/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zigzagconversion;

/**The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * @author Xi Yu
 */
public class ZigzagConversion {  //篱笆加密算法
    //发现所有行的重复周期都是 2 * nRows - 2

    //对于首行和末行之间的行，还会额外重复一次，重复的这一次距离本周期起始字符的距离是 2 * nRows - 2 - 2 * i
    public String convert(String s, int nRows) {
        StringBuilder result = new StringBuilder();  
        if (nRows < 2) return s;  
        for (int i = 0;i < nRows;++i) {  
            for (int j = i;j < s.length();j += 2 * (nRows - 1)) {  
                result.append(s.charAt(j));  
                if (i > 0 && i < nRows - 1) {  
                    if (j + 2 * (nRows - i - 1) < s.length())  
                        result.append(s.charAt(j + 2 * (nRows - i - 1)));  
                }  
            }  
        }  
        return result.toString();  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
