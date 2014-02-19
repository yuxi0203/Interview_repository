/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implement_strstr;

/**
 *Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * @author Xi Yu
 */
public class Implement_strStr {
    public String strStr2pointers(String haystack, String needle) {
        if (needle.length() == 0) return haystack;
        if (haystack.length()<needle.length()) return null;
        for (int i = 0; i < haystack.length();i++){   //brute force的2pointer法，通过检查haystack是否还有足够空间包含needle步骤实现剪枝
            int j = i;
            // first judge if there is no enough length left to hit needle, very important to save time
            // second obvious
            // tracking needle in haystack
            while (needle.length()+i <= haystack.length()&& j<haystack.length() && haystack.charAt(j) == needle.charAt(j-i)){
                j++;
                if (j-i == needle.length()){
                    return haystack.substring(i);
                }
            }
    
        }
        return null;

    }
    
    public String strStrKMP(String haystack, String needle) {
        if (needle.length() == 0) return haystack;
        if (haystack.length()<needle.length()) return null;
        int[] next = new int[needle.length()+1];
        generateNext(needle,next);
        int i = 0;  
        int j = 0;  
        while(i < haystack.length() && j < needle.length()) {  
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {  //由于起始是-1，所以设j==-1为一个起始条件
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
          
        if (j == needle.length()) {         //当盘不安needle存在于haystack后，不再扫描后续haystack，返回相同起点所有值
            return haystack.substring(i-j);  
        }  
        return null;
        
    }
    
    public void generateNext(String input,int[] next) {  //生成Next()数组，起始为-1，0
        int len = input.length();     
        int i = 0,j = -1;     
        next[0] = -1;     
        while(i < len){     
            if( j == -1 || input.charAt(i) == input.charAt(j)){     
                i++;     
                j++;     
                next[i] = j;     
            }else{     
                j = next[j];     
            }     
        }     
    }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
