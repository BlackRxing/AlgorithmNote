package array;

import java.util.Arrays;
import java.util.List;
//3数字之和的升级版，就是外层再加一层循环，建议先看3数字之和
public class _18_4sum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
            //第一个数字防止重复
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                //第二个数字防止重复
                for (int j = i + 1; j < nums.length; j++) {

                    if (j > i + 1 && nums[j - 1] == nums[j]) {
                        continue;
                    }

                    int left = j + 1;
                    int right = nums.length - 1;
                    while (right > left) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum > target) {
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                            while (right > left && nums[right] == nums[right - 1]) right--;
                            while (right > left && nums[left] == nums[left + 1]) left++;

                            left++;
                            right--;
                        }
                    }
                }
            }
            return result;
        }
    }
}
