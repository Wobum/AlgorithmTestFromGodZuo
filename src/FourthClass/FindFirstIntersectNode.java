package FourthClass;

import javax.sound.midi.Soundbank;
import java.util.Currency;
import java.util.HashSet;

public class FindFirstIntersectNode {
/**
 * @Auther: Wobum
 * @Date: 2018/11/26 15:54
 * @Description: 两个链表可能有环，可能无环，判断两个链表是否相交，如果相交，返回第一个相交的结点，如果不相交，返回 null
 */
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //如果有环，返回第一个入环结点，如果没有，返回 null
    public static Node getLoopNode1(Node head){
        Node cur = head;
        HashSet<Node> set1 = new HashSet<>();
        while (cur != null){
            if (set1.contains(cur)){
                return cur;
            }else {
                set1.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    public static Node getLoopNode2(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }// 先判断链表是否有两个以上的结点。

        Node slow = head.next;
        Node fast = head.next.next;

       while (slow != fast){
           if (fast.next == null || fast.next.next == null){
               return null; // 表示无环。
           }
           slow = slow.next;
           fast = fast.next.next;
       }

       fast = head;
       while (slow != fast){
           slow = slow.next;
           fast = fast.next;
       }
       return slow;
    }
    // 两个都没有环，
    public static Node noLoop(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return  null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int len1 = 1;
        int len2 = 1;

        while (cur1.next != null){
            len1 ++;
            cur1 = cur1.next;
        }

        while (cur2.next != null){
            len2 ++;
            cur2 = cur2.next;
        }

        if (cur1 != cur2){
            return null; // 最后一个结点都不相等，表示不相交
        }

        int n = Math.abs(len2 - len1);
        cur1 = len2 > len1 ? head2 : head1; // cur1 指向长链表
        cur2 = len2 > len1 ? head1 : head2; // cur2 指向短链表

        while (n != 0){
            cur1 = cur1.next;
            n --;
        } // 长链表先走 n 步。

        // 当 cur1 = cur2 时，即为相交点。
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return  cur1;
    }

    // 两个有环的情况下
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        // 入环点相同，那就可以不管环，蜕变为无环情况
        if (loop1 == loop2){
            Node cur1 = head1;
            Node cur2 = head2;
            int len1 = 0;
            int len2 = 0;

            while (cur1 != loop1){
                len1 ++;
                cur1 = cur1.next;
            }

            while (cur2 != loop2){
                len2 ++;
                cur2 = cur2.next;
            }

            int n = Math.abs(len2 - len1);
            cur1 = len2 > len1 ? head2 : head1; // cur1 指向长链表
            cur2 = len2 > len1 ? head1 : head2; // cur2 指向短链表

            while (n != 0){
                cur1 = cur1.next;
                n --;
            } // 长链表先走 n 步。

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return  cur1;
        }else{ // loop1 != loop2
            Node cur = loop1.next;
            while (cur != loop1){ // 让 loop1 绕自己的环一周，看有没有 loop2 ，如果有，任意返回一个 loop1 或 loop2 ，如果没有，则没有交点
                if (cur == loop2){
                    return loop1;
                }
                cur = cur.next;
            }
        }
        return null;
    }

    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }

        Node loop1 = getLoopNode1(head1);
        Node loop2 = getLoopNode2(head2);

        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value); // 返回 2

        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value); // 返回 4


    }
}
