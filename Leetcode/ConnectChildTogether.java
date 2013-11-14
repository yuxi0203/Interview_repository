/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectchildtogether;

/**
 *
 * @author Xi Yu
 */
public class ConnectChildTogether {
     public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root==null||root.left ==null)
            {return;}
        
        root.left.next = root.right;
        if(root.next  !=null)           //如果root.next有值
        {    
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
