package SeventhClass;

/**
 * @Author : Wobum
 * @Date : 2018/12/20 19:38
 * @Software : IntelliJ IDEA
 * @Description: 前缀树
 **/
public class TrieTree {
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            root.pass++; // 先给根节点 ++
            TrieNode cur = root;
            char[] stringArr = word.toCharArray();
            for (int i = 0; i < stringArr.length; i++) {
                int index = stringArr[i] - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new TrieNode();
                }
                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        public int search(String word) {
            if (word == null)
                return 0;
            char[] arr = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (cur.nexts[index] == null)
                    return 0;
                cur = cur.nexts[index];
            }
            return cur.end;
        }

        public void delete(String word) {
            if (search(word) == 0)
                return;
            root.pass--; //如果存在肯定经过 root
            char[] arr = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (cur.nexts[index].pass == 1) {// 如果下一个节点的 pass 为 1，直接丢掉下面的节点。
                    cur.nexts[index] = null;
                    return;
                }
                cur = cur.nexts[index];
                cur.pass--; // 当前节点的 pass--
            }
            cur.end--;  // 最后一个节点的 end 需要--
        }

        public int prefixNumber(String pre){
            if (pre == null)
                return 0;
            char[] arr = pre.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < arr.length; i++){
                int index = arr[i] - 'a';
                if (cur.nexts[index] == null)
                    return 0;
                cur = cur.nexts[index];
            }
            return cur.pass;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }

}
