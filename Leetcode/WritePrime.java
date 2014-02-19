/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package writeprime;
import java.util.HashSet;
/**
 *
 * @author Xi Yu
 */
public class WritePrime {
    public void print_pr_n(int n){
		HashSet<Integer> composites = new HashSet<Integer>(n);
		if(n >= 1) System.out.print("1, ");
		for(int i = 2; i <= n; i++){
			if(composites.contains(i)) continue;
			System.out.print(i + ", ");
			if(i <= Math.sqrt(n)+1){
				for(int j = 2; i*j <= n; j++){
					composites.add(i*j);
				}
			}
		}
	}
    
    public static char[] removechar(char[] data) {
	char[] result= new char[data.length];
        int index=0;
	for (int i=0; i<data.length; i++)
	{	if (data[i]!=',')
                {
                    result[index++]=data[i];
                }
	}
        return result;
}

     
    
    
    public static void main(String[] args) {
        // get prime number
//        int j=0;
//        for(int i=2;i<=100;i++)
//        {   double k=Math.sqrt(i);
//            for(j=2;j<=k;j++)
//            {if(i%j==0)break;}
//            if(j>k) 
//                System.out.println(i);
//        }
        
         //delete , in char[]
//        WritePrime test = new WritePrime();
//        char[] input = {'h',',','e','l','l','o'};;
//        char[] result = test.removechar(input);
//        System.out.println(input);
        
        
        //sell stock(one transection per day)
       
      }
    
}
