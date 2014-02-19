/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytreemaximumpathsum;

/**
 *
 * @author Xi Yu
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public int maxPathSum(TreeNode root) {
        //res[0] is just like a static variable, save the max(only int can't be static, because you have to pass back)
        int[] res = new int[1];  
        res[0] = Integer.MIN_VALUE;
        maxPath(root, res);
        return res[0];
    }
    private int maxPath(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int left = maxPath(root.left, res);
        int right = maxPath(root.right, res);
        int arch = left + right + root.val; 
        int pass_up = Math.max(root.val, Math.max(left, right) + root.val);
        res[0] = Math.max(res[0], Math.max(arch, pass_up));
        return pass_up;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        BinaryTreeMaximumPathSum.TreeNode input = test.new TreeNode(-3);
        int result = test.maxPathSum(input);
        System.out.println(result);
    }
    
}
