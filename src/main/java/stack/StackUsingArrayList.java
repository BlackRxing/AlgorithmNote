package stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {
    private List<Integer> data;
    public StackUsingArrayList(){
        data=new ArrayList<>();
    }
    public void add(int x){
        data.add(x);
    }
    public void push(int x){
        data.add(x);
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public int top(){
        return data.get(data.size()-1);
    }
    public boolean pop(){
        if(data.isEmpty()){
            return false;
        }
        data.remove(data.size()-1);
        return true;
    }

    public static void main(String[] args) {
        StackUsingArrayList stack=new StackUsingArrayList();
        for(int i=0;i<=5;i++){
            stack.add(i);

        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
