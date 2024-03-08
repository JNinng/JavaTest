package top.ninng;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.ninng.algorithm.sort.*;

import java.util.Arrays;

/**
 * 排序测试
 */
public class SortTest {

    int[] target = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    @Test
    public void bubbleSort() {
        new BubbleSort().sort(target);
    }

    @Test
    public void heapSort() {
        new HeapSort().sort(target);
    }

    @Before
    public void init() {
        int length = 10;
        target = new int[length];
        for (int i = 0; i < length; i++) {
            target[i] = length - i;
//            target[i] = new Random().nextInt(length);
        }
    }

    @Test
    public void insertionSort() {
        new InsertionSort().sort(target);
    }

    @Test
    public void mergeSort() {
        new MergeSort().sort(target);
    }

    @After
    public void print() {
        System.out.println(Arrays.toString(target));
    }

    @Test
    public void quickSort() {
        new QuickSort().sort(target);
    }

    @Test
    public void shellSort() {
        new ShellSort().sort(target);
    }
}
