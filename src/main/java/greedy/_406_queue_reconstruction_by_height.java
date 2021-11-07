package greedy;

import java.util.ArrayList;
import java.util.Arrays;
//两个维度得先确定一个，依照高度先排序，然后按从高到低依次插入，因为后面的更小，即使插入到前面也不会影响
public class _406_queue_reconstruction_by_height {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people,(a, b)->{
                if(a[0]==b[0]) return a[1]-b[1]; //先按照高度排序，相同高度按次序再排
                return b[0]-a[0];
            });
            ArrayList<int[]> que=new ArrayList<>();
            for(int [] p:people){
                que.add(p[1],p);
            }
            return que.toArray(new int[people.length][]);
        }
    }
}
