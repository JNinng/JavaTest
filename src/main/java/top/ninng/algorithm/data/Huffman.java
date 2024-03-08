package top.ninng.algorithm.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 哈夫曼编码
 */
public class Huffman {

    private String encodeString;
    /**
     * 字符编码
     */
    private Map<Character, String> encodeSchedule;

    public String decode() {
        StringBuilder decodeStr = new StringBuilder();
        while (encodeString.length() > 0) {
            for (Map.Entry<Character, String> e : encodeSchedule.entrySet()) {
                String charEncodeStr = e.getValue();
                if (encodeString.startsWith(charEncodeStr)) {
                    decodeStr.append(e.getKey());
                    encodeString = encodeString.substring(charEncodeStr.length());
                    break;
                }
            }
        }
        return decodeStr.toString();
    }

    public String encode(String s) {
        Map<Character, String> encodeMap = new HashMap<>();
        Node tree = huffmanTree(s);
        getCharacterEncoding(tree, encodeMap, new StringBuilder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String tmp = encodeMap.get(s.charAt(i));
            sb.append(tmp);
        }
        encodeString = sb.toString();
        encodeSchedule = encodeMap;
        return encodeString;
    }

    // 获取哈夫曼树中字符的编码
    private void getCharacterEncoding(Node root, Map<Character, String> res, StringBuilder path) {
        if (root.left == null && root.right == null) {
            path.append(root.i);
            res.put(root.ch, path.substring(1));
            path.deleteCharAt(path.length() - 1);
            return;
        }
        path.append(root.i);
        if (root.left != null) {
            getCharacterEncoding(root.left, res, path);
        }
        if (root.right != null) {
            getCharacterEncoding(root.right, res, path);
        }
        path.deleteCharAt(path.length() - 1);
    }

    public Map<Character, String> getEncodeSchedule() {
        return encodeSchedule;
    }

    public String getEncodeString() {
        return encodeString;
    }

    /*
     * 构建哈夫曼树
     */
    private Node huffmanTree(String target) {
        if (target == null || target.equals("")) {
            return null;
        }
        // 计算字频
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            if (charFreqMap.containsKey(c)) {
                int count = charFreqMap.get(c);
                charFreqMap.put(c, count + 1);
            } else {
                charFreqMap.put(c, 1);
            }
        }
        // 构建节点
        LinkedList<Node> nodeList = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            nodeList.add(new Node(entry.getKey(), 0, entry.getValue(), null, null));
        }
        // 节点升序
        nodeList.sort((t1, t2) -> t1.freq - t2.freq);
        if (nodeList.size() == 1) {
            // 代表字符串只包含一种类型的字母
            Node t = nodeList.get(0);
            return new Node(null, 0, nodeList.get(0).freq, t, null);
        }

        Node root = null;
        while (nodeList.size() > 0) {
            // 因为nodeList在前面已经排好序，所以直接取出前两个节点，他们的和肯定为最小
            Node left = nodeList.removeFirst();
            Node right = nodeList.removeFirst();
            left.i = 0;
            right.i = 1;
            if (nodeList.size() == 0) {
                // 节点合并完毕
                root = new Node(null, 0, left.freq + right.freq, left, right);
            } else {
                Node tmp = new Node(null, 0, left.freq + right.freq, left, right);

                // left、right 合并后，需要将得到的新节点加入到原链表中，并保持升序
                if (tmp.freq > nodeList.getLast().freq) {
                    nodeList.addLast(tmp);
                } else {
                    for (int i = 0; i < nodeList.size(); i++) {
                        int tmpFreq = tmp.freq;
                        if (tmpFreq <= nodeList.get(i).freq) {
                            nodeList.add(i, tmp);
                            break;
                        }
                    }
                }
            }
        }
        // 返回建立好的二叉树根节点
        return root;
    }

    private static class Node {

        /**
         * 字符
         */
        Character ch;
        /**
         * 索引
         */
        int i;
        /**
         * 字频
         */
        int freq;
        /**
         * 左子节点
         */
        Node left;
        /**
         * 右子节点
         */
        Node right;

        public Node(Character ch, int i, int freq, Node left, Node right) {
            this.ch = ch;
            this.i = i;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
}
