package stack;

import java.util.Stack;

class Solution394 {
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        int num=0;
        Stack<Integer> numstack=new Stack();
        Stack<String> resstack=new Stack();
        for(char c:s.toCharArray()){
            if(c=='['){
                resstack.push(res.toString());
                numstack.push(num);
                res=new StringBuilder();
                num=0;
            }else if(c==']'){
                StringBuilder tmp=new StringBuilder();
                int iter=numstack.pop();
                for(int i=0;i<iter;i++){
                    tmp.append(res);
                }
                res=new StringBuilder(resstack.pop()+tmp);
            }else if(c>='0'&&c<='9'){
                num=num*10+c-'0';
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

}
