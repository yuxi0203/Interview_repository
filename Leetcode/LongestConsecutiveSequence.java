/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestconsecutivesequence;
import java.util.HashMap;
/**
 *
 * @author Xi Yu
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i : num) {
            if (map.containsKey(i)) continue;
            map.put(i, 1);
            if (map.containsKey(i - 1)) {
                max = Math.max(max, merge(map, i-1, i));
            }
            if (map.containsKey(i + 1)) {
                max = Math.max(max, merge(map, i, i+1));
            }
        }
        return max;
    }
    
    private int merge(HashMap<Integer, Integer> map, int left, int right) {
        int upper = right + map.get(right) - 1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);        //保存的新长度写入upper和lower
        map.put(lower, len);
        return len;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
