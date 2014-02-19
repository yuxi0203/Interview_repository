/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findfirstnonrepeatedval;
import java.util.HashMap;
import java.util.Map;
/**
 *Given a string 'aabbcdccefff', find the first Non-duplicate character i.e. 'd'
 * @author Xi Yu
 */
public class FindFirstNonRepeatedVal {
    public static Character FirstNoRepeated(String str){  
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        for(int i=0; i<str.length();i++){  
	            if(!map.containsKey(str.charAt(i))){  
	                map.put(str.charAt(i), 1);  
	            }else{  
	                Integer k = map.get(str.charAt(i));  
	                map.put(str.charAt(i), ++k);  
	            }  
	        }  
	        //按字符串的顺序返回首次出现的字符  
	        for(int i = 0 ; i < str.length(); i++){  
	            if(map.get(str.charAt(i)) == 1){  
	                return str.charAt(i);  
	            }  
	        }  
	        return null;  
	    }  

    
	public static char find(String s) {  
	        int i;  
	        String t = s;  
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
	        for (i = 0; i < s.length(); i++) {  
	            char c = s.charAt(i);  
	            Integer v = map.get(c);  
	            if (v == null) {  
	                map.put(c, 1);  
	            } else {  
	                map.put(c, v.intValue() + 1);  
	            }  
	            if (map.get(c).intValue() > 1) {  
	                t = t.replaceAll(String.valueOf(c), "");  
	            }  
	        }  
	        if (t.equals("")) {  
	            System.out.println("无不重复字符");  
	            return ' ';  
	        }  
	        return t.charAt(0);  
	    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereFindFirstNonRepeatedVal
        FindFirstNonRepeatedVal test = new FindFirstNonRepeatedVal();
        String input = "abbdca";
        char result = FirstNoRepeated(input);
        System.out.println(result);
    }
    
}
