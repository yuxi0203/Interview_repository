/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addtwonumber;

/**
 *
 * @author Xi Yu
 */
public class AddTwoNumber {
    public class ListNode{
          int val;
          ListNode next;
          ListNode(int x) {
          val = x;
          next = null;
         }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode res = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, head=res;
        while(cur1!=null || cur2!=null){
            if(cur1!=null){
                carry+=cur1.val;
                cur1=cur1.next;
            }
            if(cur2!=null){
                carry+=cur2.val;
                cur2=cur2.next;
            }
            head.next=new ListNode(carry%10);
            head=head.next;
            carry/=10;
        }
        if(carry==1) head.next=new ListNode(1);
        return res.next;
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AddTwoNumber test = new AddTwoNumber();
        AddTwoNumber.ListNode input1 = test.new ListNode(7);
        AddTwoNumber.ListNode input2 = test.new ListNode(4);
        input1.next = test.new ListNode(0);
        input1.next.next = test.new ListNode(2);
        input2.next = test.new ListNode(1);
        input2.next.next = test.new ListNode(3);
        AddTwoNumber.ListNode result = test.addTwoNumbers(input1, input2);
        while(result !=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}
