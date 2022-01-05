package binarytree;

import java.util.ArrayList;
import java.util.List;
//1.先序遍历可以先遍历左侧（root算在左侧里面），叶子结点和右侧是交错的，但右侧顺序需要翻转，使用stack，或list.add(0,element)
//2.关于叶子结点和左右侧重叠有两个，可以使用if else，如果是不是左右侧，在判断是不是叶子节点
//3.使用flag表示，0是根，1是左侧，2是右侧，3是叶子和其他
//4.可以根据父节点和父节点状态判断左右子节点属于哪一类
public class _545_boundary_of_binary_tree {
    class Solution {
        private List<Integer> leafList=new ArrayList();        //叶子和右侧混在一起了，需要创建list
        private List<Integer> rightList=new ArrayList();
        private List<Integer> result=new ArrayList();
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            preTraversal(root,0);
            result.addAll(leafList);
            result.addAll(rightList);
            return result;
        }
        private boolean isLeaf(TreeNode node){
            return node.left==null&&node.right==null;
        }
        private int judgeLeft(TreeNode node,int flag){
            if(flag==1||flag==0){  //flag==0不能漏
                return 1;
            }else if(flag==2&&node.right==null){ //如果是右侧右子节点没有，左子节点也可能是右侧
                return 2;
            }
            return 3;
        }
        private int judgeRight(TreeNode node,int flag){
            if(flag==2||flag==0){
                return 2;
            }else if(flag==1&&node.left==null){
                return 1;
            }
            return 3;
        }
        private void preTraversal(TreeNode node,int flag){
            if(node==null){   //这一步不能漏
                return;
            }
            if(flag==0||flag==1){   //左侧可以直接添加
                result.add(node.val);
            }else if(flag==2){
                rightList.add(0,node.val);  //倒序添加
            }else if(isLeaf(node)){       //叶子节点直接判断
                leafList.add(node.val);
            }
            preTraversal(node.left,judgeLeft(node,flag));
            preTraversal(node.right,judgeRight(node,flag));
        }
    }
}
