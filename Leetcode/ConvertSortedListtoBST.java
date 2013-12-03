/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convertsortedlisttobst;

/**
 *
 * @author Xi Yu
 */
public class ConvertSortedListtoBST {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        //traverse all list to get length
        int listcount=0;
        for(ListNode cur = head; cur != null; cur = cur.next)     //之前存在个错误，直接用head=head.next, 这导致传入setBST时head变化
        {
            listcount++;                        
        }
        return setBST(head, listcount);
    }
    
    private TreeNode setBST(ListNode head, int count)
    {   if(count<=0) return null;
        int mid = count/2;
        ListNode rootindex = head;
        for(int i = 0; i<mid; i++)
        {
            rootindex=rootindex.next;
        }
        TreeNode root = new TreeNode(rootindex.val);
        root.left = setBST(head,mid);
        root.right = setBST(rootindex.next,count-mid-1);
        return root;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
