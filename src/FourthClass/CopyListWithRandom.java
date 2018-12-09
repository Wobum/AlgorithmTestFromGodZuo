package FourthClass;

import java.util.HashMap;

public class CopyListWithRandom {
/**
 * @Auther: Wobum
 * @Date: 2018/11/26 14:35
 * @Description: 复制一个链表，原链表有每个结点有两个指针，next 和 rand 。
 */
    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node copyListWithRand1(Node head){
        HashMap<Node, Node> map1 = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map1.put(cur, new Node(cur.value)); //创建一个哈希表，key 值为原始链表中的结点，value 值为 copy 链表中的结点
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map1.get(cur).next = map1.get(cur.next); //copy 链表中的结点的 next 指针指向原链表中该节点的 next 指针指向的 copy 结点。
            map1.get(cur).rand = map1.get(cur.rand); //同理。
            cur = cur.next;
        }
        return map1.get(head); // System.out.println(map1.get(null)) 结果返回 null,所以不用判断 head 指针为 null
    }

    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }

        Node cur = head;
        Node next = null;
        // 让每一个结点后面都是它的 copy 结点
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value); // copy 结点
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        // 设置 cur 的 rand 指针
        while (cur != null){
            cur.next.rand = cur.rand == null ? null : cur.rand.next; // cur 的 copy 指针指向 cur 的 rand 指针结点的 copy 结点,cur.rand 结点有可能为 null，没有 next 指针
            cur = cur.next.next;
        }

        cur = head;
        Node res = head.next;
        //分离原链表
        while (cur != null){
            next = cur.next.next; // next 指针存放原链表的下一个结点
            cur.next.next = next != null ?next.next : null; // 设置 copy 结点的 next 指针
            cur.next = next; // 设置原链表的 next 指针。
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
