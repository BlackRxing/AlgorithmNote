package stack;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length=T.length;
        int result[]=new int[length];
        Stack<Integer> stack=new Stack();
        for(int i=0;i<length;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int a=stack.pop();
                result[a]=i-a;
            }
            stack.push(i);
        }
        return result;
    }
}
