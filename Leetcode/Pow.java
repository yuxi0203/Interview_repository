/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pow;

/**
 *
 * @author Xi Yu
 */
public class Pow {
   
    public double ipow(double x, int n){   //Time Limit Exceeded
        double temp = x;
        for (int i=1;i < Math.abs(n); i++)
        {
            x=x*temp;
        }
        if (n<0){
            return 1/x;
        }
        else{
            return x;
        }
    }
    
    
     public double  DCpow(double x, int n){
        if (n==0)
            return 1.0;
        double half = DCpow(x,n/2);
        if(n%2 == 0)
            return half*half;
        else if (n > 0)
            return half * half * x;
        else
            return half * half / x;
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pow test = new Pow();
        System.out.println(test.DCpow(2,-1));

    }
    
}
