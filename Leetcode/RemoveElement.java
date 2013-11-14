/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package removeelement;

/**
 *
 * @author Xi Yu
 */
public class RemoveElement {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int point1=0;
        if(A.length < 1)
        {return 0;}
        for(int point2=1; point2 < A.length; point2++)
        {
            if(A[point1] != A[point2])
                {   point1 ++;
                    A[point1]=A[point2];
                }
        }
        return point1+1;
    }
    
    public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        //Given an array and a value, remove all instances of that value in place and return the new length.

        //The order of elements can be changed. It doesn't matter what you leave beyond the new length.
        int i=0;
        for(int j=0; j<A.length; j++)
        {
            if(A[j] != elem)
                {   A[i] = A[j];
                    i++;}
        }
        return i;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
