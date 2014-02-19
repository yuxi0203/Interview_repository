/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uniquebinarysearchtreesi.ii;
import java.util.ArrayList;
/**I.假设给定n个节点，节点值为1,2,3...,n，求由这些结点可以构成多少棵不同的二叉查找树。

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * @author Xi Yu
 * 
 * II.Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.返回的是所有TreeNode
 */
public class UniqueBinarySearchTreesIII {
    int I_numTrees(int start, int end)  //思路：递归，由于是二叉查找树，先选择任一结点根结点，假设为结点i，
            //则[1，i-1]范围的结点为结点i的左子树结点，[i+1，n]范围的结点为结点i的右子树结点，则以结点i为根结点的BST个数为左，
            //右子树可构成BST个数的乘积，基于这个思路，可以写出以下递归程序。
    { 
        if (start >= end)  
            return 1;  
  
        int totalNum = 0;  
        for (int i=start; i<=end; ++i)  
            totalNum += I_numTrees(start,i-1)*I_numTrees(i+1,end);  
        return totalNum;  
    } 
    public int I_numTrees2(int n) {//Catalan number
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int c = 1;
        for(int i=2;i<=n;i++)
        { c = 2*(2*i-1)*c/(i+1); }   
        return c;
    }
    
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; left = null; right = null; }
  }
    private ArrayList<TreeNode> generateTrees(int left, int right)
    {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        if (left > right)
        {
            ans.add(null);        //ArrayList添加空值，长度变为1
            return ans;
        }
        for (int i = left; i <= right; i++)
        {
            ArrayList<TreeNode> lefts = generateTrees(left, i-1);
            ArrayList<TreeNode> rights = generateTrees(i+1, right);
            for (int j = 0; j < lefts.size(); j++)
            {
                for (int k = 0; k < rights.size(); k++)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(null);
        System.out.println(test.size()); 
        String[] testt = new String[2];
    }
    
}
