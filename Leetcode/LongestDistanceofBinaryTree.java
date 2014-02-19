/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestdistanceofbinarytree;

/**如果我们把二叉树看成一个图，父子节点之间的连线看成是双向的，
 * 我们姑且定义"距离"为两节点之间边的个数。写一个程序求一棵二叉树中相距最远的两个节点之间的距离。
 *
 * @author Xi Yu
 */
public class LongestDistanceofBinaryTree {

    /**  1.用2次BFS找到2个相距最远的值
     *   2.转化为：“二叉树每个节点的左右子树高度和的最大值”
     * @param args the command line arguments
     */
    
     static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    
    private int tree_height( TreeNode root, int[] max_distance){  //本问题可以转化为：“二叉树每个节点的左右子树高度和的最大值”
        if(root == null) return -1;
        int left = tree_height(root.left,max_distance)+1;
        int right = tree_height(root.right,max_distance)+1;
        int distance = left+right;
        if(max_distance[0]<distance) max_distance[0]=distance;
        return (left>right?left:right);
    }
    
    public int tree_diameter(TreeNode root){
        int[] max_distance = {0}; //利用array Max_distance作为全局变量  static variable
        if(root!=null) tree_height(root,max_distance);
        return max_distance[0];
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LongestDistanceofBinaryTree test = new LongestDistanceofBinaryTree();
        TreeNode root = new TreeNode(1);                           //     1
        root.left = new TreeNode(2);                            //      /   \
        root.right = new TreeNode(3);                          //     2      3          
        root.right.right = new TreeNode(3);                 //       /  \     \
        root.right.right.right = new TreeNode(3);           //      4    2     3
        root.left.left = new TreeNode(4);                   //            \     \
        root.left.right = new TreeNode(2);                  //             2     3
        root.left.right.right = new TreeNode(2);            //              \
        root.left.right.right.right = new TreeNode(2);      //               2
        int result = test.tree_diameter(root);
        System.out.println(result);
    }
    
}
