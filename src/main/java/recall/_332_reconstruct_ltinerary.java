package recall;

import java.util.*;
//本题将图遍历问题转化成树类问题处理，使用了回溯的思想，也算是深度遍历，两者都离不开递归
public class _332_reconstruct_ltinerary {
    class Solution {
        List<String> res=new ArrayList();
        Map<String, Map<String,Integer>> map=new HashMap();  //选择好合适的数据结构
        public boolean backTracking(int ticketNum){
            if(res.size()==ticketNum+1){             //通过res的大小判断层数
                return true;
            }
            String last=res.get(res.size()-1);
            if(map.containsKey(last)){
                for(Map.Entry<String,Integer> target : map.get(last).entrySet()){
                    int count=target.getValue();
                    if(count>0){
                        res.add(target.getKey());
                        target.setValue(count-1);
                        if(backTracking(ticketNum)) return true;    //找到最优解就可以返回了
                        res.remove(res.size()-1);
                        target.setValue(count);
                    }
                }
            }
            return false;
        }
        public List<String> findItinerary(List<List<String>> tickets) {
            for(List<String> list : tickets){
                Map<String,Integer> temp;
                if(map.containsKey(list.get(0))){
                    temp=map.get(list.get(0));
                    temp.put(list.get(1),temp.getOrDefault(list.get(1),0)+1);
                }else{
                    temp=new TreeMap<>();          //升序map，满足题目《最近》的要求
                    temp.put(list.get(1),1);
                }
                map.put(list.get(0),temp);
            }
            res.add("JFK");
            backTracking(tickets.size());
            return res;
        }
    }
}
