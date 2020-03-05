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
     * 4.递归翻转链表
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
     * 6.给定一个链表的头结点 head,以及两个整数 from 和 to ,在链表上把第 from 个节点和第 to 个节点这一部分进行翻转。
     * 例如：给定如下链表，from = 2, to = 4 head-->5-->4-->3-->2-->1 将其翻转后，链表变成 head-->5--->2-->3-->4-->1
     * @param fromIndex
     * @param toIndex
     */
    public void iterationInvertLinkedList(int fromIndex,int toIndex) throws Exception {

        // from结点
        Node fromNode = null;
        //from-1结点
        Node preFromNode = null;
        //to结点
        Node toNode = null;
        //to+1结点
        Node nextToNode = null;


        Node temp = head.next;
        //头结点index为1
        int index = 1;

        while(temp!=null){
            if(index == fromIndex-1){
                preFromNode = temp;
            }else if (index == fromIndex){
                fromNode = temp;
            }else if (index == toIndex){
                toNode = temp;
            }else if(index == toIndex+1){
                nextToNode = temp;
            }

            temp = temp.next;
            index++;
        }

        if (fromNode==null||toNode==null){
            throw new Exception("无法翻转");
        }

        Node pre = fromNode;
        Node cur = pre.next;

        while (cur!=nextToNode){
            Node curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }

        if(fromNode!=null) {
            preFromNode.next = toNode;
        }else {
            head.next = toNode;
        }

        fromNode.next = nextToNode;

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
    public void iterationInvertLinkedListEveryK(int k){

        Node temp = head.next;
        int step = 0;

        Node startKPre = head;
        Node startK = null;
        Node endK = null;

        while (temp!=null){
            Node tempNext = temp.next;
            if(step==0){
                startK = temp;
                step++;
            }else if(step == k-1){
                endK = temp;
                Node pre = startK;
                Node cur = startK.next;
                if(cur==null){
                    break;
                }
                Node endKNext = endK.next;
                while (cur!=endKNext){
                    Node curNext = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = curNext;
                }

                startKPre.next = endK;
                startK.next = endKNext;

                startKPre = startK;
                step = 0;
            }else{
                step++;
            }
            temp = tempNext;
        }
    }

    /**
     * 逆序k个一组进行翻转
     * 例如：给定如下链表，head-->1-->2-->3-->4-->5 逆序 k 个一组翻转后，链表变成
     * head-->1--->3-->2-->5-->4 （k = 2 时）
     */
    public void reverseIterationInvertLinkedListEveryK(int k){
        iterationInvertLinkedList();
        iterationInvertLinkedListEveryK(k);
        iterationInvertLinkedList();
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


    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,4,5,6};
        LinkedList linkedList = new LinkedList();
        int k = 2;
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
//        linkedList.iterationInvertLinkedList();

        //测试6
//        linkedList.iterationInvertLinkedList(2,5);
        //测试7
//        linkedList.iterationInvertLinkedListEveryK(k);
        //测试八
        linkedList.reverseIterationInvertLinkedListEveryK(k);
        //输出链表
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
