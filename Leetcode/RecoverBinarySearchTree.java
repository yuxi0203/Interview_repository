/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recoverbinarysearchtree;
import java.util.*;
/**
 *Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
 * @author Xi Yu
 */
public class RecoverBinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    ArrayList<TreeNode> t;
    TreeNode previous;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        t = new ArrayList<TreeNode>();
        previous=null;
        inorder(root);
        int temp = t.get(0).val;
        t.get(0).val = t.get(t.size()-1).val;
        t.get(t.size()-1).val = temp;
    }
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(previous!=null&&previous.val>root.val) {
            if(!t.contains(previous)) t.add(previous);
            if(!t.contains(root)) t.add(root);
        }
        previous = root;
        inorder(root.right);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
