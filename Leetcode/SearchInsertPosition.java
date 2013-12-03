/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package searchinsertposition;

/**Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
* [1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 *
 * @author Xi Yu
 */
public class SearchInsertPosition { 
    public int searchInsert1(int[] A, int target) {      //直接搜索
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = A.length;
        if(length == 0) return 0;
        int i;
        for (i= 0;i < A.length; i++ ) {
            if (A[i] < target) {
                continue;
            } else {
                return i;
            }
        }
        return i;
    }
    
    public int searchInsert(int[] A, int target) {  //二叉搜索
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int start = 0;
        int end = A.length-1;
        int mid = 0;
        while(start <= end)
        {
            mid = (start + end) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] < target)
                start = mid +1;
            else
                end = mid-1;
        }

        return start;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
