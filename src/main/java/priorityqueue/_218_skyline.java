package priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//按顺序记录左右点，然后使用优先队列得出目前堆的最大高度
public class _218_skyline {
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            int[][] res=new int[buildings.length*2][2];
            List<List<Integer>> result=new ArrayList();
            int x=0;
            for(int[] i:buildings){
                res[x++]=new int[]{i[0],i[2]};
                res[x++]=new int[]{i[1],-i[2]}; //负数巧妙地满足排列顺序，当然也可以三维，最后以为标记左右
            }
            Arrays.sort(res,(a, b) ->{
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return b[1]-a[1];  //先左边，从大到小，后右边，从小到大，四个顺序一个也不能错！降序排列！！！
                }
            });
            PriorityQueue<Integer> queue=new PriorityQueue<>((a, b)->b-a);  //降序排列！！！，默认是升序
            queue.add(0);
            int pre=-1;
            for(int[] i:res){
                int height=i[1];
                int pos=i[0];
                int xheight=(height<0?-height:height);
                if(height>0){
                    if(height>queue.peek()&&pre!=pos){
                        ArrayList<Integer> a=new ArrayList();
                        a.add(pos);
                        a.add(xheight);
                        result.add(a);
                        pre=pos;           //防止重复多点
                    }
                    queue.add(xheight);
                }else{
                    queue.remove(xheight);  //一定要先移除
                    if(xheight>queue.peek()&&pre!=pos){
                        ArrayList<Integer> a=new ArrayList();
                        a.add(pos);
                        a.add(queue.peek());
                        result.add(a);
                        pre=pos;        //防止重复多点
                    }
                }
            }
            return result;
        }
    }
}
