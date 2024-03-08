package top.ninng.algorithm.sort;

/**
 * 堆排序
 */
public class HeapSort implements Sort {

    @Override
    public int[] sort(int[] target) {
        int length = target.length - 1;
        // 最后一个非叶子节点开始最大堆化，根节点最大
        for (int i = (length - 1) >> 1; i >= 0; i--) {
            heapify(i, length, target);
        }
        // 开始排序
        for (int i = length; i > 0; i--) {
            swap(0, i, target);
            heapify(0, i - 1, target);
        }
        return new int[0];
    }

    /**
     * 最大堆化，保持节点比其子节点都大
     *
     * @param index
     * @param length
     * @param target
     */
    private void heapify(int index, int length, int[] target) {
        int lChild = (index << 1) + 1, rChild = lChild + 1,
                // 默认左节点最大
                cMax = lChild;
        if (lChild > length) {
            return;
        }
        // 判断左右节点大小
        if (rChild <= length && target[rChild] > target[lChild]) {
            cMax = rChild;
        }
        // 判断父子节点大小
        if (target[index] < target[cMax]) {
            swap(cMax, index, target);
            heapify(cMax, length, target);
        }
    }

    private void swap(int i, int j, int[] target) {
        int t = target[i];
        target[i] = target[j];
        target[j] = t;
    }
}
