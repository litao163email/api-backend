package com.taoli.apicommon.dubboService;

import java.util.List;

/**
 * 编辑距离算法（用于计算最相似的两组标签）
 * 原理：https://blog.csdn.net/DBC_121/article/details/104198838
 * @author litao163email@163.com
 * (dubboService这个文件夹是所有dubbo都可以使用的方法,注意一定要引入dubbo依赖,否则会报错)
 */
public interface AlgorithmService {

    /**
     * 编辑距离算法（用于计算最相似的两组字符串）
     * 原理：https://blog.csdn.net/DBC_121/article/details/104198838
     */
    int minDistance(List<String> tagList1, List<String> tagList2);

    /**
     * 编辑距离算法（用于计算最相似的两个字符串）
     * 原理：https://blog.csdn.net/DBC_121/article/details/104198838
     */
    int minDistance(String word1, String word2);
}
