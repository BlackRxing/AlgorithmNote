package greedy;
//
public class _56_merge_intervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(o1,o2) -> Integer.compare(o1[0],o2[0]));
            int start=intervals[0][0];
            List<int[]> res=new ArrayList<>();
            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]<=intervals[i-1][1]){
                    intervals[i][1]=Math.max(intervals[i][1],intervals[i-1][1]);
                }else{
                    res.add(new int[]{start,intervals[i-1][1]});
                    start=intervals[i][0];
                }
            }
            res.add(new int[]{start,intervals[intervals.length-1][1]});
            return res.toArray(new int[res.size()][2]);
        }
    }
}
