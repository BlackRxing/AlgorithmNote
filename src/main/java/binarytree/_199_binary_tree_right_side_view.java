package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_binary_tree_right_side_view {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list=new ArrayList();
            Queue<TreeNode> queue=new LinkedList();
            if(root==null){
                return list;
            }
            queue.offer(root);
            while(!queue.isEmpty()){
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode node=queue.poll();
                    if(i==size-1)
                    {
                        list.add(node.val);
                    }
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
            }
            return list;
        }
    }
}

//深度搜素，使用堆栈实现中序遍历，右中左，每一行右边第一个一定第一个被遍历到
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//        int max_depth = -1;
//
//        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
//        Stack<Integer> depthStack = new Stack<Integer>();
//        nodeStack.push(root);
//        depthStack.push(0);
//
//        while (!nodeStack.isEmpty()) {
//            TreeNode node = nodeStack.pop();
//            int depth = depthStack.pop();
//
//            if (node != null) {
//                // 维护二叉树的最大深度
//                max_depth = Math.max(max_depth, depth);
//
//                // 如果不存在对应深度的节点我们才插入
//                if (!rightmostValueAtDepth.containsKey(depth)) {
//                    rightmostValueAtDepth.put(depth, node.val);
//                }
//
//                nodeStack.push(node.left);
//                nodeStack.push(node.right);
//                depthStack.push(depth + 1);
//                depthStack.push(depth + 1);
//            }
//        }
//
//        List<Integer> rightView = new ArrayList<Integer>();
//        for (int depth = 0; depth <= max_depth; depth++) {
//            rightView.add(rightmostValueAtDepth.get(depth));
//        }
//
//        return rightView;
//    }
//}
//
//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
