package com.dhn.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 构建链表
 * @author: Dong HuaNan
 * @date: 2020/3/3 10:45
 */
public class LinkedList {

    /**
     * 哨兵结点
     */
    Node head = new Node(0);

    /**
     * 1.从尾结点开始添加结点
     * @param val
     */
    public void tailInsert(int val){
        Node temp = head;
        //当前结点的下一个结点不为null，则再检查下一个结点
        while (temp.next!=null){
            temp = temp.next;
        }
        //为空则新建结点，填入数据
        temp.next = new Node(val);
    }

    /**
     * 2.给定数组 1，2，3，4 构造如下链表 head-->4---->3---->2---->1
     * 从头结点插入
     * @param val
     */
    public void headInsert(int val){
        //从头结点开始
        Node temp = head;
        //新结点
        Node newNode = new Node(val);
        //新节点的指针指向头结点的下一个结点
        newNode.next = temp.next;
        //头结点指针指向新结点
        temp.next = newNode;

    }

    /**
     * 3.给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 内删除这个节点
     * @param deleteNode
     */
    public void removeSelectedNode(Node deleteNode){
        //给定结点是尾结点，遍历寻找它的前继结点，再删除它
        if (deleteNode.next == null) {
            Node temp = head;
            while(temp.next != deleteNode){
                temp = temp.next;
            }
            //删除该结点
            temp.next = null;
        }else{
            //找到给定结点的下一个结点
            Node nextNode = deleteNode.next;
            //下一个结点的值赋给给定结点
            deleteNode.data = nextNode.data;
            //下下个结点的值赋给给定结点
            deleteNode.next = nextNode.next;
            //删除下下个结点
            nextNode.next = null;
        }
    }

    /**
     * 4.地递归翻转链表
     * @param node
     * @return
     */
    public Node invertLinkedList(Node node){
        if (node.next == null){
            return node;
        }
        Node newNode = invertLinkedList(node.next);
        node.next.next = node;
        node.next = null;

        return newNode;
    }

    /**
     * 5.迭代翻转链表
     */
    public void iterationInvertLinkedList() {
        Node pre = head.next;
        Node cur = pre.next;
        pre.next = null;
        while (cur!=null){
            Node curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        head.next = pre;
    }

    /**
     * 打印链表
     */
    public void printLinkedList(){
        Node temp = head.next;
        List<Integer> nodeList = new ArrayList<>();
        //去掉哨兵结点和空结点
        while (temp !=null){
            nodeList.add(temp.data);
            temp = temp.next;

        }
        for (int i = 0;i<nodeList.size();i++){
            if (i != nodeList.size()-1){
                //除了最后一个元素用-->连接
                System.out.print(nodeList.get(i)+"-->");
            }else{
                //输出最后一个元素
                System.out.println(nodeList.get(i));
            }

        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        LinkedList linkedList = new LinkedList();

        //测试1
        for (int i = 0; i < arr.length; i++){
            linkedList.tailInsert(arr[i]);
        }

//        //测试2
//        for (int i = 0; i < arr.length; i++){
//            linkedList.headInsert(arr[i]);
//        }

        //测试3
//        Node tmp = linkedList.head;
//         while (tmp.data != 2) {
//             tmp = tmp.next;
//         }
//         linkedList.removeSelectedNode(tmp);

        //测试4
//        Node newHead = linkedList.invertLinkedList(linkedList.head.next);
//        linkedList.head.next = newHead;

        //测试5
        linkedList.iterationInvertLinkedList();








         linkedList.printLinkedList();


    }

}

class Node{
    /**
     * 结点的值
     */
    int data;
    /**
     * 结点引用，指向下一个结点
     */
    Node next = null;
    public Node(int data){
        this.data = data;
    }
}
