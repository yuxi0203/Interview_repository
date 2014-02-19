/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flattenbinarytreetolinkedlist;

/**
 *
 * @author Xi Yu
 */
public class FlattenBinaryTreetoLinkedList {

    /**Given a binary tree, flatten it to a linked list in-place.
     * @param args the command line arguments 
     *   1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.
     */

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
                        //                   1
                        //                    \
                        //                     2
                        //                    / \
                        //                   3   4
                        //                        \
                        //                         5
    public void flattenUptoBottom(TreeNode root) { //从上往下将左子数添加到右子树之前（需要注意，此时root.right是有左子树的，因此对root.right递归）
        if(root == null) return;
         if(root.left != null){
             TreeNode left = root.left;
             TreeNode right = root.right;
             root.left = null;
             root.right = left;
             TreeNode rightMost = root.right;
             while(rightMost.right != null){
                 rightMost = rightMost.right;
             }
             rightMost.right = right;
         }
         flatten(root.right);
    }
    
    public void flatten(TreeNode root){  //from bottom to up
        if(root == null) return;
        if(root.left!=null){
            flatten(root.left);
            TreeNode cur = root.left;
            while(cur.right!=null){
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(root.right!=null){
            flatten(root.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
