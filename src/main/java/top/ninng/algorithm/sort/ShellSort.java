package top.ninng.algorithm.sort;

/**
 * 希尔排序
 * <p>
 * O(1) 空间复杂度
 */
public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] target) {
        int length = target.length, gap = 1, t, j;
        while (gap < length / 7) {
            gap = gap * 7 + 1;
        }
        for (; gap >= 1; gap /= 7) {
            for (int i = gap; i < length; i++) {
                t = target[i];
                for (j = i - gap; j >= 0 && target[j] > t; j -= gap) {
                    target[j + gap] = target[j];
                }
                target[j + gap] = t;
            }
        }
        return target;
    }
}
