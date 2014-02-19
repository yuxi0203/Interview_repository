/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package permutationsii;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 * @author Xi Yu
 */
public class PermutationsII {    //2个方法  1. 添加used[i] || (i != 0&&num[i]==num[i-1]&&used[i-1]) 条件，在遇到重复时不插入
                                    //        2.考虑可以设置一个hashset, if(hastset.add(num[i]))表示还未存入，否则则表示已经存进过hashset，便不再写入result
                                    //   hashset和hashmap是不同的；Map集合是有一对属性值的集合，属性包含key，和value。关键字key是唯一不重复的。Map是一个有序的集合，
                                    //所以查询起来速度很快。而HashSet就像是把HashMap中value去掉，说白了就是只有一个key的HashMap集合。Set是数学中定义的集合，所以元素无序, 且不能重复添加
                                    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        
        Arrays.sort(num);
        generate(num,used,temp,result);
        return result;
    }
    
    private void generate(int[] num, boolean[] used, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
        if(num.length == temp.size()){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i<num.length; i++){
            if(used[i] || (i != 0&&num[i]==num[i-1]&&used[i-1])) continue;
            used[i] = true;
            temp.add(num[i]);
            generate(num,used,temp,result);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PermutationsII test = new PermutationsII();
        int[] input = new int[1];
        input[0] = 1;
        test.permuteUnique(input);
    }
    
}
