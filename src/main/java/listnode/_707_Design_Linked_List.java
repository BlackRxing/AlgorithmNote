package listnode;
//注释部分使用虚拟头结点写起来最简单。
public class _707_Design_Linked_List {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val=val;
        }
    }
    class MyLinkedList {
        int size=0;
        ListNode head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            head=null;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            System.out.println(index+"");
            System.out.println(size+"");
            System.out.println(head.val+"");
            if(index<0||index>=size||head==null){
                return -1;
            }
            ListNode cur=head;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode node=new ListNode(val);
            if(head==null){
                head=node;
            }else{
                node.next=head;
                head=node;
            }
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if(size==0){
                head=new ListNode(val);
                size++;
                return;
            }
            ListNode node=head;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new ListNode(val);
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            ListNode pre=null,cur;
            if(index>size){
                return;
            }else if(index==0){
                addAtHead(val);
            }else if(index==size){
                addAtTail(val);
            }else{
                cur=head;
                for(int i=0;i<index;i++){
                    pre=cur;
                    cur=cur.next;
                }
                ListNode node=new ListNode(val);
                pre.next=node;
                node.next=cur;
                size++;
            }

        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index>=size||size==0){
                return;
            }
            ListNode pre=null,cur=head;
            if(index==0){
                head=head.next;
            }else{
                for(int i=0;i<index;i++){
                    pre=cur;
                    cur=cur.next;
                }
                pre.next=cur.next;
            }
            size--;
        }
    }
}



//class MyLinkedList {
//    //size存储链表元素的个数
//    int size;
//    //虚拟头结点
//    ListNode head;
//
//    //初始化链表
//    public MyLinkedList() {
//        size = 0;
//        head = new ListNode(0);
//    }
//
//    //获取第index个节点的数值
//    public int get(int index) {
//        //如果index非法，返回-1
//        if (index < 0 || index >= size) {
//            return -1;
//        }
//        ListNode currentNode = head;
//        //包含一个虚拟头节点，所以查找第 index+1 个节点
//        for (int i = 0; i <= index; i++) {
//            currentNode = currentNode.next;
//        }
//        return currentNode.val;
//    }
//
//    //在链表最前面插入一个节点
//    public void addAtHead(int val) {
//        addAtIndex(0, val);
//    }
//
//    //在链表的最后插入一个节点
//    public void addAtTail(int val) {
//        addAtIndex(size, val);
//    }
//
//    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
//    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
//    // 如果 index 大于链表的长度，则返回空
//    public void addAtIndex(int index, int val) {
//        if (index > size) {
//            return;
//        }
//        if (index < 0) {
//            index = 0;
//        }
//        size++;
//        //找到要插入节点的前驱
//        ListNode pred = head;
//        for (int i = 0; i < index; i++) {
//            pred = pred.next;
//        }
//        ListNode toAdd = new ListNode(val);
//        toAdd.next = pred.next;
//        pred.next = toAdd;
//    }
//
//    //删除第index个节点
//    public void deleteAtIndex(int index) {
//        if (index < 0 || index >= size) {
//            return;
//        }
//        size--;
//        ListNode pred = head;
//        for (int i = 0; i < index; i++) {
//            pred = pred.next;
//        }
//        pred.next = pred.next.next;
//    }
//}
