package cn.com.bjtu.citel.algorithm.advanced;

import java.util.*;
import java.util.stream.Collectors;

public class WordsDict {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> inputStrList = new ArrayList<>();
            while (scanner.hasNext()) {
                String inputStr = scanner.nextLine();
                String[] inputWords = inputStr.split(" ");
                List<String> newWordList = Arrays.stream(inputWords).map(WordsDict::replaceNonCharAnd).map(String::trim).collect(Collectors.toList());
                inputStrList.addAll(newWordList);
            }
            List<String> wordAndCountList = new ArrayList<>();
            Map<String, Long> wordCoutMap = inputStrList.stream().collect(Collectors.groupingBy(index -> index, Collectors.counting()));
            wordCoutMap.forEach((word, count) -> wordAndCountList.add(count + "-" + word));
            wordAndCountList.sort(WordsDict::wordMapCompare);
            wordAndCountList.forEach(countAndWord -> System.out.println(countAndWord.split("-")[1]));
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static String replaceNonCharAnd(String words) {
        String newWord = words.toLowerCase();
        StringBuilder nwWordSb = new StringBuilder();
        for (char ch : newWord.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                nwWordSb.append(ch);
            } else if (ch == '\'') {
                break;
            }
        }
        return nwWordSb.toString();
    }

    public static int wordMapCompare(String firstStr, String secondStr) {
        String[] firstCountAndWord = firstStr.split("-");
        String[] secondCountAndWord = secondStr.split("-");
        int compareCountRet = firstCountAndWord[0].compareTo(secondCountAndWord[0]);
        if (compareCountRet != 0) {
            return -compareCountRet;
        } else {
            return firstCountAndWord[1].compareTo(secondCountAndWord[1]);
        }
    }
}
