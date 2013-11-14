/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergesortedarray;

/**
 *
 * @author Xi Yu
 */
public class MergeSortedArray {

    /**
     *Given two sorted integer arrays A and B, merge B into A as one sorted array.
     * Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
     */
    
    public void merge(int A[], int m, int B[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        while(n>0)
        {
            if(m>0 && A[m-1]>B[n-1])  //如果只有A[m-1]>B[n-1]， 在输入为[], [1]时就会报错，因为A为空， 便不存在0-1 = -1的index
            {                         //而且 m>0需要写在A[m-1]>B[n-1]左侧以防止A[m-1]先运行导致的报错
                A[m+n-1] = A[m-1];
                m--;
            }else
            {
                A[m+n-1] = B[n-1];
                n--;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
