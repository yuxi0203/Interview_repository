/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergeksortedlists;
import java.util.*;
/**
 *Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author Xi Yu
 */
public class MergekSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int i){
            val = i;
            next = null;
        }
    }
    //Analyze and describe its complexity.:
    //merge every two linked list, so if we want to merge K list, we need logk times,   
    //totoal nodes are N, so total time complixity is (logK)N
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0) return null;
        ListNode result = lists.get(0); //ArrayList get by index: (arraylist name).get(index)
        for(int i = 1; i<lists.size();i++){
            result = mergeTwoLists(result,lists.get(i));
        }
        return result;
    }
    
    //Merge two linked list function,
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur=cur.next;
        }
        if(l1==null) cur.next = l2;
        else if(l2==null) cur.next = l1;
        return dummy.next;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
