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
    public int removeDuplicates1(int[] A) {
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
    }public int removeDuplicates2-2(int[] A) {
        if(A.length <= 1) return A.length;
        int used=0;
        int cur=0;
        for(int i=1; i<A.length; i++){
            if(A[cur]==A[i]&&used<1){
                A[++cur]=A[i];
                used++;
            }
            else if(A[cur]!=A[i])
            {   A[++cur]=A[i];
                used = 0;
            }
        }
        return cur+1;
    }
    
     int removeDuplicates2-3(int A[]) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(A.length <= 1) return A.length;
        int cur = 1;
        for (int i = 2; i < A.length; ++i) {
            if (!(A[i] == A[cur] && A[i] == A[cur - 1]))  //在第三个元素等于第一个和第二个元素的所有情况外 才赋值
                A[++cur] = A[i];
        }

        return cur + 1;
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
