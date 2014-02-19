/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package copylistwithrandompointer;
import java.util.HashMap;
/**A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 *关键是了解什麽是浅copy什麽是深拷贝
 * 深拷贝并不是简单的=， 不能指向原先的内存地址，需要开辟新的（即使所有属性都一样）
 * 常规手法是先遍历一遍，拷贝所有label，保存新head，在第二次遍历时，找出
 * @author Xi Yu
 */
public class CopyListwithRandomPointer {
static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
};
    public RandomListNode copyRandomListHashMap(RandomListNode head) {
        //Hashmap function Time O(n), space O(n)
        HashMap<RandomListNode,RandomListNode> connection = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode first = dummy;
        RandomListNode cur = head;
        
        while(cur!= null){
            RandomListNode copyhead = new RandomListNode(cur.label);
            copyhead.random = cur.random;
            first.next = copyhead;
            connection.put(cur,copyhead);  //HashMap content: connection ("original", "copy")
            first = first.next;
            cur = cur.next;
        }
        cur = dummy.next;
        while(cur != null){       //now, cur is the copy list, but it's .random is still belong to the original list:see row 19 and 20
            cur.random = connection.get(cur.random);    //so we could use that as Key to search
            cur = cur.next;
        }
        return dummy.next;
    }
    
    
    public RandomListNode copyRandomList(RandomListNode head) {
        // insert new nodes after each original one
        RandomListNode cur = head;
        while(cur!=null){
            RandomListNode copyhead = new RandomListNode(cur.label);
            copyhead.next = cur.next;
            cur.next = copyhead;
            cur = copyhead.next;
        }
        
        //copy pointer
        cur = head;
        while(cur != null){
            RandomListNode copynode = cur.next;
            if(cur.random != null){
                copynode.random = cur.random.next;
            }
            cur = copynode.next;
        }
        
        //decouple them
        cur = head;
        RandomListNode dummy = head == null? null:head.next;
        while(cur != null){
            RandomListNode temp = cur.next;
            cur.next = temp.next;
            if(temp.next!=null) temp.next = temp.next.next;
            cur = cur.next;
        }
        return dummy;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
    }
    
}
