/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inorderbst;

/**
 *
 * @author Xi Yu
 */
public class InorderBST {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
     public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    ArrayList<Integer> tree = new ArrayList<Integer>();
    if(root == null)
    {
        return tree;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();

    while(root!=null||!stack.isEmpty())
        {
            if(root != null  )
            {
                stack.push(root);
                root = root.left;
            }
            else
            {   root=stack.pop();                           //将pop值取出送入root 重定位至父节点
                tree.add(root.val);
                root = root.right;
            
            }
        }

    return tree;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
