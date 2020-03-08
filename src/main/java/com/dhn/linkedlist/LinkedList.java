//package com.dhn.linkedlist;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @description: 操作链表
// * @author: Dong HuaNan
// * @date: 2020/3/3 10:45
// */
//public class LinkedList {
//
//    /**
//     * 哨兵结点
//     */
//    Node head = new Node(0);
//    /**
//     * 链表长度
//     */
//    int length = 0;
//
//    /**
//     * 1.从尾结点开始添加结点
//     * @param val
//     */
//    public void tailInsert(int val){
//        //注意：指针从头结点开始
//        Node temp = head;
//        //当前结点的下一个结点不为null，则再检查下一个结点
//        while (temp.next!=null){
//            temp = temp.next;
//        }
//        //为空则新建结点，填入数据
//        temp.next = new Node(val);
//    }
//
//    /**
//     * 2.给定数组 1，2，3，4 构造如下链表 head-->4---->3---->2---->1
//     * 从头结点插入
//     * @param val
//     */
//    public void headInsert(int val){
//        //注意：指针从头结点开始
//        Node temp = head;
//        //新结点
//        Node newNode = new Node(val);
//        //新节点的指针指向头结点的下一个结点
//        newNode.next = temp.next;
//        //头结点指针指向新结点
//        temp.next = newNode;
//
//    }
//
//    /**
//     * 3.给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 内删除这个节点
//     * @param deleteNode
//     */
//    public void removeSelectedNode(Node deleteNode){
//        //注意：给定结点是尾结点，遍历寻找它的前继结点，再删除它
//        if (deleteNode.next == null) {
//            //注意：指针从头结点开始
//            Node temp = head;
//            while(temp.next != deleteNode){
//                temp = temp.next;
//            }
//            //删除该结点
//            temp.next = null;
//        }else{
//            //找到给定结点的下一个结点
//            Node nextNode = deleteNode.next;
//            //下一个结点的值赋给给定结点
//            deleteNode.data = nextNode.data;
//            //给定结点指向下下个结点
//            deleteNode.next = nextNode.next;
//            //删除下下个结点
//            nextNode.next = null;
//        }
//    }
//
//    /**
//     * 4.递归翻转链表
//     * @param node
//     * @return
//     */
//    public Node invertLinkedList(Node node){
//        if (node.next == null){
//            return node;
//        }
//        Node newNode = invertLinkedList(node.next);
//        node.next.next = node;
//        node.next = null;
//
//        return newNode;
//    }
//
//    /**
//     * 5.迭代翻转链表
//     */
//    public void iterationInvertLinkedList() {
//        Node pre = head.next;
//        Node cur = pre.next;
//         //注意：易错
//        pre.next = null;
//        while (cur!=null){
//            Node curNext = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = curNext;
//        }
//        //注意
//        head.next = pre;
//    }
//
//    /**
//     * 6.给定一个链表的头结点 head,以及两个整数 from 和 to ,在链表上把第 from 个节点和第 to 个节点这一部分进行翻转。
//     * 例如：给定如下链表，from = 2, to = 4 head-->5-->4-->3-->2-->1 将其翻转后，链表变成 head-->5--->2-->3-->4-->1
//     * @param fromIndex
//     * @param toIndex
//     */
//    public void iterationInvertLinkedList(int fromIndex,int toIndex) throws Exception {
//
//        // from结点
//        Node fromNode = null;
//        //from-1结点
//        Node preFromNode = null;
//        //to结点
//        Node toNode = null;
//        //to+1结点
//        Node nextToNode = null;
//
//        //注意：temp和index从何开始
//        Node temp = head.next;
//        //头结点index为1
//        int index = 1;
//
//        while(temp!=null){
//            if(index == fromIndex-1){
//                preFromNode = temp;
//            }else if (index == fromIndex){
//                fromNode = temp;
//            }else if (index == toIndex){
//                toNode = temp;
//            }else if(index == toIndex+1){
//                nextToNode = temp;
//            }
//
//            temp = temp.next;
//            index++;
//        }
//
//        //注意：特殊情况
//        if (fromNode==null||toNode==null){
//            throw new Exception("无法翻转");
//        }
//
//        //注意：cur永远是pre的下一个
//        Node pre = fromNode;
//        Node cur = pre.next;
//
//        //注意：cur到头的条件
//        while (cur!=nextToNode){
//            Node curNext = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = curNext;
//        }
//
//        //注意：判空
//        if(fromNode!=null) {
//            preFromNode.next = toNode;
//        }else {
//            head.next = toNode;
//        }
//
//        fromNode.next = nextToNode;
//
//    }
//
//    /**
//     * 7.todo (很不熟练)给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。k 是一个正整数，它的值小于或等于链表的长度。
//     * 如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
//     * 示例 : 给定这个链表：head-->1->2->3->4->5 当 k = 2 时，应当返回: head-->2->1->4->3->5
//     * 当 k = 3 时，应当返回: head-->3->2->1->4->5
//     * 说明 :
//     * 你的算法只能使用常数的额外空间。
//     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//     */
//    public void iterationInvertLinkedListEveryK(int k){
//
//        Node temp = head.next;
//        int step = 0;
//
//        Node startKPre = head;
//        Node startK = null;
//        Node endK = null;
//
//        while (temp!=null){
//            Node tempNext = temp.next;
//            if(step==0){
//                startK = temp;
//                step++;
//            }else if(step == k-1){
//                endK = temp;
//                Node pre = startK;
//                Node cur = startK.next;
//                if(cur==null){
//                    break;
//                }
//                Node endKNext = endK.next;
//                while (cur!=endKNext){
//                    Node curNext = cur.next;
//                    cur.next = pre;
//                    pre = cur;
//                    cur = curNext;
//                }
//
//                startKPre.next = endK;
//                startK.next = endKNext;
//
//                startKPre = startK;
//                step = 0;
//            }else{
//                step++;
//            }
//            temp = tempNext;
//        }
//    }
//
//    /**
//     * 8.逆序k个一组进行翻转
//     * 例如：给定如下链表，head-->1-->2-->3-->4-->5 逆序 k 个一组翻转后，链表变成
//     * head-->1--->3-->2-->5-->4 （k = 2 时）
//     */
//    public void reverseIterationInvertLinkedListEveryK(int k){
//        iterationInvertLinkedList();
//        iterationInvertLinkedListEveryK(k);
//        iterationInvertLinkedList();
//    }
//
//    /**
//     * 9.LeetCode 876：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//     * 如果有两个中间结点，则返回第二个中间结点。
//     */
//    public Node findMiddleNode(){
//        //快指针
//        Node fast = head.next;
//        //慢指针
//        Node slow = head.next;
//        //链表长度为奇数:fast.next==null时slow为中间结点；为偶数：fast==null时slow为中间结点
//        while (fast!=null && fast.next!=null){
//            //快指针一次走两步
//            fast = fast.next.next;
//            //慢指针一次走一步
//            slow = slow.next;
//        }
//        return slow;
//    }
//
//    /**
//     * 10.输入一个链表，输出该链表中的倒数第 k 个结点。比如链表为 head-->1-->2-->3-->4-->5。
//     * 求倒数第三个结点（即值为 3 的节点）
//     * @param k
//     * @return
//     */
//    public Node findKthToTail(int k) throws Exception {
//        if (k<0||k==0){
//            throw new Exception("k不能小于0");
//        }
//        Node fast = head.next;
//        Node slow = head.next;
//
//        //fast指针先往前走k-1步
//        int tempK = k-1;
//        while(tempK > 0 && fast!=null){
//            fast = fast.next;
//            tempK--;
//        }
//        //注意：边界条件，k大于链表长度
//        if (fast==null){
//            throw new Exception("K结点不存在");
//        }
//        //快慢指针一起往前走，快指针到达最后一个结点时，慢指针所指的就是倒数第k个结点
//        while(fast.next!=null){
//            fast = fast.next;
//            slow = slow.next;
//        }
//
//        return slow;
//
//    }
//
//    /**
//     * 11.todo (不熟练)给定一个单链表，设计一个算法实现链表向右旋转 K 个位置。
//     * 举例：给定 head->1->2->3->4->5->NULL, K=3,右旋后即为 head->3->4->5-->1->2->NULL
//     * @param k
//     * @return
//     */
//    public void reversedKthToTail(int k) throws Exception {
//
//        //寻找倒数第k+1个结点
//        Node kPreNode = findKthToTail(k+1);
//        //倒数第k个结点
//        Node kNode = kPreNode.next;
//        //第一个结点
//        Node headNext = head.next;
//        //倒数第k+1个结点的下一个结点设为null
//        kPreNode.next = null;
//        //倒数第k个结点设为第一个结点
//        head.next = kNode;
//        //遍历找到尾结点
//        Node temp = kNode;
//        while(temp.next != null){
//            temp = temp.next;
//        }
//        //尾结点设为第一个结点
//        temp.next = headNext;
//
//    }
//
//    /**
//     * 12.输入一个链表，删除该链表中的倒数第 k 个结点
//     * @param k
//     */
//    public void deleteKthToTail(int k) throws Exception {
//        //先找到倒数第k+1个结点
//        Node kPreNode = findKthToTail(k+1);
//        //倒数第k个结点
//        Node kNode = kPreNode.next;
//          //注意边界条件
//        if(kNode != null){
//            //倒数第k+1个结点指向倒数第k个结点的下一个结点
//            kPreNode.next = kNode.next;
//        }else{
//            //kNode为null,倒数第k+1个结点直接指向null
//            kPreNode.next = null;
//        }
//    }
//
//    /**
//     * 13.todo (不熟练)判断两个单链表是否相交及找到第一个交点,要求空间复杂度 O(1)
//     * @param list1
//     * @param list2
//     * @return
//     */
//    public static Node detectCommonNode(LinkedList list1, LinkedList list2){
//
//        //链表的长度
//        int length1 = 0;
//        int length2 = 0;
//        //指向头结点的指针
//        Node p1 = list1.head;
//        Node p2 = list2.head;
//        //遍历链表获得长度
//        while(p1.next!=null){
//            length1++;
//            p1 = p1.next;
//        }
//        while (p2.next!=null){
//            length2++;
//            p2 = p2.next;
//        }
//        //指针归到head位置
//        p1 = list1.head;
//        p2 = list2.head;
//
//        //长的链表比短的多的结点数
//        int step =Math.abs(length1-length2);
//        //长的先走多出来的结点数个步数
//        while (step>0){
//            if (length1 > length2){
//                p1 = p1.next;
//            }else {
//                p2 = p2.next;
//            }
//            step--;
//        }
//
//        //从到相交位置相同的距离后一起走，边走边比较data是否相等
//        while (p1 !=null && p2.next !=null){
//            p1 = p1.next;
//            p2 = p2.next;
//           if (p1.data == p2.data){
//               return p1;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 14.判断链表是否有环，如果有找到环的入口位置，要求空间复杂度为O(1)
//     * @return
//     */
//    public Node detectCrossNode(){
//        //注意起始条件
//        Node fast = head;
//        Node slow = head;
//          //注意判断条件
//        while (fast !=null && fast.next !=null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == null){
//                return null;
//            }
//            if(fast.data == slow.data){
//                return slow;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 15.todo 寻找环的入口
//     * @return
//     */
//    public Node getRingEntryNode() {
//        Node crossNode = detectCrossNode();
//        if(crossNode == null){
//            return null;
//        }
//
//        Node p1 = head;
//        Node p2 = crossNode;
//
//        while(p1.data != p2.data){
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return p1;
//    }
//
//    /**
//     * 16.求环的长度
//     * @return
//     */
//    public int getRingLength(){
//        int length = 0;
//        Node entryNode = getRingEntryNode();
//        Node temp = entryNode;
//        while (temp.data != entryNode.data){
//            temp = temp.next;
//            length++;
//        }
//        return length;
//    }
//
//    /**
//     * 打印链表
//     */
//    public void printLinkedList(){
//        Node temp = head.next;
//        List<Integer> nodeList = new ArrayList<>();
//        //去掉哨兵结点和空结点
//        while (temp !=null){
//            nodeList.add(temp.data);
//            temp = temp.next;
//
//        }
//        for (int i = 0;i<nodeList.size();i++){
//            if (i != nodeList.size()-1){
//                //除了最后一个元素用-->连接
//                System.out.print(nodeList.get(i)+"-->");
//            }else{
//                //输出最后一个元素
//                System.out.println(nodeList.get(i));
//            }
//
//        }
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        int[] arr = new int[]{1,2,3,4,5,6};
//        int[] arr1 = new int[]{0,3,4,5,6,7,8,9,1,2,5};
//        LinkedList linkedList = new LinkedList();
//        LinkedList linkedList1 = new LinkedList();
//        int k = 2;
//        //测试1
//        for (int i = 0; i < arr.length; i++){
//            linkedList.tailInsert(arr[i]);
//        }
//        for (int i = 0; i < arr1.length; i++){
//            linkedList1.tailInsert(arr1[i]);
//        }
//
////        //测试2
////        for (int i = 0; i < arr.length; i++){
////            linkedList.headInsert(arr[i]);
////        }
//
//        //测试3
////        Node tmp = linkedList.head;
////         while (tmp.data != 2) {
////             tmp = tmp.next;
////         }
////         linkedList.removeSelectedNode(tmp);
//
//        //测试4
////        Node newHead = linkedList.invertLinkedList(linkedList.head.next);
////        linkedList.head.next = newHead;
//
//        //测试5
////        linkedList.iterationInvertLinkedList();
//
//        //测试6
////        linkedList.iterationInvertLinkedList(2,5);
//        //测试7
////        linkedList.iterationInvertLinkedListEveryK(k);
////        //测试8
////        linkedList.reverseIterationInvertLinkedListEveryK(k);
//        //测试9
////        Node node = linkedList.findMiddleNode();
////        System.out.println("middle:"+node.data);
//        //测试10
////        Node node = linkedList.findKthToTail(3);
////        System.out.println("findKthToTail:"+node.data);
//        //测试11
////        linkedList.reversedKthToTail(3);
//        //测试12
////        linkedList.deleteKthToTail(3);
//        //测试13
//        Node node = detectCommonNode(linkedList,linkedList1);
//        System.out.println("第一个相交的结点:" + node.data);
//
//        //输出链表
////        linkedList.printLinkedList();
//
//
//    }
//
//}
//
//class Node{
//    /**
//     * 结点的值
//     */
//    int data;
//    /**
//     * 结点引用，指向下一个结点
//     */
//    Node next = null;
//    public Node(int data){
//        this.data = data;
//    }
//}
