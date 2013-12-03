/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lengthoflastword;

/**
 *
 * @author Xi Yu
 */
public class LengthofLastWord {
    public int lengthOfLastWord1(String s) {  //from the end to the front
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int result = 0;
        int length = s.length()-1;
        if(length < 0 ) return result;
        while(length>=0 && s.charAt(length) == ' ')  //delete all ' ' after the last word.
        {
            length -=1;
        }
        while(length >= 0)
        {   if(s.charAt(length) == ' ')
            {
                break;
            }
            result += 1;
            length -= 1;
        }
        return result;
    }
    
    public int lengthOfLastWord(String s) { //from the front to end
        int result = 0;
        int i=0;                            //遇到非空格加1，遇到空格则下一个检查直到末位，当遇到新的非空格时，result置0重新计数
        while(i< s.length())             //巧妙的运用if()语句中的i++，即使if语句不满足，也能让elseif语句中处理到i++的情况
        {
            if(s.charAt(i++) !=' ') result +=1;
            else if (i< s.length()-1 && s.charAt(i) != ' ')
            {
                result = 0;
            }
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
