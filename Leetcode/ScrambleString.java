/*Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scramblestring;
import java.util.Arrays;
/**
 *
 * @author Xi Yu
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1 == s2) 
            return true;
        if(s1.length()!=s2.length()) 
            return false;
        
        char[]c1=s1.toCharArray(), c2=s2.toCharArray();  //Arrays.sort cant work on String, only work for array
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        if(!(new String(c1)).equals(new String(c2)))    //char is Primitive data type, can't use .equals() 
            return false;
        else if(s1.length()==1)return true;
        int n = s1.length();
        for(int i = 1; i<n; i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i))&&isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0,i), s2.substring(n-i))&&isScramble(s1.substring(i), s2.substring(0,n-i)))
                return true;
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public String sortString(String s){
        char[] target = s.toCharArray();
        Arrays.sort(target);
        String result=new String(target);
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ScrambleString test = new ScrambleString();
        char t1= 'a';
        char t2= 'a';
        System.out.println((new Character(t1)).equals(new Character(t2)));
        
        
    }
    
}
