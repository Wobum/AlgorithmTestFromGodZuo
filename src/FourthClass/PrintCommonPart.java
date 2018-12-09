package FourthClass;

import javax.crypto.interfaces.PBEKey;

public class PrintCommonPart {
/**
 * @Auther: Wobum
 * @Date: 2018/11/25 10:45
 * @Description: 打印两个单链表的公共部分，即值相等的部分
 */
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void printCommonPart(Node head1, Node head2){
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                //System.out.println(head1.value + " ");
                head1 = head1.next;
            }else if (head1.value > head2.value){
                //System.out.println(head2.value + " ");
                head2 = head2.next;
            }else {
                System.out.println(head1.value + " ");
                //System.out.println(head2.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        /*while (head1 != null){
            System.out.println(head1.value + "");
            head1 = head1.next;
        }

        while (head2 != null){
            System.out.println(head2.value + "");
            head2 = head2.next;
        }*/
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

    public static void main(String[] args) {
       Node head1 = new Node(1);
       head1.next = new Node(2);
       head1.next.next = new Node(6);
       head1.next.next.next = new Node(10);

       Node head2 = new Node(1);
       head2.next = new Node(6);
       head2.next.next = new Node( 8);
       head2.next.next.next = new Node(10);

       printLinkedList(head1);
       printLinkedList(head2);
       printCommonPart(head1, head2);
    }
}
