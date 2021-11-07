package greedy;
//动态更新能够到达的范围
public class _55_jump_game {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            //覆盖范围
            int coverRange = nums[0];
            //在覆盖范围内更新最大的覆盖范围
            for (int i = 0; i <= coverRange; i++) {
                coverRange = Math.max(coverRange, i + nums[i]);
                if (coverRange >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
