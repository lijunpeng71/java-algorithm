package cn.com.bjtu.citel.algorithm.advanced;

import java.util.*;
import java.util.stream.Collectors;

public class SpecialWordsV2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> specialWordsList = new ArrayList<>();
            Map<String, char[]> wordsMap = new HashMap<>();
            while (true) {
                String inputStr = scanner.nextLine();
                if (!"#".equals(inputStr)) {
                    String[] words = inputStr.split(" ");
                    for (String word : words) {
                        char[] chars = word.toLowerCase().toCharArray();
                        Arrays.sort(chars);
                        String matchWord = processWords(word, wordsMap);
                        if (matchWord != null) {
                            Set<String> dupliateSet = specialWordsList.stream().filter(index -> index.equalsIgnoreCase(matchWord)).collect(Collectors.toSet());
                            if (dupliateSet.isEmpty()) {
                                specialWordsList.add(matchWord);
                            }
                        } else {
                            wordsMap.put(word, chars);
                        }
                    }
                } else {
                    if (!specialWordsList.isEmpty()) {
                        Set<String> lowSpecialWordsSet = specialWordsList.stream().map(String::toLowerCase).collect(Collectors.toSet());
                        Collections.sort(specialWordsList);
                        for (String s : specialWordsList) {
                            System.out.println(s);
                        }
                    }
                    System.exit(0);
                }
            }
        } catch (
                Exception e) {
            System.exit(0);
        }

    }

    private static String processWords(String word, Map<String, char[]> wordsMap) {
        char[] wordChs = word.toLowerCase().toCharArray();
        Arrays.sort(wordChs);
        Set<String> keySet = wordsMap.keySet();
        for (String key : keySet) {
            if (word.length() != key.length() || word.equals(key)) {
                continue;
            }
            char[] matchChs = wordsMap.get(key);
            if (Arrays.compare(wordChs, matchChs) == 0) {
                return key;
            }
        }
        return null;
    }
}
