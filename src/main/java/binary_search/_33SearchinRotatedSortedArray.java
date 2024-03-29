package binary_search;


//主要注意两个问题，一个是是否一定能收敛，如果中间取下mid=（left+right）/2,那么left=mid就要注意可能一直无法收敛（达到left=right），
//尽量把三种情况分开写！考试时不一定想得出第二种写法
class Solution35 {
    class Solution {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1;
            int mid=0;
            while(left<right){
                System.out.println(left+" "+right);
                mid=(left+right)/2;
                if(nums[mid]<nums[right]){
                    if(nums[mid]<target){
                        if(target<=nums[right]){
                            left=mid+1;
                        }else{
                            right=mid-1;
                        }
                    }else{
                        right=mid;
                    }
                }else{
                    if(nums[mid]<target){
                        left=mid+1;
                    }else if(nums[mid]>target){
                        if(target>=nums[left]){
                            right=mid-1;
                        }else{
                            left=mid+1;
                        }
                    }else{     //这个else非常必要，如果不加的话没法收敛
                        return mid;
                    }
                }
            }
            if(nums[left]==target){
                return left;
            }
            return -1;
        }
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = left + (right - left) / 2;//去偏左的位置

            if (nums[mid] < nums[right]) {
                //取mid+1是为了收缩区间
                if (nums[mid+1] <= target && target <= nums[right]) {
                    // 下一轮搜索区间是 [mid+1, right]
                    left = mid+1;
                } else {
                    right = mid ;
                }

            } else {
                if (nums[left] <= target && target <= nums[mid]) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // 下一轮搜索区间是 [mid+1, right]
                    left = mid+1;
                }
            }
        }

        // 有可能区间内不存在目标元素，因此还需做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
//也可以去中间偏右的mid，相应的收缩改变即可
//public class Solution2 {
//
//    public int search(int[] nums, int target) {
//        int len = nums.length;
//        if (len == 0) {
//            return -1;
//        }
//
//        int left = 0;
//        int right = len - 1;
//        while (left < right) {
//
//            int mid = left + (right - left  + 1) / 2;
//
//            if (nums[mid] < nums[right]) {
//
//                // 使用上取整的中间数，必须在上面的 mid 表达式的括号里 + 1
//                if (nums[mid] <= target && target <= nums[right]) {
//                    // 下一轮搜索区间是 [mid, right]
//                    left = mid;
//                } else {
//                    // 只要上面对了，这个区间是上面区间的反面区间，下一轮搜索区间是 [left, mid - 1]
//                    right = mid - 1;
//                }
//
//            } else {
//
//                // [left, mid] 有序，但是为了和上一个 if 有同样的收缩行为，
//                // 我们故意只认为 [left, mid - 1] 有序
//                // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
//                // 此时 mid - 1 不会越界，就是这么刚刚好
//
//                if (nums[left] <= target && target <= nums[mid - 1]) {
//                    // 下一轮搜索区间是 [left, mid - 1]
//                    right = mid - 1;
//                } else {
//                    // 下一轮搜索区间是 [mid, right]
//                    left = mid;
//                }
//            }
//        }
//
//        // 有可能区间内不存在目标元素，因此还需做一次判断
//        if (nums[left] == target) {
//            return left;
//        }
//        return -1;
//    }
//}
//


