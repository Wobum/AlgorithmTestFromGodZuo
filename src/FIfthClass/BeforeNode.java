package FIfthClass;

public class BeforeNode {
/**
 * @Auther: Wobum
 * @Date: 2018/11/27 13:53
 * @Description: 查找一个结点的前驱结点（前驱节点是指中序遍历中该结点的上一个结点）
 */
    public static class Node{
        public int value;
        public Node parent;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node getBeforeNode(Node node){
        if(node == null){
            return null;
        }

        if (node.left != null){ // 有左子树
            return  getRightMost(node.left);
        }else { // 没左子树
            Node cur = node;
            Node parent = cur.parent;
            while (parent != null && parent.left == cur){
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
    }
    // 找左子树最右的结点
    public static Node getRightMost(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;


        Node test = head.left.left;
        System.out.println(test.value + " pre: " + getBeforeNode(test));
        test = head.left.left.right;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.left;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.right;
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " pre: " + getBeforeNode(test).value);
    }
}
