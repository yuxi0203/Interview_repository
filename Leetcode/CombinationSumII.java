/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combinationsumii;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 * @author Xi Yu
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        dfs(result, temp, num, target,0);
        return result;
    }
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp,int[] num, int target, int start){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = start; i < num.length; i++){
            temp.add(num[i]);           // pass parameter i+1 instead of i to achieve Each number only be used once in the combination.
            dfs(result, temp, num, target-num[i],i+1); //error, using i+1, not start+1:because i is increasing in loop, start is not
            temp.remove(temp.size()-1);
            while(i<num.length-1&&num[i]==num[i+1]){ i++;} //由于排序后的重复数字都相邻，当输入第一个值后，其后面相同的值可以不再运算， 所以直接i++检查下一个是否相
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CombinationSumII test = new CombinationSumII();
        int[] input = new int[2];
        input[0]=1;
        input[1]=1;
//        input[2]=6;
//        input[3]=7;
        //input[0]=10;input[1]=1;input[2]=2;input[3]=7;input[4]=6;input[5]=1;input[6]=5;
        System.out.println(test.combinationSum2(input, 3));
    }
    
}
