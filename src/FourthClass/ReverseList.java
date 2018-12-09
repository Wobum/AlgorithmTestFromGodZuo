package FourthClass;

public class ReverseList {
/**
 * @Auther: Wobum
 * @Date: 2018/11/25 10:18
 * @Description: 单链表和双链表的反转。
 */
    // 定义单链表
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 单链表的反转
    public static Node reverseList(Node head){
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 定义双链表
    public static class DoubleNode{
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int value){
            this.value = value;
        }
    }

    // 双链表的反转
    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode cur = head;
        DoubleNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 打印单链表
    public static void printLinkedList(Node head){
        System.out.println("Print LinkedList");
        while (head != null){
            System.out.println(head.value + " ");
            head = head.next;
        }
        System.out.println("======================");
    }

    // 打印双向链表
    public static void printDoubleLinkedList(DoubleNode head){
        System.out.println("Print DoubleLinkedList ");
        DoubleNode end = null;
        while (head != null){
            System.out.println(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.println();
        while (end != null){
            System.out.println(end.value + " ");
            end = end.pre;
        }
        System.out.println("======================");
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.pre = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.pre = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.pre = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }

}
