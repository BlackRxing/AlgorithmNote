package array;

import java.util.Stack;

public class _42_trap {
    //方法一：双指针，一个点上积累多少水取决于左右两边最大值的最小值，从两边往中间收缩能够迅速找到满足条件的这一值
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (height[left] < height[right]) {
                    ans += leftMax - height[left];
                    ++left;
                } else {
                    ans += rightMax - height[right];
                    --right;
                }
            }
            return ans;
        }
    }
    //使用堆栈，看起来简单写起来很多容易出错
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stack=new Stack<Integer>();
            int result=0;
            for(int i=0;i<height.length;i++){
                while(!stack.isEmpty()&&height[stack.peek()]<height[i]){  //遇到堆栈就想到检查是否为空
                    int temp=stack.pop();
                    if(stack.isEmpty()){    //该点上方的积水取决于该点两边的高度
                        break;
                    }
                    int h=(Math.min(height[stack.peek()],height[i])-height[temp]); //这里取最小值不容易想到
                    result+=h*(i-stack.peek()-1);
                }
                stack.push(i);
            }
            return result;
        }
    }
}
