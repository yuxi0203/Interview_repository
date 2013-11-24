/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reversebinarytreebybfs;
import java.util.Collections; 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * @author Xi Yu
 */
public class ReverseBinaryTreebyBFS {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    /**
     * @param args the command line arguments
     */
    
     public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();   //申明queue 以实现广度优先
        int queueIn = 1;                                            //queueIn和queueOut用来区分不同行，解决换行时ArrayList无法结束问题
        queue.offer(root);                        //cont.基本想法是：用inCount记录某层有多少个元素，outCount记录当前输出了多少个元素
        while(queue.size()!=0)
        {   
            int queueOut = 0;
            ArrayList<Integer> temp = new ArrayList<Integer>();     //申明temp保存以行为单位的节点 之前翻错误时用.clear()来清空以
                                                            //cont.存储新行节点，这样ArrayList之前所有数据都会清空，导致result返回空
            while(queueOut<queueIn)                                 
            {                                               //当当前行输出节点数小于上一层节点数所有孩子总和时，temp继续写入节点
                TreeNode curnode = queue.poll();
                temp.add(curnode.val);
                if(curnode.left!=null)
                {
                    queue.offer(curnode.left);
                }
                if(curnode.right!=null)
                {
                    queue.offer(curnode.right);
                }
                queueOut++;
            }
            result.add(temp);
            queueIn = queue.size();         //当第K层元素全部出队（并已将各自左右孩子入队）后，队列里面刚好存放了第K+1层的所有元素
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
