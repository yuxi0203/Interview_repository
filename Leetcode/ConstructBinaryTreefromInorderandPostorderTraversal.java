/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constructbinarytreefrominorderandpostordertraversal;

/**
 *
 * @author Xi Yu
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
//首先在postorder中，最后那一个肯定是整棵树的根，然后在inorder中查找这个根，找到之后就能从inorder中确定左子树和右子树的中序遍历，从postorder中确定左右字数的后续遍历，然后各自递归求解。
//bug： 竟然突发奇想用bs找值，忘记得是排序的前提 2了
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        if(inorder.length == 0 || inorder.length != postorder.length) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int start1,int end1, int[] postorder, int start2,int end2){
        if(start1 > end1 || start2 > end2) return null;
        TreeNode root = new TreeNode(postorder[end2]);
        int position = start1;
    
        for(; position <= end1; position++) 
             if(root.val == inorder[position]) break;
        root.left = build(inorder,start1,position-1, postorder, start2,end2-end1+position-1);
        root.right = build(inorder,position+1,end1, postorder, end2-end1+position,end2-1);
        return root;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConstructBinaryTreefromInorderandPostorderTraversal test = new ConstructBinaryTreefromInorderandPostorderTraversal();
        int[] in = new int[4];
        int[] post = new int[2];
        in[0] = 2; in[1] =1; in[2] = 3; in[3] =6;
        post[0] = 2; post[1] =1;
      
        //test.buildTree(in,post);
        
    }
    
}
