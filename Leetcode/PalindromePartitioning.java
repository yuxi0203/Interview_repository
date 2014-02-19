/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package palindromepartitioning;
import java.util.ArrayList;  
/**
 *
 * @author Xi Yu
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();  
        ArrayList<String> temp = new ArrayList<String>();  
        dfs(result,temp,s);  
        return result;  
    }
    
    private void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> temp, String s){
        if(s.length() == 0) result.add(new ArrayList<String>(temp));
        for(int i = 1; i<=s.length();i++){  //substring(int beginIndex, int endIndex)  返回一个新字符串，它是此字符串的一个子字符串。
            String substr = s.substring(0,i);           //beginIndex - 起始索引（包括）从0开始。endIndex - 结束索引（不包括）。
            if(isPalindrome(substr)){
                temp.add(substr);
                dfs(result,temp,s.substring(i));
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String input){
        int i = 0;
        int j = input.length()-1;
        while(i<j){
            if(input.charAt(i++)!= input.charAt(j--)) return false;
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
