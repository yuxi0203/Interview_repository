/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linked.list.cycle;

/**
 *
 * @author Xi Yu
 */
public class LinkedListCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
     public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode tortoise =head;
        ListNode hare =head;
        
        while( hare !=null && hare.next !=null){
           tortoise = tortoise.next;
           hare = hare.next.next;
           if(tortoise == hare)
            {return true;}
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
