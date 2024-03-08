package top.ninng;

import org.junit.Test;
import top.ninng.algorithm.search.BinarySearch;

/**
 * 搜索算法测试
 */
public class SearchTest {

    int[] data = new int[]{0, 11, 22, 23, 654, 878, 999};
    int target = 23;

    @Test
    public void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(data, target));
    }
}
