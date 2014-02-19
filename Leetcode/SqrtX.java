/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sqrt.x;

/**
 *
 * @author Xi Yu
 */
public class SqrtX {
    public int sqrt(int x) {
      long  start = 0;
      long  end = x / 2 + 1;
      while (start <= end)
      {
          long  mid = (start + end) / 2;
          long  square = mid * mid;
          if (square == x) return (int)mid;
          else if (square < x) start = mid + 1;
          else end = mid - 1;
     }
     //sqrt(9) = 3, sqrt(8)=2, 以第二个为例，start = 3， end等于2的时候跳出循环，表示没有整数解，因此2就是最接近答案的整数解，故直接输出end即可
     return (int)end;  //now, end is < then start, start^2 is cloest to n(in larger side), so end is the answer
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SqrtX test = new SqrtX();
        int result = test.sqrt(8);
        System.out.println(result);
    }
    
}
