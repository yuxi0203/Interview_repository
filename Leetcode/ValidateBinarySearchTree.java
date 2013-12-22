/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validatebinarysearchtree;

/**
 *Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * @author Xi Yu
 */
public class ValidateBinarySearchTree {         // 关键是如何判定左边都小于rootval 右边都大于rootval  hint：设置上下限，每个节点要将其左右子树的值与该节点的父节点值做比较
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode l, TreeNode r) {   //右子树值要小于其父节点值，左子树值要大于其父节点值
            if (root==null) return true;
            if(l!=null){
                if(root.val <= l.val)
                    return false;
            }   
            if(r!=null){
                if(root.val>= r.val)
                    return false;
            }
            return isValidBST(root.left,l,root)&&isValidBST(root.right,root,r);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
