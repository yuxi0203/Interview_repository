/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dividewithoutslash;
    
/**
 *
 * @author Xi Yu
 */
public class DividewithoutSlash {
    
    //==============================一个一个减的方法====================================
    public int Divwithoutslash( int x, int y )
    {   
        boolean negitive = false;
        if(y==0){ 
            try {
            throw new RuntimeException("error");
               } catch(RuntimeException e) {
                  System.out.println("divisor should not be 0");
            throw e; // rethrow the exception
            }
        }
        if(y < 0) { negitive = true; y = y*(-1);}
        int result = 0;
        while ( x > 0 &&x - y >=0)
        {
            x -= y;
            result++;
        }
        if(negitive) return result*-1;
        return result;
    }

    
    //===================================位方法i=====================================
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DividewithoutSlash test = new DividewithoutSlash();
        int result = test.Divwithoutslash(16,-4);
        System.out.println(result);
    }
    
}
