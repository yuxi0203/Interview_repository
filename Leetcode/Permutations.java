/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package permutations;
import java.util.ArrayList;
/**
 *
 * @author Xi Yu
 */
public class Permutations {
    //========================method 1  add value through arraylist index(add(j.num))========================
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(num[0]);
        list.add(a);
        for(int i = 1; i < num.length; i++) {
            list = insert(list, num[i]);
        }
        return list;
    }

    //这方法是通过temp.add(j,num)来实现arraylist内的index插入，既1 -> (1,2)                             (2,1) 
 //                                                                       ||                                ||    
                                                                //(3,1,2) (1,3,2) (1,2,3)       (3,2,1) (2,3,1)(2,1,3)
            
    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> list, int num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size() + 1; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(list.get(i));
                temp.add(j, num);
                resultList.add(temp);
            }
        }
        return resultList;
        }
    /**
     * @param args the command line arguments
     */
    
    //======================================== method 2 backtracking===================================
    
    public ArrayList<ArrayList<Integer>> permuteBacktrack(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int len = num.length;
        int[] used = new int[len];
        generate(num,used,len,cur,res);
        return res;
    }

    //通过回溯的方式，和subset不同的是，排列组合直到最后末尾才add到result，然后返回
    //设置used数组，作为检查第i个数字是否出现过(但由于for仍然会遍历所有num，所以仍然会检查那个数字),若没出现过，加入cur
    //然后在下个循环内不再加入cur
    //感觉比第一个要复杂，要多次遍历重复
    public void generate(int[] num, int[] used, int len, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
        if(cur.size()==len){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i=0; i<len; i++){
            if(used[i] == 0){
                cur.add(num[i]);
                used[i] = 1;
                generate(num,used,len,cur,res);
                used[i] = 0;
                cur.remove(cur.size()-1);
            }
        }
    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
