/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remove.duplicates.from.sorted.list;

/**
 *
 * @author Xi Yu
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    /**
     * @param args the command line arguments
     */
    
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null)
        {
            return null;
        }
        ListNode cur;
        ListNode pre;
        cur = head.next;
        pre = head;

        while(cur!= null)               //方法1：当相同时直接下一个，不同时把pre.next和cur链接起来
        {   pre.next = null;            //这样的方法要注意把pre.next 置空，否则pre会继续输出后面的链接 直到cur
            if(cur.val != pre.val)
            {
                pre.next = cur;
                pre=cur;
            }

            cur=cur.next;
        }
        
        return head;
    }
    
    
    public ListNode deleteDuplicates2(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null)
        {
            return null;
        }
        ListNode cur;
        ListNode pre;
        cur = head.next;
        pre = head;

        while(cur!= null)          //方法2 
        {  
            if(cur.val == pre.val)       //相同时每一步都将pre.next指向cur后递推一个,并向后移一位cur
            {
                pre.next = cur.next;
                
            }
            if(cur.val !=pre.val)       //不相同时将pre= cur，表示cur被加入到pre后面
            {
                pre = cur;
            }
            cur=cur.next;
        }
        
        return head;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
