/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depthofbinarytree;

/**
 *
 * @author Xi Yu
 */
public class Depthofbinarytree {
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * @param args the command line arguments
     */
    public int maxDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root==null)
           return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
