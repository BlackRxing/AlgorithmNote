package String;
//先理清题意
public class _71_simplify_path {
    class Solution {
        public String simplifyPath(String path) {
            String[] names = path.split("/");  //使用函数直接分割，不直接分割容易忽略情况
            Deque<String> stack = new ArrayDeque<String>(); //用stack没有问题
            for (String name : names) {
                if ("..".equals(name)) {      //弹出最上面一个
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else if (name.equals("") ||name.equals(".")) {  //这两种情况不作处理
                    //none
                }else{
                    stack.offerLast(name);  //放入这一个字符串
                }
            }
            StringBuffer ans = new StringBuffer();
            if (stack.isEmpty()) {
                ans.append('/');  //如果是空的直接返回根目录
            } else {
                while (!stack.isEmpty()) {
                    ans.append('/');
                    ans.append(stack.pollFirst());
                }
            }
            return ans.toString();
        }
    }

}
