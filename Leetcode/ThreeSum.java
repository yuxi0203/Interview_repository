/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threesum;
import java.util.*;
/**
 *
 * @author Xi Yu
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);                       //sort is an important way to delete duplicate number
        for(int i = 0; i<num.length-2; i++){
            if(i != 0 && num[i] == num[i-1]) continue;
            for(int m = i + 1, n = num.length - 1; m < n;){
                int twosum = num[m] + num[n];
                if(num[i] + twosum == 0)
                    result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[m], num[n]))); //.asList to merge 3 value together
                
                //move forward if the num is duplicate
                if(twosum+num[i] <= 0) {
                    do{ m++; }
                            while (m< num.length && num[m-1] == num[m]);
                }
                if(twosum+num[i] >= 0){
                    do{ n--; }
                            while (n>=0 && num[n] == num[n+1]);
                } 
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
