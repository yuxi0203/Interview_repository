/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package containerwithmostwater;

/**
 *Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 * @author Xi Yu
 */
public class ContainerWithMostWater {
    public class Solution { //利用贪心算法
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int result=0;
        while(i<j){
            int cur = Math.min(height[i],height[j])*(j-i);
            if(cur>result){
                result = cur;
            }
            if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return result;
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
