/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graycode;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.ArrayList;
/**
 *
 * @author Xi Yu
 */
public class GrayCode {
     /**
     * @param args the command line arguments
     */
    public String[] GrayCode(int n) {   
    String[] graycode = new String[(int) Math.pow(2, n)];  
  
    if (n == 1) {  
        graycode[0] = "0";  
        graycode[1] = "1";  
        return graycode;  
    }  
  
    String[] last = GrayCode(n - 1);  
  
    for (int i = 0; i < last.length; i++) {  
        graycode[i] = "0" + last[i];  
        graycode[graycode.length - 1 - i] = "1" + last[i];  
    }  
  
    return graycode;   
  }    

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> sol = new ArrayList<Integer>();
        if(n == 0) {
            sol.add(0);
            return sol;
        } else {
            ArrayList<Integer> pre = grayCode(n - 1);
            sol.addAll(pre);
            for(int i = pre.size() - 1; i >= 0; --i) {
                sol.add((int)Math.pow(2.0, n - 1) + pre.get(i));
            }
            return sol;
        }
    
}
    
    public static void main(String[] args) {
        // TODO code application logic here
//        String[] result;
//        GrayCode GC = new GrayCode();
//        result = GC.GrayCode(2);
//        for(int i=0;i<result.length;i++)
//            {
//             System.out.println(result[i]);//输出结果 1 2 3
//            }
        GrayCode GC = new GrayCode();
        ArrayList<Integer> result = GC.grayCode(3);
        System.out.println(result);
       
    }
}

