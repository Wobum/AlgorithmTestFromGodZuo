package FIfthClass;

public class SuccessorNode {
/**
 * @Auther: Wobum
 * @Date: 2018/11/27 13:25
 * @Description: 查找一个结点的后继结点（后继节点是指中序遍历中该结点的下一个结点）
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

    // 查找该节点的后继节点,返回一个结点或者 null
    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }
        if (node.right != null){ // 如果有右子树，查找右字数的最左结点。
            return getLeftMost(node.right);
        }else { //没有右子树，一路向上直到找到父亲结点不是右结点的那个结点即可。
            Node cur = node;
            Node parent = cur.parent;
            while (parent != null && parent.right == cur){ // 如果 parent 的右结点是 cur，就一路向上，否则就跳出，parent != null 条件使用判断最后一个结点的后继节点的。
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
    }

    // 查找右子树最左的结点
    public static Node getLeftMost(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
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

        printTree(head);

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }
}
