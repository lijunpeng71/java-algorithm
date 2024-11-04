package cn.com.bjtu.citel.algorithm.advanced;

import java.util.*;

public class SpecialWords {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> specialWordsList = new ArrayList<>();
            Map<String, char[]> wordsMap = new HashMap<>();
            while (true) {
                String inputStr = scanner.nextLine();
                if (!"#".equals(inputStr)) {
                    String[] words = inputStr.split(" ");
                    for (String word : words) {
                        char[] chars = wordToUniqueChars(word.toLowerCase());
                        Arrays.sort(chars);
                        String matchWord = processWords(word, wordsMap);
                        if (matchWord != null && !specialWordsList.contains(matchWord)) {
                            specialWordsList.add(matchWord);
                        }
                        wordsMap.put(word, chars);
                    }
                } else {
                    if (!specialWordsList.isEmpty()) {
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
        char[] wordChs = wordToUniqueChars(word.toLowerCase());
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

    private static char[] wordToUniqueChars(String word) {
        int[] allChars = new int[128];
        int len = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (allChars[ch] == 0) {
                len++;
            }
            allChars[ch]++;
        }
        char[] chars = new char[len];
        for (int i = 0, j = 0; i < allChars.length; i++) {
            if (allChars[i] != 0) {
                chars[j++] = (char) i;
            }
        }
        return chars;
    }
}
