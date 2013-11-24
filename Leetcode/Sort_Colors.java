/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sort_colors;

/**
 *Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author Xi Yu
 */
public class Sort_Colors {
    public void sortColors(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int r = 0, w = 0, b = A.length;
        if(b <= 1) return;
        for(w = 0; w < b; w++)
        {
            if(A[w] == 0)
            {    
                swap(A,r++,w);
            }
            if(A[w] == 2)           //一开始是以for(w = 0;w<b;)形式循环，没用else if导致报错  因为当上一个if中w++后，不用elseif就会继续
            {                       //这个循环，导致报错
                swap(A,--b,w--);
            }
            
        }
    }
    private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sort_Colors test = new Sort_Colors();
        int[] A = {1,0};
        test.sortColors(A);
        for(int i = 0;i<A.length;i++)
             System.out.println(A[i]);
    }
    
}
