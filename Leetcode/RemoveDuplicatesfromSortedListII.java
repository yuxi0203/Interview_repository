/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package removeduplicatesfromsortedlistii;

/**
 *
 * @author Xi Yu
 */
public class RemoveDuplicatesfromSortedListII {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
    //dummy  -2-2-3-3...  由于会出现这种情况（重复2重复3）所以当2-3不相等时，不能马上链接，而是删除已知的重复值，然后复位cur（复位到pre），然后cur=cur.next进行下一轮(3-3。。)的检查，只有在确认cur和cur.next值不等时， 才链接cur
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;   //pre保存最后一个非重复的node
        ListNode cur = head;
        while(cur != null){
            int value = cur.val;
            if(cur.next!=null && cur.next.val==value){
                while(cur!=null && cur.val == value){
                    pre.next = cur.next;
                    cur = pre.next;
                }
                cur = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    /**Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
