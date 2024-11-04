package com.leetcode.algorithm.p438.findanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author [您的名字]
 * @date 2024-08-20 23:02
 * @description [类的简要描述]
 */
public class FindAnagramsSolution {


    public static List<Integer> findAnagrams01(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return anagrams;
        }
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        int left = 0, right = p.length();
        while (right <= s.length()) {
            char[] subChars = s.substring(left, right).toCharArray();
            Arrays.sort(subChars);
            if (Arrays.compare(subChars, pChars) == 0) {
                anagrams.add(left);
            }
            left++;
            right++;
        }
        return anagrams;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return anagrams;
        }
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char pChar : pChars) {
            Integer count = pMap.getOrDefault(pChar, 0);
            pMap.put(pChar, ++count);
        }
        int all = p.length();
        for (int end = 0; end < p.length() - 1; end++) {
            if (pMap.containsKey(sChars[end])) {
                int count = pMap.get(sChars[end]);
                if (count > 0) {
                    all--;
                }
                pMap.put(sChars[end], count - 1);
            }
        }
        for(int end=p.length()-1,start=0;end<s.length();end++,start++){
            if(pMap.containsKey(sChars[end])){
                int count=pMap.get(sChars[end]);
                if(count>0){
                    all--;
                }
                pMap.put(sChars[end],count-1);
            }
            if(all==0){
                anagrams.add(start);
            }
            if(pMap.containsKey(sChars[start])){
                int count = pMap.get(sChars[start]);
                if(count>=0){
                    all++;
                }
                pMap.put(sChars[start],count+1);
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        anagrams.forEach(anagram -> System.out.print(anagram + "\t"));
    }
}
