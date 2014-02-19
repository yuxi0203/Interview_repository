/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package largestrectangleinhistogram;

/**
 *Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
* 
* http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * @author Xi Yu
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        int maxV = 0;
        for(int i = 0; i<height.length;i++){
            int minV = height[i];
            for(int j = i; j<height.length; j++){
                minV = Math.min(minV,height[j]);
                int area = minV*(j-i+1);
                if(area>maxV){
                    maxV = area;
                }
            }
        };
        return maxV;
    }
    
    public int largestRectangleAreaPruning(int[] height) {
        int maxV = 0;
        for(int i = 0; i<height.length;i++){
            //剪职
            for(int k = i+1; k<height.length;k++){
                if(height[k]<height[k-1]){
                    i = k-1;
                    break;
                }else{
                    i = k;
                }
            }
            int minV = height[i];
            for(int j = i; j>=0; j--){
                minV = Math.min(minV,height[j]);
                int area = minV*(j-i+1);
                if(area>maxV){
                    maxV = area;
                }
            }
        };
        return maxV;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LargestRectangleinHistogram test = new LargestRectangleinHistogram();
        int[] input = {1,1};
        int result = test.largestRectangleArea(input);
        System.out.println(result);
    }
    
}
