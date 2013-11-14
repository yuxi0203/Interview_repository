/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subset;
import java.util.*;
/**
 *
 * @author Xi Yu
 */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S){
        ArrayList<Integer> inside = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> outside = new ArrayList< ArrayList<Integer>>();
        //System.out.println(outside);
        //System.out.println(inside);
        //outside.add(inside);
        
        for(int i=0; i<S.length;i++)
        {   
//            for(int j=i+1;j<S.length;j++)
//              {   
                  inside.add(S[i]);
             //     inside.add(S[j]);
                  outside.add(new ArrayList(inside));
                  
                  inside.remove(inside.size()-1);                 
             //     System.out.println(inside.get(i));
                  
//               } 
     
        }  
//inside.remove(inside.size()-1);

        return outside;
    }
    
     public ArrayList<ArrayList<Integer>> subsets2(int[] S) {  
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
       ArrayList<Integer> tmp = new ArrayList<Integer>();  
       Arrays.sort(S);  
       res.add(tmp);  
       dfs(res,tmp,S,0);  
       return res;  
    }  
      public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){  
        for(int i=pos; i<=S.length-1;i++){  
            tmp.add(S[i]); 
            System.out.println(tmp);
            res.add(tmp);  
            //System.out.println(tmp);
            dfs(res,tmp,S,i+1);  
            tmp.remove(tmp.size()-1);  
        }  
    }  
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Subset test = new Subset();
        int[] s={1,2,3};
        System.out.println(test.subsets2(s));
    }
    
}
