package top.ninng.algorithm.sort;

/**
 * 冒泡排序
 * <p>
 * O(n^2) 最差时间复杂度
 * O(n^2) 最佳时间复杂度
 * O(n^2) 平均时间复杂度
 * <p>
 * O(1) 空间复杂度
 */
public class BubbleSort implements Sort {

    /**
     * 升序
     *
     * @param target
     * @return
     */
    @Override
    public int[] sort(int[] target) {
        int t;
        for (int i = 0, length = target.length; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (target[j] > target[j + 1]) {
                    t = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = t;
                }
            }
        }
        return target;
    }
}
