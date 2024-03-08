package top.ninng.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] target) {
        quick(0, target.length - 1, target);
        return target;
    }

    private void quick(int start, int pivot, int[] target) {
        if (start >= pivot) {
            return;
        }
        int l = start, r = pivot - 1;
        while (l < r) {
            while (target[l] <= target[pivot] && l < r) {
                l++;
            }
            while (target[r] >= target[pivot] && l < r) {
                r--;
            }
            swap(l, r, target);
        }
        if (target[l] >= target[pivot]) {
            swap(l, pivot, target);
        } else {
            l++;
        }
        quick(start, l - 1, target);
        quick(l + 1, pivot, target);
    }

    private void swap(int i, int j, int[] target) {
        int t = target[i];
        target[i] = target[j];
        target[j] = t;
    }
}
