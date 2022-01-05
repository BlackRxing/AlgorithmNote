package sort;

import java.util.Arrays;
//5 56 33 4,有相同部分的如何排序，5与56,56应该放在最前面，比如5 52 ，5应该放在前面，
public class _179_largest_number {
    class Solution {
        public String largestNumber(int[] nums) {
            int n=nums.length;
            Integer[] numsArr=new Integer[n];  //转化为类才能用comparable
            for(int i=0;i<n;i++){
                numsArr[i]=nums[i];
            }
            Arrays.sort(numsArr,(x, y)->{ //最关键的一部分代码，比较的方法就是转化为整数AB BA进行比较，
                //n=x while(n!=0) {n/10； y*=10}这样写不行 比如0 9 判断为相等 0可能排在9前面
                long sx = 10, sy = 10;
                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return (int) (-sy * x - y + sx * y + x);
            });
            //针对【0，0,0】这种特殊情况
            if(numsArr[0]==0){
                return "0";
            }
            StringBuilder s=new StringBuilder();
            for(int num:numsArr){
                s.append(num);
            }
            return s.toString();
        }
    }

}
