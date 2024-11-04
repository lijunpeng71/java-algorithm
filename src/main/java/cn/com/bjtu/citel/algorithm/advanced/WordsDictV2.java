package cn.com.bjtu.citel.algorithm.advanced;

import java.util.*;

public class WordsDictV2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, Long> wordAndCountMap = new HashMap<>();
            while (scanner.hasNext()) {
                String inputStr = scanner.next();
                if (inputStr == null || inputStr.isEmpty()) {
                    continue;
                }
                StringBuilder newStrSb = new StringBuilder();
                for (int i = 0; i < inputStr.length(); i++) {
                    inputStr = inputStr.toLowerCase();
                    if (inputStr.charAt(i) >= 'a' && inputStr.charAt(i) <= 'z') {
                        newStrSb.append(inputStr.charAt(i));
                    } else if (inputStr.charAt(i) == '\'') {
                        break;
                    }
                }
                if (newStrSb.length() <= 0) {
                    continue;
                }
                Long count = wordAndCountMap.get(newStrSb.toString());
                if (count == null) {
                    wordAndCountMap.put(newStrSb.toString(), 1L);
                } else {
                    wordAndCountMap.put(newStrSb.toString(), ++count);
                }
            }
            List<String> wordAndCountList = new ArrayList<>();
            wordAndCountMap.forEach((word, count) -> wordAndCountList.add(count + "-" + word));
            wordAndCountList.sort(WordsDictV2::wordMapCompare);
            wordAndCountList.forEach(countAndWord -> System.out.println(countAndWord.split("-")[1]));
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static int wordMapCompare(String firstStr, String secondStr) {
        String[] firstCountAndWord = firstStr.split("-");
        long firstCount = Long.parseLong(firstCountAndWord[0]);
        String firstWord = firstCountAndWord[1];
        String[] secondCountAndWord = secondStr.split("-");
        long secondCount = Long.parseLong(secondCountAndWord[0]);
        String secondWord = secondCountAndWord[1];
        if (firstCount == secondCount) {
            if (firstWord.compareTo(secondWord) < 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (firstCount < secondCount) {
            return 1;
        } else {
            return -1;
        }
    }
}
