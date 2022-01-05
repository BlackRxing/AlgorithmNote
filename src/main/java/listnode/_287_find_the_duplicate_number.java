package listnode;
//构建i->nums[i]的单链表，对于0，有一个指出，对于1-n，一个指出，一个指入，其中一个重复的数，一个指出，两个指入，容易感觉到重复的那个数字就是回环入口
public class _287_find_the_duplicate_number {
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
