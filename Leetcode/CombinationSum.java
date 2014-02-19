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
	 //can't process [1,1],2  this means no duplicate elements in candidates. 但是OJ能过 存在错误.所以这是错误版本
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
	 
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {  //这应该是正确版本
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
            dfs(result, temp, num, target-num[i],i); 
            temp.remove(temp.size()-1);
            while(i<num.length-1&&num[i]==num[i+1]){ i++;} 
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
