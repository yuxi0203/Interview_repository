/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package anagrams;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Xi Yu
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> anagram = new ArrayList<String>();
        HashMap<String,ArrayList<String>> list = new HashMap<String,ArrayList<String>>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (list.containsKey(key)) {
                list.get(key).add(str);
            } else {
                list.put(key,new ArrayList<String>(Arrays.asList(str)));
            }
        }
        for (ArrayList<String> test:list.values()) {
            if (test.size()>1) {
                anagram.addAll(test);
            }
        }
        return anagram;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String test = new String("bca");
        char[] chars = test.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        
    }
    
}
