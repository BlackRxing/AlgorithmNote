package stack;

import java.util.Stack;
//使用两个数组分别保存每一点的左边界以及右边届，最后计算最大值
public class _84_largest_rectangle_in_histogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int[] left=new int[heights.length];
            int[] right=new int[heights.length];
            Stack<Integer> stack=new Stack();
            for(int i=0;i<heights.length;i++){
                while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){  //stack必须要是递增的
                    stack.pop();
                }
                left[i]=(stack.isEmpty()?-1:stack.peek());
                stack.push(i);
            }
            stack.clear();
            for(int i=heights.length-1;i>=0;i--){
                while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                right[i]=(stack.isEmpty()?heights.length:stack.peek());
                stack.push(i);
            }
            int result=0;
            for(int i=0;i<heights.length;i++){
                result=Math.max(result,(right[i]-left[i]-1)*heights[i]);
            }
            return result;
        }
    }
}
