package priorityqueue;

import java.util.Deque;
import java.util.LinkedList;
//如果直接使用优先队列时间复杂度为nlogk，所以本题构造单调队列，比如i>j ai>aj ，那么j可以直接从队列中去除， 通过这样去除冗余的对比
// 使用双向列表linkedlist，保持其头部到尾部递增，新加入的数字从头部开始对比，一直找到比他大的数，前面的扔掉，同时检查队列尾部是否在范围内，最终时间复杂度为On
public class _239_sliding_window_maximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque=new LinkedList();
            int[] result=new int[nums.length-k+1];
            for(int i=0;i<nums.length;i++){
                while(!deque.isEmpty()&&nums[i]>=nums[deque.peekFirst()]){
                    deque.pollFirst();
                }
                deque.offerFirst(i);
                if(deque.peekLast()<(i-k+1)){
                    deque.pollLast();
                }
                if(i>=k-1){
                    result[i-k+1]=nums[deque.peekLast()];  //每次最多提出一个范围外元素
                }
            }
            return result;
        }
    }
}
