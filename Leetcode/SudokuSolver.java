/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudokusolver;

/**
 *Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
 * @author Xi Yu
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
    
    
    private boolean backtracking(char[][] board){
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='.'){        //if its number, move to next one
                    for (char num='1'; num<='9'; num++){
                        if(isValid(board, i, j, num)){
                            board[i][j]=num;
                            if (backtracking(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';  //reset to ".", and backtrack to last recursion round
                            }
                        }
                    }
                    // if no proper number found, return false
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char c){
        // check column
        for (int row=0; row<9; row++){
            if (board[row][j]==c){
                return false;
            }
        }
       // check row
        for (int col=0; col<9; col++){
            if (board[i][col]==c){
                return false;
            }
        }
        // check box
        for(int row=i/3*3; row<i/3*3+3; row++){
            for (int col=j/3*3; col<j/3*3+3; col++){
                if (board[row][col]==c){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
