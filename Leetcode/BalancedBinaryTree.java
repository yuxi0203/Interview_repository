/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package balanced.binary.tree;

/**
 *
 * @author Xi Yu
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in 
* which the depth of the two subtrees of every node never differ by more than 1.
 */


public class BalancedBinaryTree {
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * @param args the command line arguments
     */
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left<0||right<0||Math.abs(left - right) > 1) return false;
        else{
        return true;
        }
    }
    
    
    private int getHeight(TreeNode n) {
    if (n == null) return 0;
    int l = getHeight(n.left);
    int r = getHeight(n.right);
    if(l<0||r<0||Math.abs(l - r) > 1) return -1;
    return Math.max(l, r) + 1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
