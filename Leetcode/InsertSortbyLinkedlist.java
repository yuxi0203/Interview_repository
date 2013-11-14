/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insertsortbylinkedlist;

/**
 *
 * @author Xi Yu
 */



public class InsertSortbyLinkedlist {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public class Solution {
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
              if(head == null)
              {
                  return head;
              }
              ListNode cur, pre, next, node;
              cur = head.next;
              head.next = null;
              while(cur!= null)//当前要插入的节点
              {
                  node = cur.next;//保存下一个节点
                  if(cur.val<head.val)//比头结点还小，则成为新的头结点
                  {
                      cur.next = head;
                      head = cur;
                  }
                  else
                  {
                      pre = head; next = head.next;
                      while(next!= null && next.val<cur.val)//找到合适位置
                      {
                          pre = next;
                          next = next.next;
                      }
                      cur.next = next;
                      pre.next = cur;
                  }
                  cur = node;
              }
              return head;
         
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
