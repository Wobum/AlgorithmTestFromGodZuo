package FourthClass;

import java.util.Stack;
import java.util.TreeMap;

public class IsPalindromeList {
/**
 * @Auther: Wobum
 * @Date: 2018/11/25 11:01
 * @Description: 判断一个链表是否是回文结构
 */
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 判断是不是回文结构的第一种方法。
    public static boolean isPalindrome1(Node head){
        if (head == null || head.next == null){
            return  true;
        }

        Stack<Node> s = new Stack<>();
        Node cur = head;
        while (cur != null){
            s.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.value != s.pop().value){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Stack<Node> s = new Stack<>();
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;

        while (slow != null){
            s.push(slow);
            slow = slow.next;
        }

        while (!s.isEmpty()){
            if (s.pop().value != head.value){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // 反转链表
    public static Node reverseList(Node head){
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node node1 = slow.next; // node1 指向右边链表的第一个元素
        slow.next = null; // 左边链表的最后一个元素指向 null

        node1 = reverseList(node1); // 反转右边链表,返回头节点，此时 node1 为原链表的最后给一个元素。

        boolean res = true;
        Node node2 = node1; // 需要一个变量保存这个结点。
        while (node1 != null){
            // 右边链表的结点数量要么比左边链表小 1，要么两个相等。
            if (node1.value != head.value){
                res = false; // 不能直接返回，因为后续还需要反转链表。
                break;
            }
            node1 = node1.next;
            head = head.next;
        }

        node1 = reverseList(node2); //再次反转右边链表
        slow.next = node1;

        return res;
    }

    // 打印单链表
    public static void printLinkedList(Node head){
        System.out.println("Print LinkedList");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
