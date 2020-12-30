package stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
        minstack=new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(minstack.empty()||minstack.peek()>=x){
            minstack.push(x);
        }
    }

    public void pop() {
        if(minstack.peek().equals(stack.peek())){
            minstack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}