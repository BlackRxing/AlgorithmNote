package greedy;

import java.util.Arrays;

public class _452_minimum_nummber_of_arrows_to_burst_balloons {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0])); //这里写成 {return o1[0]-o2[0];} 测试用例[[-2147483646,-2147483645],[2147483646,2147483647]]无法通过，溢出
            int left=points[0][0],right=points[0][1];
            int count=1;
            for(int i=1;i<points.length;i++){
                if(points[i][0]<=right){
                    left=points[i][0];
                    right=Math.min(right,points[i][1]);
                }else{
                    left=points[i][0];
                    count++;
                    right=points[i][1];
                }
            }
            return count;
        }
    }
}
