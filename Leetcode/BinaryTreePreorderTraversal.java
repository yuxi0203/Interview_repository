/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytreepreordertraversal;
import java.util.ArrayList;
/**
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
    For example:
    Given binary tree {1,#,2,3},return [1,2,3].
 * @author Xi Yu
 */
public class BinaryTreePreorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
        {
            return result;
        }
        recursive(root,result);
        return result;
    }
    
    private void recursive(TreeNode root, ArrayList<Integer> temp){
        if(root != null)
        {
        temp.add(root.val);
        recursive(root.left,temp);
        recursive(root.right,temp);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
