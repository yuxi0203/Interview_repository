/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jumpgameii;

/**
 *Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * @author Xi Yu
 */
public class JumpGameII {
    
    /**贪心算法 
     * 得到第一个能走到的距离last（是index的值），这是第一步能走到的距离，在这段距离中，
     * 保存一个第二步能走的最大距离max(也是index值)，当第一步的距离last用完时，更新最大距离max为第二步所能前进到的下标，使last等于max
     * 循环
     * @param args the command line arguments
     */
    public int jump(int[] A) {
        int result = 0;
        int max = 0;
        int last = 0;
        for(int i = 0; i< A.length; i++){
            if(i>last){
                last = max;
                result++;
            }
            max = Math.max(max,i+A[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
