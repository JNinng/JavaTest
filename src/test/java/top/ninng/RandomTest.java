package top.ninng;

import org.junit.Test;
import top.ninng.algorithm.data.Random;

/**
 * @Author OhmLaw
 * @Date 2024/2/26 15:59
 * @Version 1.0
 */
public class RandomTest {

    @Test
    public void random() {
        int w1 = 20, w2 = 30, w3 = 50;
        int[] weight = new int[]{w1, w2, w3};
        Random random = new Random(weight);

        int a = 0, b = 0, c = 0, k = 1000, sum = 90000;
        double[] sa = new double[weight.length], sb = new double[weight.length];
        long start = 0, end = 0, time = 0;
        for (int ii = 0; ii < sum; ii++) {
            for (int i = 0; i < k; i++) {
                start = System.currentTimeMillis();
                int pro = weight[random.weightFilter()];
                end = System.currentTimeMillis();
                time += end - start;
                if (pro == w1) {
                    a += 1;
                    continue;
                }
                if (pro == w2) {
                    b += 1;
                    continue;
                }
                if (pro == w3) {
                    c += 1;
                    continue;
                }
            }
            sa[0] += a / (k * 1.0);
            sa[1] += b / (k * 1.0);
            sa[2] += c / (k * 1.0);
            a = 0;
            b = 0;
            c = 0;
        }
        System.out.println("20% 实际：" + sa[0] / sum);
        System.out.println("30% 实际：" + sa[1] / sum);
        System.out.println("50% 实际：" + sa[2] / sum);
        System.out.println(time);

        System.out.println("====");

        time = 0;
        for (int ii = 0; ii < sum; ii++) {
            for (int i = 0; i < k; i++) {
                start = System.currentTimeMillis();
                int pro = weight[random.weightRandom()];
                end = System.currentTimeMillis();
                time += end - start;
                if (pro == w1) {
                    a += 1;
                    continue;
                }
                if (pro == w2) {
                    b += 1;
                    continue;
                }
                if (pro == w3) {
                    c += 1;
                    continue;
                }
            }
            sb[0] += a / (k * 1.0);
            sb[1] += b / (k * 1.0);
            sb[2] += c / (k * 1.0);
            a = 0;
            b = 0;
            c = 0;
        }
        System.out.println("20% 实际：" + sb[0] / sum);
        System.out.println("30% 实际：" + sb[1] / sum);
        System.out.println("50% 实际：" + sb[2] / sum);
        System.out.println(time);
    }
}
