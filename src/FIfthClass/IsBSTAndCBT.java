package FIfthClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {
/**
 * @Auther: Wobum
 * @Date: 2018/11/29 10:41
 * @Description: 判断一棵树是否是搜索二叉树，判断一颗数是否是完全二叉树
 */
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    // 判断是否是搜索二叉树

    public static boolean isBST(Node head){
        if (head == null){
            return true;
        }
        Stack<Node> s = new Stack<>();
        Node cur = head;
        Node pre = null;
        while (cur != null || !s.isEmpty()){
            if (cur != null){
                s.push(cur);
                cur = cur.left;
            }else {
                cur = s.pop();
                if (pre != null && cur.value < pre.value){
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return  true;
    }

    //判断是否是完全二叉树
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Node cur = head;
        boolean leaf = false; // 表示有没有到第一个叶子节点
        queue.offer(cur);
        while (!queue.isEmpty()){
            cur = queue.poll();
            Node L = cur.left;
            Node R = cur.right;
            if (
                    (R != null && L == null)  // 左节点为空，右结点不为空 返回 fasle
                    ||
                    (leaf && (L != null || R != null)) // 到了第一个叶子节点后，之后的结点不为叶子节点 返回fasle
            )
            {
                return false;
            }
            if(L == null || R == null){ // 到了第一个叶子节点
                leaf = true;
            }

            if (L != null){
                queue.offer(L);
            }
            if (R != null){
                queue.offer(R);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        System.out.println(isBST(head));
        System.out.println(isCBT(head));
    }
}
