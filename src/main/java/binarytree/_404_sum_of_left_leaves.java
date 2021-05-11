package binarytree;
//前序遍历，广度遍历，递归都可以
//递归
public class _404_sum_of_left_leaves {
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            // Integer ans=0;
            int ans=findsum(root);
            return ans;
        }
        public int findsum(TreeNode node){
            int ans=0;
            if(node!=null){
                if(node.left!=null&&node.left.left==null&&node.left.right==null){
                    ans+=node.left.val;
                }else{
                    ans+=findsum(node.left);
                }
                ans+=findsum(node.right);
            }
            return ans;
        }
    }
}

//前序遍历
//class Solution {
//    public:
//    int sumOfLeftLeaves(TreeNode* root) {
//        stack<TreeNode*> st;
//        if (root == NULL) return 0;
//        st.push(root);
//        int result = 0;
//        while (!st.empty()) {
//            TreeNode* node = st.top();
//            st.pop();
//            if (node->left != NULL && node->left->left == NULL && node->left->right ==
//                    NULL) {
//                result += node->left->val;
//            }
//            if (node->right) st.push(node->right);
//            if (node->left) st.push(node->left);
//        }
//        return result;
//    }
//};

//广度遍历
//class Solution {
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        int ans = 0;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left != null) {
//                if (isLeafNode(node.left)) {
//                    ans += node.left.val;
//                } else {
//                    queue.offer(node.left);
//                }
//            }
//            if (node.right != null) {
//                if (!isLeafNode(node.right)) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return ans;
//    }
//
//    public boolean isLeafNode(TreeNode node) {
//        return node.left == null && node.right == null;
//    }
//}
//
//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。