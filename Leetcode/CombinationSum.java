/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combinationsum;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.
 * @author Xi Yu
 * For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
public class CombinationSum {
     public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates,temp,result,target,0);
        return result;        
    }
    private void dfs(int[] candidates, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result, int val, int start){
        if (start < 0 || start >= candidates.length || val < 0)  return;
        if(val == 0){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = start; i<candidates.length;i++){
            if(candidates[i]>val) return;
            temp.add(candidates[i]);
            dfs(candidates,temp,result,val-candidates[i],i);
            temp.remove(temp.size()-1);          //注意 此处应该是temp.size()-1确保是最后一个数字，若是直接用i，或报错超出bound
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
