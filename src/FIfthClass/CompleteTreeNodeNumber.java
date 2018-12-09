package FIfthClass;

public class CompleteTreeNodeNumber {
/**
 * @Auther: Wobum
 * @Date: 2018/11/29 11:42
 * @Description: 计算一个完全二叉树的节点个数
 */
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return getNum(head, 1, mostLeftLevel(head , 1));
    }

    /* @param: cur 当前节点
               l   当前节点所在的层数
               h   表示整棵树的深度
       @return: 节点个数
    */
    public static int getNum(Node cur, int l, int h){
        if (l == h){ // Base case
            return  1;
        }
        /*
            如果当前节点的右子树的最左结点所在层数为最后一层，左子树为满二叉树
            否则，右子树为满二叉树
         */
        if (mostLeftLevel(cur.right, l + 1) == h){
            int leftTreeNum = 1 << (h - l);
            int rightTreeNum = getNum(cur.right, l+1, h);
            return leftTreeNum + rightTreeNum;
        }else {
            int rightTreeNum = 1 << (h - l - 1);
            int leftTreeNum = getNum(cur.left, l+1,h);
            return leftTreeNum + rightTreeNum;
        }
    }

    /*
        @param : node 当前节点
                 level 当前节点所在层数
        @return 当前节点所在树最左结点的层数
     */
    public static int mostLeftLevel(Node node, int level){
        while (node != null){
            level ++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
