package top.ninng;

import org.junit.Test;
import top.ninng.algorithm.data.Huffman;

public class CodeTest {

    @Test
    public void huffmanTest() {
        String s = "huffman 测试";
        Huffman huffman = new Huffman();
        System.out.println("\t原码：" + s);
        System.out.println("\t编码：" + huffman.encode(s));
        System.out.println("字符编码表：" + huffman.getEncodeSchedule());
        System.out.println("\t解码：" + huffman.decode());
    }
}
