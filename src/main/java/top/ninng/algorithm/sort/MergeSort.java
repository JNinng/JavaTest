package top.ninng.algorithm.sort;

/**
 * @Author OhmLaw
 * @Date 2024/2/20 15:09
 * @Version 1.0
 */
public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] target) {
        int len = target.length;
        int[] result = new int[len];
        int block, start;

        for (block = 1; block < len * 2; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = Math.min((start + block), len);
                int high = Math.min((start + 2 * block), len);
                // 两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                // 排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = target[start1] < target[start2] ? target[start1++] : target[start2++];
                }
                // 剩余数据
                while (start1 < end1) {
                    result[low++] = target[start1++];
                }
                while (start2 < end2) {
                    result[low++] = target[start2++];
                }
            }
            // 交换引用
            int[] temp = target;
            target = result;
            result = temp;
        }
        return target;
    }
}
