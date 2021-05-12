package binarytree;

import java.util.ArrayList;
import java.util.List;
//很明显需要回溯，所以递归最简单（递归可以保留相关状态变量），而且使用先序遍历，递归函数不能传递stringbuilder，因为stringbuilder应用的是同一个对象！！左节点改变后的右节点也会引用！！
//也可以使用迭代法的先序遍历
public class _257_binary_tree_paths {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans=new ArrayList();
            findPaths(root,"",ans);
            return ans;
        }
        public void findPaths(TreeNode node,String s,List<String> ans){
            if(node!=null){
                String ss=s+Integer.toString(node.val);
                if(node.left==null&&node.right==null){
                    ans.add(ss);
                    return;
                }
                findPaths(node.left,ss+"->",ans);
                findPaths(node.right,ss+"->",ans);
            }
            return;
        }
    }
}
//class Solution {
//    public:
//    vector<string> binaryTreePaths(TreeNode* root) {
//        stack<TreeNode*> treeSt;// 保存树的遍历节点
//        stack<string> pathSt; // 保存遍历路径的节点
//        vector<string> result; // 保存最终路径集合
//        if (root == NULL) return result;
//        treeSt.push(root);
//        pathSt.push(to_string(root->val));
//        while (!treeSt.empty()) {
//            TreeNode* node = treeSt.top(); treeSt.pop(); // 取出节点 中
//            string path = pathSt.top();pathSt.pop(); // 取出该节点对应的路径
//            if (node->left == NULL && node->right == NULL) { // 遇到叶⼦节点
//                result.push_back(path);
//            }
//            if (node->right) { // 右
//                treeSt.push(node->right);
//                pathSt.push(path + "->" + to_string(node->right->val));
//            }
//            if (node->left) {
//                treeSt.push(node->left);
//                pathSt.push(path + "->" + to_string(node->left->val));
//            }
//        }
//        return result;
//    }
//};
