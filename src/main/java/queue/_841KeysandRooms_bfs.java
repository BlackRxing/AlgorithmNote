package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue=new LinkedList<>();
        int[] mark=new int[rooms.size()];
        queue.offer(0);
        while(!queue.isEmpty()){
            int num=queue.poll();
            mark[num]=-1;
            for(Integer i:rooms.get(num)){
                if(mark[i]!=-1){
                    queue.offer(i);
                }
            }
        }
        for(int i:mark){
            if(i!=-1){
                return false;
            }
        }
        return true;
    }
}