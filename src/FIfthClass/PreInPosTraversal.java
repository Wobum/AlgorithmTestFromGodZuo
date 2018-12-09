package FIfthClass;

import java.util.Stack;

public class PreInPosTraversal {
/**
 * @Auther: Wobum
 * @Date: 2018/11/27 10:20
 * @Description: 二叉树的前中后序遍历
 */
    public static class Node{
        public  int value;
        public  Node left;
        public  Node right;

        public Node(int value){
            this.value = value;
        }
    }

    // 前序遍历，递归形式，通过递归序进行打印
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    // 中序遍历，递归形式
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    // 后序遍历，递归形式
    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    // 前序遍历，非递归形式，先在栈中压入头结点，如果栈不为空，弹出节点并打印，然后先压入弹出结点的右结点，在压入左结点，继续循环。
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if (head == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        Node cur = head;
        s.push(cur);
        while (!s.isEmpty()){
            cur = s.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null){
                s.push(cur.right);
            }
            if(cur.left != null){
                s.push(cur.left);
            }
        }
    }

    // 中序遍历，非递归形式，如果当前节点不为空，压入栈中，当前节点左移，当前节点为空，弹出节点并打印，当前节点等于弹出节点的右节点
    public static void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if (head == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        Node cur = head;
        while (!s.isEmpty() || cur != null){
            if (cur != null){
                s.push(cur);
                cur = cur.left;
            }else {
                cur = s.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }

    }

    // 后序遍历，非递归形式，修改前序遍历为中右左，然后通过栈使其变为左右中。
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-order:");
        if (head != null){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node cur = head;
        s1.push(cur);
        while (!s1.isEmpty()){
            cur = s1.pop();
            s2.push(cur);
            if (cur.left != null){
                s1.push(cur.left);
            }
            if (cur.right != null){
                s1.push(cur.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.print(s2.pop().value + " ");
        }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        System.out.println();
        inOrderUnRecur(head);
        System.out.println();
        posOrderUnRecur(head);

    }
}
