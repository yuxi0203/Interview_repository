/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sum_root_to_leaf_numbers;

/**
 *
 * @author Xi Yu
 */
public class Sum_Root_to_Leaf_Numbers {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    
    public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return sum1(root,0);
    }
    
    private int sum1(TreeNode root, int sum)            //这个方法是现节点加上一个节点×10， 因此检查当前点是否是null
    {
        if(root == null) return 0;
        int cursum = sum*10 + root.val;
        if(root.left == null && root.right == null) return cursum;
        else{ return sum1(root.left, cursum)+sum1(root.right, cursum);}
    }
    
    private int sum2(TreeNode root, int sum)            //这个方法是现节点×10 加上左右2个孩子的值， 因此检查左右孩子是否为空
    {
        int Lsum =0, Rsum = 0;
        if(root.left==null&&root.right==null)
        return sum;
        if(root.left!= null)
        {Lsum = sum2(root.left, 10*sum+root.left.val);}
        if(root.right!= null)
        {Rsum = sum2(root.right,10*sum+root.right.val);}
        return Lsum+Rsum;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
