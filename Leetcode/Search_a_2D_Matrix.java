/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package search_a_2d_matrix;

/**
 *Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 * @author Xi Yu
 */
public class Search_a_2D_Matrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {       //简单的两次二分查找即可
        int row = matrix.length;
        int col = matrix[0].length;
        if(row ==0 || col ==0) return false;  
        if(target< matrix[0][0]) return false;
        int start = 0, end = row-1;
        while(start<=end){          //二分查找条件 注意是小于等于
            int mid = start+(end-start)/2;      //意思与(start+end)/2相同，但由于相加后可能溢出（超过限制上限），于是先减再加，防止溢出
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) start=mid+1;
            else end = mid-1;
        }
        int targetrow = end;
        start = 0;
        end = col-1;
        while(start<=end){
            int mid = start+(end-start)/2;      //防止溢出
            if(matrix[targetrow][mid]==target) return true;
            else if(matrix[targetrow][mid]<target) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
