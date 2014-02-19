/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intersectionoftwoarrays;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author Xi Yu
 */
public class IntersectionofTwoArrays {
    private static Set<Character> intersect(char[] a, char[] b) {
        Set<Character> aSet = new HashSet<Character>();
        Set<Character> intersection = new HashSet<Character>();
        for (char c : a) {
            aSet.add(c);
        }
        for (char c : b) {
            if (aSet.contains(c)) {
                intersection.add(c);
            }
        }
        return intersection;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[] a = {'a', 'b', 'c', 'd'};
        char[] b = {'c', 'd', 'e', 'f'};
        System.out.println(intersect(a, b));
    }
    
}
