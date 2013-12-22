/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg3sum_closest;
import java.util.Arrays;
/**
 *Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author Xi Yu
 */
public class Main {
     public int threeSumClosest(int[] num, int target) {   //一切基于排列，还可以用n^2*logn的方法
        if (num.length<3) { // if less than three items then return 0
        return 0;
    }
    Arrays.sort(num);
    int res = num[0]+num[1]+num[2];
    for (int i=0; i<num.length-2; ++i) {
        if (i>0 && num[i]==num[i-1])  continue; //如果是重复数，没必要再次运算，直接进入下一个
        int start = i+1, end = num.length-1;
        while (start<end) {
            int sum = num[i] + num[start] + num[end];
            if (Math.abs(sum-target) < Math.abs(res-target)) {
                res = sum;
            }
            if (sum == target) {
                return res;
            } else if (sum < target) {      //由于前一个循环end加上肯定是大于，则我们固定end， 开始增加start以找到closest
                start++;
            } else if (sum > target) {    //由于拍过序，若3个数字的值已经超过目标，则应该减少最大数，既将end向左移动直到总数小于target
                end--;
            }
        }//end-while
    }
    return res;
    }
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
