/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reverselinkedlistii;

/**Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 *
 * @author Xi Yu
 */
public class ReverseLinkedListII {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode reverseBetween(ListNode head, int m, int n) { //pre作为要颠倒范围外（前）一个点，画图更好理解
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = new ListNode(0);
        ListNode last = dummy;
        for(int i=1; i<=n; i++){
            if(i == m) pre = last;
            if(i>m && i<=n){
                last.next = head.next;
                head.next = pre.next;
                pre.next = head;
                head = last;
            }
            last = head;       //由于m n必定小于总长度，所以可以用步进的方式，先换再处理下一个
            head= head.next;  //但若是n大于总长度，则需要记录还pre，然后步进到n，然后调用reverse function， 这是先找到终点，再进行处理，和第一个略有不同
        }                   //这就是Reverse Nodes in k-Group 和reverse Linked List不同
        return dummy.next;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
