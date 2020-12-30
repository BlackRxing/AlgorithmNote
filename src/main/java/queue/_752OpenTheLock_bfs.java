
package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//solution1使用变量记录每一层的数量，从而得到迭代层数
public class _752OpenTheLock_bfs {

        public int openLock(String[] deadends, String target) {
            Set<String> dead = new HashSet();
            for (String d : deadends) {
                dead.add(d);
            }
            Queue<String> queue = new LinkedList();
            queue.offer("0000");
            Set<String> seen = new HashSet();
            seen.add("0000");
            int depth = 0;
            int n = 1;
            int nextnum;
            while (n != 0) {
                nextnum = 0;
                for (; n > 0; n--) {
                    String node = queue.poll();
                    if (node.equals(target)) {
                        return depth;
                    }
                    if (!dead.contains(node)) {
                        for (int i = 0; i < 4; i++) {
                            for (int j = -1; j <= 1; j++) {
                                int x = ((node.charAt(i) - '0') + j + 10) % 10;
                                String next = node.substring(0, i) + x + node.substring(i + 1);
                                if (!seen.contains(next)) {
                                    queue.offer(next);
                                    nextnum++;
                                    seen.add(next);
                                }
                            }
                        }
                    }
                }
                n = nextnum;
                depth++;
            }
            return -1;
        }
}

//solution2 在队列中添加null来分割每一层
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList();
        Set<String> seen=new HashSet();
        Set<String> deads=new HashSet();
        int depth=0;
        for(String s:deadends){
            deads.add(s);
        }
        seen.add("0000");
        queue.offer("0000");
        queue.offer(null);
        while(!queue.isEmpty()){
            String node=queue.poll();
            if(node==null){
                depth++;
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }else if (node.equals(target)){
                return depth;
            }else if(!deads.contains(node)){
                for(int i=0;i<4;i++){
                    for(int j=-1;j<=1;j+=2){
                        int x=((node.charAt(i)-'0')+j+10)%10;
                        String s=node.substring(0,i)+x+node.substring(i+1);
                        if(!seen.contains(s)){
                            seen.add(s);
                            queue.offer(s);
                        }
                    }
                }
            }

        }
        return -1;
    }
}

