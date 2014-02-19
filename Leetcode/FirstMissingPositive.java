/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package firstmissingpositive;

/**
 *Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Discuss


 * @author Xi Yu
 */
public class FirstMissingPositive {       //桶排序题目， 常规桶排序是根据index处理正数的
    public int firstMissingPositive(int[] A) {         //bucket sorting which only process positive number 
        int i;
        for(i = 0; i< A.length; i++){
            if(A[i]>0&&A[i]<A.length){
                if(A[A[i]-1] != A[i]){
                    int temp = A[i];          //swap start
                    A[i] = A[temp-1];
                    A[temp-1] = temp;         //swap end
                    i--;            //it is possible that the A[temp-1] is not the correct number, so i-- to check current number again
                }
            }
        }
        i=0;
        while(i<A.length){      //find the first positive number which is not equal to index
            if(A[i]-1 != i){
                return i+1;
            }
            i++; 
        }
        return A.length+1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
