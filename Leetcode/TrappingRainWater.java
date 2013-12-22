/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trappingrainwater;

/**
 *Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author Xi Yu
 */
public class TrappingRainWater {
    public int trap1(int[] A) {      //需要找到最高点，以此为风水岭    正序从0-max   逆序从A.length到max， 防止{0,2,0}这种情况
        if(A.length<=2) return 0;
        int result = 0;
        int max = 0;                //save the index of the highest column
        for(int i = 0; i < A.length; i++) 
            if(A[i] > A[max]) max = i;
            
        for(int i = 0, top = 0; i < max; i++){
            if(A[i] > top) top = A[i]; 
            else result += top - A[i];
        }
        for(int i = A.length - 1, top = 0; i > max; i--){
            if(A[i] > top) top = A[i];
            else result += top - A[i];
        }
        return result;
    }
    
    public int trap(int[] A) {   //find water from two side 从两边一次向中间递减，如果A[start] < A[end] 从左往右 否则从右往左
        int result=0;
        int i=0;
        int j=A.length-1;
        int k=0;
        while(i<j){
            if(A[i] <= A[j]){
                k = i+1;
                while (A[i] > A[k]){
                    result += (A[i]-A[k]);
                    k++;
                } 
                i=k;
            }
            else{
                k = j-1;
                while (A[j] > A[k]){
                    result += (A[j]-A[k]);
                    k--;
                } 
                j=k;
            }
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
