package top.ninng.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch implements Search {

    @Override
    public int search(int[] data, int target) {
        return binarySearch(0, data.length - 1, data, target);
    }

    private int binarySearch(int l, int r, int[] data, int target) {
        if (l > r) {
            return -1;
        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (data[mid] >= target) {
                // 中位大于等于目标，则目标可能在 (l,mid) 中
                r = mid;
            } else {
                // 否则目标可能在 (mid+1,r) 中
                l = mid + 1;
            }
        }
        return l;
    }
}
