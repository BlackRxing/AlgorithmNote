package array;

import java.util.HashMap;
//还是滑动窗口的算法，难点在于出现三个元素时的处理
public class _904_fruit_into_basket {
    class Solution {
        public int totalFruit(int[] tree) {
            HashMap<Integer,Integer> map=new HashMap<>();
            int result=0;
            int i=0,j=0;
            for(;j<tree.length;j++){
                if(map.containsKey(tree[j])){
                    map.replace(tree[j],map.get(tree[j])+1);
                }else{
                    map.put(tree[j],1);
                }
                while(map.size()>=3){
                    map.replace(tree[i],map.get(tree[i])-1);
                    if(map.get(tree[i])==0){
                        map.remove(tree[i]);
                    }
                    i++;
                }
                result=Math.max(result,j-i+1);
            }
            return result;
        }
    }
}
