/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package permutationsequence;

/**The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 *数学题http://blog.csdn.net/havenoidea/article/details/12837441
 * @author Xi Yu
 * 已知n的值，学过排列组合知道共有n！种排列。

第一位每个数字开头的序列都有（n-1）！个序列，因此n个数字所以共有n！个序列。

以此类推，第二位每一个数开头都有（n-2）！个序列。

因为数字不能重复，我用sign记录数字是否使用过，data存阶层的值。

每次循环找到没使用过的数中第k/data[i]个数就是当前位的数字。
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] num = new int[n]; //num save normal number
        int factorial = 1;
        for(int i = 0; i<n; i++){  //prepare number and factorial
            num[i] = i+1;
            factorial = factorial*(i+1);
        }
        String result= "";
        k--; //why
        for(int i = 0; i<n; i++){
            factorial = factorial/(n-i);
            int selected = k/factorial;
            result +=(num[selected]);//result +=('0'+num[selected]);last error, this means transfer num to ASCII, and save to string
            System.out.println(num[selected]);
            for(int j = selected; j<n-i-1;j++)
                num[j] = num[j+1];
            k = k % factorial;
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PermutationSequence test = new PermutationSequence();
        String result = test.getPermutation(1,1);
        System.out.println(result);
    }
    
}
