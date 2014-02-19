/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twosum;
import java.util.HashMap;
import java.util.*;
import java.util.Iterator;
/**
 *Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * @author Xi Yu
 */
public class TwoSum {
     public int[] twoSum(int[] numbers, int target) {  //O(n^2)方法， leetcode超时
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] twoInd = new int[2];
        int[] twoTempSum = new int[2];
        for (int i = 0; i < numbers.length; i++) {
        for (int j = i+1; j < numbers.length; j++) {
            twoTempSum[0] = numbers[i];
            twoTempSum[1] = numbers[j];
            if (twoTempSum[0] + twoTempSum[1] == target) {
                twoInd[0] = i+1;
                twoInd[1] = j+1;
                break;
            } else {

            }
        }       
    }
    return twoInd;
    }
     
           //key is the value we are looking for, value is the time/frequency of value we can use  
    public ArrayList<ArrayList<Integer>> twoSumHash(int[] numbers, int target) { 
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<numbers.length; i++){
            //if hashmap contains the value we are looking for, add that pair into result and minus 1 on value
            if(map.containsKey(numbers[i]) && map.get(numbers[i])!=0){
                int index = map.get(numbers[i]);
                map.put(numbers[i], --index);
                result.add(new ArrayList<Integer>(Arrays.asList(target-numbers[i],numbers[i])));
            }
            //if hashmap doesn't contain the value, save the new one into hashmap
            else{
                if(map.containsKey(target-numbers[i])){
                    int repeat = map.get(target-numbers[i]);
                    map.put(target-numbers[i], ++repeat);
                }
                else{
                        map.put(target-numbers[i], 1);
                      } 
            }
        }
        return result;  //return if no match
    }
    
    public ArrayList<ArrayList<Integer>> twoSumPointers(int[] numbers, int target) {  //O(nlogn)
        int i = 0;                        //begin pointer
        int j = numbers.length - 1;       //end pointer
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);             // sort array to make sure no value used twice
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
               result.add(new ArrayList<Integer>(Arrays.asList(numbers[i],numbers[j])));
               ++i;
               --j;
            }
            else if(sum < target)
                ++i;
            else
                --j;
        }
        return result;
    }


/*
test result :    
    numbers1 = {}; 				target = -1 -------->  return null
    numbers2 = {1,2,3,4,5,6,7,8,9,10};  	target = 10--------->  return [4, 6] [3, 7] [2, 8] [1, 9]
    numbers3 = {1,2,3,7,7,8,2,8,5,5,5}; 	target = 10--------->  return [3, 7] [2, 8] [2, 8] [5, 5]
    numbers4 = {1,2,-3,7,7,8,-2,8,5,-5,4}; 	target = -5--------->  return [-3, -2]

*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwoSum test = new TwoSum();
        int[] numbers2 = {1,2,3,4,5,6,7,8,9,10};
        int[] numbers3 = {1,2,3,7,7,8,2,8,5,5,5};
        int[] numbers4 = {1,2,-3,7,7,8,-2,8,5,-5,4};
        int[] numbers1 = {};
        ArrayList<ArrayList<Integer>> result = test.twoSumHash(numbers4, -5);
        Iterator show = result.iterator();
        while(show.hasNext()) {
            System.out.println(show.next());
        }
    }
    
}
