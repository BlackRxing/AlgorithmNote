package array;

import java.util.Arrays;
//使用双指针，将开始和结束时间分别排序
public class _253_meeting_rooms_II {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            int start=0;
            int end=0;
            int length=intervals.length;
            int[] list1=new int[length];
            int[] list2=new int[length];
            int i=0;
            for(int[] x:intervals){
                list1[i]=x[0];
                list2[i]=x[1];
                i++;
            }
            int result=0;
            int temp=0;
            int count=0;
            Arrays.sort(list1);
            Arrays.sort(list2);
            while(start!=length&&end!=length){
                if(list1[start]>=list2[end]){  //当开始时间和结束时间重叠时，优先结束时间，统一只计算算开始时间的那一点
                    count--;
                    end++;
                }else{
                    count++;
                    result=Math.max(result,count);
                    start++;
                }
            }
            return result;

        }
    }
}
