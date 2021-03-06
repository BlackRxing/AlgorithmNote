package binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }
}

  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
        this.left = left;
         this.right = right;
      }
  }

  //统一格式
//  class Solution {
//      public List<Integer> postorderTraversal(TreeNode root) {
//          List<Integer> list=new ArrayList();
//          Stack<TreeNode> stack=new Stack();
//          stack.add(root);
//          if(root==null){
//              return list;
//          }
//          while(!stack.isEmpty()){
//              TreeNode cur=stack.peek();
//              if(cur!=null){
//                  stack.push(null);
//                  if(cur.right!=null){
//                      stack.push(cur.right);
//                  }
//                  if(cur.left!=null){
//                      stack.push(cur.left);
//                  }
//              }else{
//                  stack.pop();
//                  list.add(stack.pop().val);
//              }
//          }
//          return list;
//      }
//  }
