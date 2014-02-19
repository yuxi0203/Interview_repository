/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversenodesink.group;
    
/**
 *
 * @author Xi Yu
 */
public class ReverseNodesinkGroup {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    //http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
    //different with "Reverse Linked ListII", in this question, we need use i to count length, mark pre and end, 
    public ListNode reverseKGroup(ListNode head, int k) {               //then use reverse function
        if(head==null||k==1) return head;
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while(head!=null){
            i++;
            if(i%k==0){
                pre = reverse(pre, head.next);  //return the last/end value to pre, and keep change in follow up
                head =pre.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
    
    private static ListNode reverse(ListNode pre, ListNode end){ //pre is dummy point
        ListNode last = pre.next;//where first will be doomed "last"
        ListNode cur = last.next;
        while(cur != end){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
