package queue;

import java.util.LinkedList;
import java.util.Queue;

//first solution ,using two queues
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList();
        queue2=new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

//second solution ,using only one queue
class MyStack2 {
    Queue<Integer> queue1;
    /** Initialize your data structure here. */
    public MyStack2() {
        queue1=new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size=queue1.size();
        queue1.offer(x);
        for(int i=1;i<=size;i++){
            queue1.offer(queue1.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}