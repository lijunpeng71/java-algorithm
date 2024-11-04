package com.leetcode.algorithm.p48.groupanagrams;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author [您的名字]
 * @date 2024-08-19 11:28
 * @description [类的简要描述]
 */
public class GroupAnagramsSolution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramListMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tempStr = String.valueOf(chars);
            List<String> anagramList = anagramListMap.computeIfAbsent(tempStr, k -> new ArrayList<>());
            anagramList.add(str);
        }
        return new ArrayList<>(anagramListMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = groupAnagrams(strs);
        resultList.forEach((ArrayUtil::toString));
    }
}
