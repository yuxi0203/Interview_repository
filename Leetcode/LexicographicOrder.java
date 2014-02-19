/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexicographicorder;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Xi Yu
 */
public class LexicographicOrder {
    private void stringMethod(){
        System.out.print("\n\tLexicographic Order\n\nEnter an integer: ");
        Scanner input = new Scanner(System.in);
        Integer n = input.nextInt();
        List<String> list = new ArrayList<String>();

        for (int i = 1;i<n;i++){
          list.add(""+i);
        }

       Collections.sort(list);

       for (String j: list){
         System.out.println(j);
       }
    }
    
    void DfsMethod(int N, int k) 
{ 
 	if (k > N) {return;} 
 	for(int i = 0; i<10; i++) 
 	{ 
 	 	if (k <= N) { 
 	 		System.out.println(k); 
 	 	 	k *= 10; 
 	 		DfsMethod(N, k); 
 	 		k /= 10; 
 	 		k++; 
 	 		if (k%10 == 0) return; 
 	 	} 
 	} 
} 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LexicographicOrder test = new LexicographicOrder();
        test.DfsMethod(25,1);
    }
    
}
