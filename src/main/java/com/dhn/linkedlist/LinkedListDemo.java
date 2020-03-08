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
      * @param node
      * @return
      */
    public Node invertLinkedList(Node node){

        return null;
    }

    /**
      * 5.迭代翻转链表
     */
    public void iterationInvertLinkedList(){

        Node pre = head.next;
        Node cur = pre.next;
        pre.next = null;

        while (cur !=null){
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
     * @param fromIndex
     * @param toIndex
     */
    public void iterationInvertLinkedList(int fromIndex,int toIndex){

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
        int[] arr1 = new int[]{0, 3, 4, 5, 6, 7, 8, 9, 1, 2, 5};
        LinkedListDemo linkedList = new LinkedListDemo();
//        LinkedListDemo linkedList1 = new LinkedListDemo();
        int k = 2;
        //测试1
        for (int i = 0; i < arr.length; i++) {
            linkedList.tailInsert(arr[i]);
        }
//        for (int i = 0; i < arr1.length; i++) {
////            linkedList1.tailInsert(arr1[i]);
//        }

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
        linkedList.iterationInvertLinkedList(2,5);
        //测试7
//        linkedList.iterationInvertLinkedListEveryK(k);
//        //测试8
//        linkedList.reverseIterationInvertLinkedListEveryK(k);
        //测试9
//        Node node = linkedList.findMiddleNode();
//        System.out.println("middle:"+node.data);
        //测试10
//        Node node = linkedList.findKthToTail(3);
//        System.out.println("findKthToTail:"+node.data);
        //测试11
//        linkedList.reversedKthToTail(3);
        //测试12
//        linkedList.deleteKthToTail(3);
        //测试13
//        Node node = detectCommonNode(linkedList,linkedList1);
//        System.out.println("第一个相交的结点:" + node.data);

        //输出链表
        linkedList.printLinkedList();


    }
}

class Node{
    int data;
    Node next = null;
    public Node(int data){
        this.data = data;
    }


}