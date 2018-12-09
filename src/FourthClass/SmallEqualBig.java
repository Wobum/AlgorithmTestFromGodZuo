package FourthClass;

import javax.swing.*;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class SmallEqualBig {
/**
 * @Auther: Wobum
 * @Date: 2018/11/25 13:45
 * @Description: 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
 * 整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
 * 的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
 * 除这个要求外，对调整后的节点顺序没有更多的要求。
 */
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 时间复杂度为 O(n),空间复杂度为 O(n)
    public static Node listPartition(Node head, int pivot){
         if (head == null){
             return head;
         }

         Node cur = head;
         int i = 0;
         while (cur != null){
             i++;
             cur = cur.next;
         }

         cur = head;
         Node[] nodeArr = new Node[i];
         for (i = 0; i < nodeArr.length; i++){
             nodeArr[i] = cur;
             cur = cur.next;
         }
         partition(nodeArr, pivot);
         for(i = 1; i < nodeArr.length; i++){
             nodeArr[i - 1].next = nodeArr[i];
         }
         nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void partition(Node[] nodeArr, int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] arr, int i, int j){
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 时间复杂度为 O(n),空间复杂度为 O(1)
    public static Node listPartition2(Node head, int pivot) {
        if (head == null){
            return head;
        }

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        Node cur = head;

        while (cur != null){
            if (cur.value < pivot){
                if (sH == null){
                    sH = cur;
                    sT = cur;
                }else {
                    sT.next = cur;
                    sT = cur;
                }
            }else if (cur.value == pivot){
                if (eH == null){
                    eH = cur;
                    eT = cur;
                }else {
                    eT.next = cur;
                    eT = cur;
                }
            }else {
                if (bH == null){
                    bH = cur;
                    bT = cur;
                }else {
                    bT.next = cur;
                    bT = cur;
                }
            }

            next = cur.next;
            cur.next = null;
            cur = next;
        }

        if (sT != null){ // 一定有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT; // 谁去连大于区域的头
        }


        if (eT != null){ // 有一个结点去连大于区域的头部，
            eT.next = bH;
        }

        return sH != null ? sH : (eH != null ? eH : bH);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        //head1 = listPartition(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }

}
