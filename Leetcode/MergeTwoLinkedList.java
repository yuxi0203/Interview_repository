/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergetwolinkedlist;

/**
 *
 * @author Xi Yu
 */
public class MergeTwoLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode result;
        if(l1==null) return l2;
        if(l2==null) return l1;
        if (l1.val <= l2.val)
        {
            result = l1;
            result.next = mergeTwoLists(l1.next,l2);
        }
        else
        {
            result = l2;
            result.next = mergeTwoLists(l1,l2.next);
        }
        return result;
    }
    
     public ListNode mergeTwoListsbyDummy(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    ListNode dummy = new ListNode(0);  
    ListNode cur = dummy;  


    while (l1 != null && l2 != null) {  
     if (l1.val <= l2.val) {  
       cur.next = l1;  
       l1 = l1.next;  
     } else {  
       cur.next = l2;  
       l2 = l2.next;  
     }  
     cur = cur.next;  
    }  

     if (l1 != null) {  
     cur.next = l1;  
    } else if (l2 != null) {  
     cur.next = l2;  
    }  
  
   return dummy.next;  
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
