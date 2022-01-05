package listnode;

import java.util.Map;

//使用双向链表和hashmap，功能代码分离开来
public class _146_latest_requested_unit {
    class LRUCache {
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;
            public DLinkedNode(){}
            public DLinkedNode(int key,int value){this.key=key;this.value=value;}
        }
        private M
        ap<Integer,DLinkedNode> cache=new HashMap<Integer,DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head,tail;

        public LRUCache(int capacity) {
            this.size=0;
            this.capacity=capacity;
            head=new DLinkedNode();
            tail=new DLinkedNode();
            head.next=tail;
            tail.pre=head;
        }

        public int get(int key) {
            DLinkedNode node=cache.get(key);
            if(node==null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node=cache.get(key);
            if(node==null){
                if(size==capacity){
                    DLinkedNode tail=removeTail();
                    cache.remove(tail.key);
                    size--;
                }
                DLinkedNode res=new DLinkedNode(key,value);
                addToHead(res);
                cache.put(key,res);
                size++;
            }else{
                node.value=value;
                moveToHead(node);
            }
        }

        private void removeNode(DLinkedNode node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        private DLinkedNode removeTail(){
            DLinkedNode node=tail.pre;
            removeNode(node);
            return node;
        }
        private void addToHead(DLinkedNode node){
            DLinkedNode res=head.next;
            res.pre=node;
            node.next=res;
            head.next=node;
            node.pre=head;
        }
        private void moveToHead(DLinkedNode node){
            removeNode(node);
            addToHead(node);
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
