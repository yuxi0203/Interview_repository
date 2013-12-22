/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestcommonprefix;
import java.lang.String;
/**
 *
 * @author Xi Yu
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0) return "";
        int index=0;
        while(index < strs[0].length()){
            for(int i=0;i<strs.length;i++){
                if(index>=strs[i].length()||strs[i].charAt(index) != strs[0].charAt(index))  return strs[0].substring(0, index);
            }
            index++;
        }
        return strs[0];
    }
    
    
    public String longestCommonPrefix(String[] strs) {
        StringBuffer result = new StringBuffer();
        if(strs.length==0) return "";
        int i;
        int j=0;
        while(j< strs[0].length()){
            for(i=0;i<strs.length;i++){//有个错误存在于j>=strs[i].length(),需要有等于，有等于时直接跳出，否则strs[i].charAt(j)就溢出了
             if(j>=strs[i].length()||strs[0].charAt(j) != strs[i].charAt(j)) break;
            }
            if(i<strs.length) break;
            result.append(strs[0].charAt(j));
            j++;
        }
        return result.toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] ele = {"aa","a"};
        test.longestCommonPrefix(ele);
    }
    
}
