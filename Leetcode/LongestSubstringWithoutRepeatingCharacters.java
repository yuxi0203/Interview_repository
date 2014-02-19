/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestsubstringwithoutrepeatingcharacters;
import java.util.HashMap;
/**
 *Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Xi Yu
 */

//利用hashmap来记录出现过的element和他们的index， 出现新elem后记录长度加1.当出现重复时，拿当前记录的长度和最大长度比较，记录larger one
//由于出现重复值后，前面的substring最大长度已定，所以更长的substring只可能从当前这个重复的elem或其之后开始计算。
//因此重置hashmap，以当前位置为初始index，向后继续查找。
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) { //该方法在O(n)线性时间即可完成.  同时可以用bruteforce方法，在O(n^2)下实现
        int max = Integer.MIN_VALUE;                                                     //如 for(int i = 0;i<length;i++){ ... for(int j = i,j<length;j++){..}..}
        int start = 0;          
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();  
        if(s.length()<1) return 0; 
        for(int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);  
            if( map.containsKey(c)){  
                for(int j=start;j<i;j++) {  
                    if(s.charAt(j)==c) break;  
                    map.remove(s.charAt(j));  
                }  
                start = map.get(c)+1;  
                map.put(c,i);  
            } else {  
                map.put(c,i);  
                if( i-start+1 > max ) max = i-start+1;  
            }  
        }  
        return max;  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
