/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sametree;

/**
 *
 * @author Xi Yu
 */
public class SameTree {

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * @param args the command line arguments
     */
     public boolean isSameTree(TreeNode p, TreeNode q) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (p == null && q == null)
        {  return true;}
        if (p == null || q == null)  //判断p与q那个为空必须在判断.val之前，否则报错  test: {},{0}
        {  return false;}
        if (p.val != q.val)
        {  return false;}

        boolean resultleft = isSameTree(p.left,q.left);
        boolean resultright = isSameTree(p.right,q.right);
        return resultleft&&resultright;
    }
     
    public static void main(String[] args) {
        // TODO code application logic here

    }
    
}
