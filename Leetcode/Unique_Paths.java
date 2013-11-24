/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unique_paths;

/**
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * @author Xi Yu
 */
public class Unique_Paths {
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
