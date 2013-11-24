/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package set_matrixzero;

/**
 *
 * @author Xi Yu
 */
public class Set_matrixZero {
 public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        boolean rowexist = false, colexist = false;
        int i,j;                        //i for row, j for col
        for(i = 0; i< row; i++)
        {
            if(matrix[i][0] == 0)
                colexist = true;
                break;
        }
        for(j = 0; j< col; j++)
        {
            if(matrix[0][j] == 0)
                rowexist = true;
                break;
        }
        
        for(i = 1; i<row; i++)
        {
            for(j = 1; j<col; j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(i = 1; i< row; i++)
        {
            if(matrix[i][0] == 0)
            {
                for(j = 0;j<col;j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(j = 1; j< col; j++)
        {
            if(matrix[0][j] == 0)
            {
                for(i=0;i<row;i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(colexist== true)
        {
            for(i=0;i<row;i++)
            {
                matrix[i][0]=0;
            }
        }
        
        if(rowexist == true)
        {
            for(j=0;j<col;j++)
            {
                matrix[0][j]=0;
            }
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Set_matrixZero test = new Set_matrixZero();
        int[][] matrix = {{1,0}};
        test.setZeroes(matrix);
        System.out.println(matrix);
    }
    
}
