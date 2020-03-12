package com.dhn.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 二次练习
 * @author: Dong HuaNan
 * @date: 2020/3/7 19:18
 */
public class LinkedListDemo {

    /**
     * 链表长度
     */
    int length = 0;
    /**
     * 哨兵结点
     */
    Node head = new Node(0);

    /**
     * 1.从尾结点开始添加结点
     *
     * @param val
     */
    public void tailInsert(int val) {
        //注意：指针从头结点开始
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    /**
     * 2.给定数组 1，2，3，4 构造如下链表 head-->4---->3---->2---->1
     * 从头结点插入
     *
     * @param val
     */
    public void headInsert(int val) {
        Node headAddNode = new Node(val);

        headAddNode.next = head.next;
        head.next = headAddNode;
    }

    /**
     * 3.给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 内删除这个节点
     *
     * @param deleteNode
     */
    public void removeSelectedNode(Node deleteNode) {
        if (deleteNode.next == null) {
            Node temp = head.next;
            while (temp.next != deleteNode) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            //找出要删除结点的后继结点
            Node newNode = deleteNode.next;
            //把后继结点的值赋给要删除的节点
            deleteNode.data = newNode.data;
            //给定结点指向下下个结点
            deleteNode.next = newNode.next;
        }
    }

    /**
     * 4.递归翻转链表
     *
     * @param node
     * @return
     */
    public Node invertLinkedList(Node node) {

        if (node.next==null){
            return node;
        }

        Node newHead = invertLinkedList(node.next);

        node = node.next;
        node.next = null;

        return null;
    }

    /**
     * 5.迭代翻转链表
     */
    public void iterationInvertLinkedList() {

        Node pre = head.next;
        Node cur = pre.next;
        pre.next = null;

        while (cur != null) {
            Node curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }

        head.next = pre;


    }

    /**
     * 6.给定一个链表的头结点 head,以及两个整数 from 和 to ,在链表上把第 from 个节点和第 to 个节点这一部分进行翻转。
     * 例如：给定如下链表，from = 2, to = 4 head-->5-->4-->3-->2-->1 将其翻转后，链表变成 head-->5--->2-->3-->4-->1
     *
     * @param fromIndex
     * @param toIndex
     */
    public void iterationInvertLinkedList(int fromIndex, int toIndex) throws Exception {

        Node from = null;
        Node to = null;
        Node preFrom = null;
        Node nextTo = null;

        int index = 1;
        Node temp = head.next;
        while (temp != null) {
            if (index == fromIndex - 1) {
                preFrom = temp;
            } else if (index == fromIndex) {
                from = temp;
            } else if (index == toIndex) {
                to = temp;
            } else if (index == toIndex + 1) {
                nextTo = temp;
            }
            temp = temp.next;
            index++;
        }

        if (from == null || to == null) {
            throw new Exception("无法翻转");
        }

        Node pre = from;
        Node cur = pre.next;
        while (cur != nextTo) {
            Node curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }

        if (from != null) {
            preFrom.next = to;
        } else {
            head.next = to;
        }
        from.next = nextTo;
    }

    /**
     * 7.给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
     * 示例 : 给定这个链表：head-->1->2->3->4->5 当 k = 2 时，应当返回: head-->2->1->4->3->5
     * 当 k = 3 时，应当返回: head-->3->2->1->4->5
     * 说明 :
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    public void iterationInvertLinkedListEveryK(int k) throws Exception {
        Node startKPre = head;
        Node starK = null;
        Node endK;
        int step = 0;
        Node tmp = head.next;
        while (tmp!=null){
            Node tmpNext = tmp.next;
            if (step == 0){
                starK = tmp;
                step++;
            }else if(step==k-1){
                endK = tmp;
                Node pre = starK;
                Node cur = starK.next;
                if (cur == null){
                    break;
                }
                Node endKNext = endK.next;
                while (cur != endKNext){
                    Node curNext = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = curNext;
                }
                startKPre.next = endK;
                starK.next = endKNext;

                startKPre = starK;
                step = 0;
            }else {
               step++;
            }
            tmp = tmpNext;
        }
    }
    /**
     * 9.LeetCode 876：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public Node findMiddleNode(){

        Node fast = head.next;
        Node slow = head.next;

        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    /**
     * 10.输入一个链表，输出该链表中的倒数第 k 个结点。比如链表为 head-->1-->2-->3-->4-->5。
     * 求倒数第三个结点（即值为 3 的节点）
     * @param k
     * @return
     */
    public Node findKthToTail(int k) throws Exception {
        Node fast = head.next;
        Node slow = head.next;
        int step = k-1;

        while (step>0 && fast != null){
            fast = fast.next;
            step--;
        }

        //k大于链表长度
        if (fast==null){
            throw new Exception("K结点不存在");
        }

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 11.给定一个单链表，设计一个算法实现链表向右旋转 K 个位置。
     * 举例：给定 head->1->2->3->4->5->NULL, K=3,右旋后即为 head->3->4->5-->1->2->NULL
     * @param k
     * @return
     */
    public void reversedKthToTail(int k) throws Exception {

        Node kPreNode = findKthToTail(k+1);
        Node kNode = kPreNode.next;
        Node headNext = head.next;
        kPreNode.next = null;
        head.next = kNode;

        Node tmp = kNode;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = headNext;

    }

    /**
     * 12.输入一个链表，删除该链表中的倒数第 k 个结点
     * @param k
     */
    public void deleteKthToTail(int k) throws Exception {

        Node kPreNode = findKthToTail(k+1);
        Node kNode = kPreNode.next;
        if (kNode != null){
            kPreNode.next = kNode.next;
        }else {
            kPreNode.next = null;
        }
    }

    /**
     * 13.判断两个单链表是否相交及找到第一个交点,要求空间复杂度 O(1)
     * @param list1
     * @param list2
     * @return
     */
    public static Node detectCommonNode(LinkedListDemo list1, LinkedListDemo list2){
        int length1 = 0;
        int length2 = 0;
        Node p1 = list1.head;
        Node p2 = list2.head;
        while (p1.next != null){
            length1++;
            p1 = p1.next;

        }
        while (p2.next != null){
            length2++;
            p2 = p2.next;

        }

        p1 = list1.head;
        p2 = list2.head;

        int step = Math.abs(length1-length2);
        while(step>0){
            if (length1>length2){
                p1 = p1.next;
            }else {
                p2 = p2.next;
            }
            step--;
        }

        while (p1 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
            if (p1.data == p2.data){
                return p1;
            }

        }
        return null;
    }

    /**
     * 14.判断链表是否有环，如果有找到环的入口位置，要求空间复杂度为O(1)
     * @return
     */
    public Node detectCrossNode(){
        Node fast = head;
        Node slow = head;

        while (fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == null){
                return null;
            }
            if (fast.data == slow.data){
                return slow;
            }
        }
        return null;
    }

    /**
     * 15.寻找环的入口
     * @return
     */
    public Node getRingEntryNode() {
        //相遇
        Node crossNode = detectCrossNode();
        Node p1 = crossNode;
        Node p2 = head;
        if (p1 == null){
            return null;
        }

        while(p1.data != p2.data){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }



        /**
         * 打印链表
         */
    public void printLinkedList() {
        Node temp = head.next;
        List<Integer> nodeList = new ArrayList<>();
        //去掉哨兵结点和空结点
        while (temp != null) {
            nodeList.add(temp.data);
            temp = temp.next;

        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (i != nodeList.size() - 1) {
                //除了最后一个元素用-->连接
                System.out.print(nodeList.get(i) + "-->");
            } else {
                //输出最后一个元素
                System.out.println(nodeList.get(i));
            }

        }
    }


    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//        int[] arr1 = new int[]{0,7, 4, 5, 6};
        int[] arr1 = new int[]{0, 3, 4, 5, 6, 7, 8, 9, 1, 2, 5};
        LinkedListDemo linkedList = new LinkedListDemo();
        LinkedListDemo linkedList1 = new LinkedListDemo();
        int k = 2;
        //测试1
        for (int i = 0; i < arr.length; i++) {
            linkedList.tailInsert(arr[i]);
        }
        for (int i = 0; i < arr1.length; i++) {
            linkedList1.tailInsert(arr1[i]);
        }

//        //测试2
//        for (int i = 0; i < arr.length; i++){
//            linkedList.headInsert(arr[i]);
//        }

        //测试3
//        Node tmp = linkedList.head;
//         while (tmp.data != 4) {
//             tmp = tmp.next;
//         }
//         linkedList.removeSelectedNode(tmp);

        //测试4
//        Node newHead = linkedList.invertLinkedList(linkedList.head.next);
//        linkedList.head.next = newHead;

        //测试5
//        linkedList.iterationInvertLinkedList();

        //测试6
//        linkedList.iterationInvertLinkedList(2, 4);
        //测试7
//        linkedList.iterationInvertLinkedListEveryK(k);
//        //测试8
//        linkedList.reverseIterationInvertLinkedListEveryK(k);
        //测试9
//        Node node = linkedList.findMiddleNode();
//        System.out.println("middle:"+node.data);
        //测试10
//        Node node = linkedList.findKthToTail(2);
//        System.out.println("findKthToTail:"+node.data);
        //测试11
//        linkedList.reversedKthToTail(3);
        //测试12
//        linkedList.deleteKthToTail(0);
        //测试13
//        Node node = detectCommonNode(linkedList,linkedList1);
//        System.out.println("第一个相交的结点:" + node.data);

        Node node = linkedList1.getRingEntryNode();
        System.out.println(node.data);

        //输出链表
        linkedList.printLinkedList();


    }
}

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }


}