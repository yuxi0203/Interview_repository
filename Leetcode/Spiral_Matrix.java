/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spiral_matrix;
import java.util.ArrayList;

/**
 *Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @author Xi Yu
 */
public class Spiral_Matrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {     //算法不难，就是工程实现上需要精确注意边界，减少不必要的空间
        ArrayList<Integer> result = new  ArrayList<Integer>();
        if (matrix.length == 0) return result;
        int m = matrix.length;                                                  //注意matrix.length是求矩阵有多少行
        int n = matrix[0].length;                                               //matrix[0].length是求矩阵第0行有多少列
        reorder(m,n,0,matrix,result);
        return result;
    }
    
    //以k作为深入的标记，因为是按层 所以只要k+1即可， 而不需要设置row col变量追踪第一个下标
    private void reorder(int m, int n, int k, int[][] matrix, ArrayList<Integer> result){  
        if(m<=0||n<=0) return;
        if(m==1){
            for(int j = 0; j<n; j++){
                result.add(matrix[k][k+j]);
            }
            return;
        }
        if(n==1){
            for(int i = 0; i<m; i++){
                result.add(matrix[k+i][k]);
            }
            return;
        }
        for(int j = 0;j<n-1;j++) {              //若有k列 输出0～k-2列，第k列的值由下一个循环（既up-bottom来实现）
            result.add(matrix[k][k+j]);
        }
        for(int i = 0;i<m-1;i++) {
            result.add(matrix[k+i][k+n-1]);     //同理，up-bottom的最后一个值 有bottom来输出
        }
        for(int j = 0;j<n-1;j++) {
            result.add(matrix[k+m-1][k+n-1-j]);
        }
        for(int i = 0;i<m-1;i++) {
            result.add(matrix[k+m-1-i][k]);
        }
        reorder(m-2,n-2,k+1,matrix,result);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matrix = {
            {2,5},{8,4},{0,-1}
        };
        Spiral_Matrix test = new Spiral_Matrix();
        ArrayList<Integer> result = test.spiralOrder(matrix);
        System.out.println(result);
    }
    
}
