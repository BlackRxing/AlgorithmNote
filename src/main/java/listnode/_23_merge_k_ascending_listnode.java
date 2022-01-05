package listnode;

import java.util.PriorityQueue;
//本体有三种解法，
//1.两两合并，复杂度为k^2*n
//2.分治优化，每一次都是两个两个合并，k*n*log(k)
//3.优先队列，每次新的首个元素插入都是logk，一共需要插入kn次，复杂度同2
public class _23_merge_k_ascending_listnode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        class Status implements Comparable<Status> { //便于优先队列比较大小
            int val;
            ListNode node;

            Status(int val, ListNode node) {
                this.val = val;
                this.node = node;
            }

            public int compareTo(Status status2) {
                return this.val - status2.val;
            }
        }

        PriorityQueue<Status> queue = new PriorityQueue<Status>();

        public ListNode mergeKLists(ListNode[] lists) {
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(new Status(node.val, node));
                }
            }
            ListNode head, cur = null;
            head = new ListNode(0, null);
            cur = head;
            while (!queue.isEmpty()) {
                Status status = queue.poll();
                cur.next = status.node;
                cur = cur.next;
                if (cur.next != null) {
                    queue.offer(new Status(cur.next.val, cur.next));
                }
            }
            return head.next;
        }
    }
    //分治算法，重点在于想到利用递归去分治
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }

}

