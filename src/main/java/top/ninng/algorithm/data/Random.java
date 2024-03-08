package top.ninng.algorithm.data;

import java.util.Arrays;

/**
 * 概率随机分布
 */
public class Random {

    /**
     * {@link #weightRandom()} 按权重生成的概率表
     */
    private int[] probabilityTable;
    private int[] weightList;
    private int weight;

    public Random(int[] weightList) {
        this.weightList = weightList;
        weight = Arrays.stream(weightList).sum();
        initTable();
    }

    public void initTable() {
        int length = weight;
        int[] weight = weightList.clone();
        if (probabilityTable == null) {
            probabilityTable = new int[length];
            int j = 0;
            for (int i = 0; i < length; i++) {
                for (j %= weight.length; j < weight.length; j++) {
                    if (weight[j] > 0) {
                        probabilityTable[i] = j;
                        weight[j++]--;
                        break;
                    }
                }
            }
        }
    }

    // Dubbo 中基于权重的随机算法
    public int weightFilter() {
        // 总权重中抽取随机样本
        int random = (int) Math.floor(Math.random() * weight);
        for (int j = 0; j < weightList.length; j++) {
            // 默认随机足够随机情况下，安区间大小控制权重
            if (random - weightList[j] < 0) {
                // 样本子权重，则认为此次随机命中
                return j;
            } else {
                // 样本大于子权重，则认为此次随机未命中，减去当前权重，继续下次循环
                random -= weightList[j];
            }
        }
        return 0;
    }

    /**
     * 按总权重生成随机后查询概率表
     *
     * @return
     */
    public int weightRandom() {
        return probabilityTable[(int) Math.floor(Math.random() * weight)];
    }
}
