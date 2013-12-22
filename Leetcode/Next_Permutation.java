/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package next_permutation;

/**Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 *
 * @author Xi Yu
 */
public class Next_Permutation {
    
    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    
    /* O(n) -- reverse the array, given a range */
    private void reverse(int[] num, int l, int r) {
        while (l < r) {
            swap(num, l++, r--);
        }
    }
    
    public void nextPermutation(int[] num) {            //该方法是先交换i、j, 然后颠倒++i至末尾所有的值
        // find descending part from right to left
        int i,j, len = num.length;
        for(i=len-2;i>=0;i--){
            if(num[i+1]>num[i]){
                for(j=len-1;j>i-1;j--){if(num[j]>num[i]) break;}
                swap(num,i,j);
                reverse(num,i+1,len-1);
                return;
            }
        }
        reverse(num,0,len-1);
        return;
    }
    
    /* O(n) -- find the next permutation */
    public void nextPermutation1(int[] num) { //该方法先颠倒,后交换， 由于颠倒后保持严格的升序，既寻找到第一个比num[cur]大的数后即可交换
        // find descending part from right to left
        int cur = num.length - 1;
        while (cur > 0 && num[cur-1] >= num[cur])  --cur;
        reverse(num, cur, num.length-1);        
        if (cur > 0) {
            // insert cur-1 to the right spot
            int next = cur;
            cur -= 1;
            while (num[next] <= num[cur])  ++next;
            swap(num, next, cur);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
