/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unique_paths;

/**
 * @author Xi Yu
 */
public class Unique_Paths {

/**
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
 * @author Xi Yu
 */
    public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] resultSet = new int[n+1];
        resultSet[0] = 1;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                resultSet[j+1] += resultSet[j];
            }
        }
        return resultSet[n-1];
    }



/**
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
http://oj.leetcode.com/problems/unique-paths-ii/
 * @author Xi Yu
 */	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] result = new int[col+1];
        if(obstacleGrid[0][0]==0){
            result[0] = 1;
        }else{
            result[0] = 0;
        }
        
        for(int i =0; i < row; i++){
            for(int j = 0; j<col; j++){
                if(obstacleGrid[i][j] == 1){
                    result[j]=0;
                }
                else{
                    result[j+1] += result[j];
                }
            }
        }
        return result[col-1];
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
