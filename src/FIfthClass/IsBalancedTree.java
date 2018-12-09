package FIfthClass;

public class IsBalancedTree {
    /**
     * @Auther: Wobum
     * @Date: 2018/11/29 10:05
     * @Description: 判断一棵树是否为平衡二叉树
     */
    public static class ReturnData {
        public int height;
        public boolean isBalance;

        public ReturnData(int h, boolean isB) {
            this.height = h;
            this.isBalance = isB;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalance(Node head) {
        return returnDateProcess(head).isBalance;
    }


    public static ReturnData returnDateProcess(Node head) {
        if (head == null) { // Base case
            return new ReturnData(0, true);
        }
        ReturnData leftData = returnDateProcess(head.left); //返回左子树是否是平衡的，以及左子树的高度
        ReturnData rightData = returnDateProcess(head.right); // 返回右子树是否是平衡的，以及右子树的高度
        boolean isBalance = true;
        if (!leftData.isBalance || !rightData.isBalance) {
            isBalance = false;
        }
        if (Math.abs(leftData.height - rightData.height) > 1) {
            isBalance = false;
        }
        int height = Math.max(leftData.height, rightData.height) + 1;
        return new ReturnData(height, isBalance); // 返回该节点所在结点是否是平衡的，以及该节点的高度。
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));
    }
}
