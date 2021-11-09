package greedy;

import java.util.Arrays;
//按右边排序写法
public class _435_non_overlapping_intervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals,(o1, o2) -> {
                return o1[1]-o2[1];
            });
            int count=1;
            int edge=intervals[0][1];
            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]<edge){
                    edge=Math.min(intervals[i][1],edge);
                }else{
                    count++;
                    edge=intervals[i][1];
                }
            }
            return intervals.length-count;
        }
    }
}
//按左边排序写法
//class Solution {
//    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals,(o1,o2) -> {
//            return o1[1]-o2[1];
//        });
//        int count=1;
//        int edge=intervals[0][1];
//        for(int i=1;i<intervals.length;i++){
//            if(intervals[i][0]<edge){
//                edge=Math.min(intervals[i][1],edge);
//            }else{
//                count++;
//                edge=intervals[i][1];
//            }
//        }
//        return intervals.length-count;
//    }
//}
