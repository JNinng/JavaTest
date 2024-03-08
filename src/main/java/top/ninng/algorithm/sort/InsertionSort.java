package top.ninng.algorithm.sort;

/**
 * 插入排序
 * <p>
 * O(n^2) 时间复杂度
 * <p>
 * O(1) 空间复杂度
 */
public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] target) {
        int t, j;
        for (int i = 1, length = target.length; i < length; i++) {
            t = target[i];
            for (j = i - 1; j >= 0; j--) {
                if (target[j] > t) {
                    target[j + 1] = target[j];
                } else {
                    break;
                }
            }
            target[j + 1] = t;
        }
        return target;
    }
}
