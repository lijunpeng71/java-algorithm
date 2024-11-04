package cn.com.bjtu.citel.algorithm.base;

import java.util.*;

public class DictPrint {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String linesStr = scanner.nextLine();
                String[] nums = linesStr.split(" ");
                int dictNum = Integer.parseInt(nums[0]);
                int maxColum = Integer.parseInt(nums[1]);
                List<String> dictNameList = new ArrayList<>();
                int maxDictNameColumn = 0;
                for (int i = 0; i < dictNum; ++i) {
                    dictNameList.add(scanner.nextLine());
                    if (dictNameList.get(i).length() > maxDictNameColumn) {
                        maxDictNameColumn = dictNameList.get(i).length();
                    }
                }
                Collections.sort(dictNameList);
                for (int i = 0; i < dictNum; i++) {
                    StringBuilder newDictNameSb = new StringBuilder(dictNameList.get(i));
                    for (int j = 0; j < maxDictNameColumn - dictNameList.get(i).length(); j++) {
                        newDictNameSb.append(" ");
                    }
                    dictNameList.set(i, newDictNameSb.toString());
                }
                int maxDictPerRow = (maxColum - maxDictNameColumn) / (maxDictNameColumn + 2) + 1;
                int maxRow = dictNum / maxDictPerRow + (dictNum % maxDictPerRow == 0 ? 0 : 1);
                int lastLineDictNum = dictNum % maxDictPerRow;
                StringBuilder columSb = new StringBuilder();
                for (int i = 0; i < maxColum; ++i) {
                    columSb.append("-");
                }
                System.out.println(columSb);
                StringBuilder[] rowDictSbs = new StringBuilder[Math.toIntExact(maxRow)];
                if (lastLineDictNum == 0) {
                    for (int i = 0; i < maxDictPerRow * maxRow; ++i) {
                        if (i < maxRow) {
                            rowDictSbs[i % maxRow] = new StringBuilder();
                            rowDictSbs[i % maxRow].append(dictNameList.get(i));
                        } else {
                            rowDictSbs[i % maxRow].append("  ").append(dictNameList.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < lastLineDictNum * maxRow; ++i) {
                        if (i < maxRow) {
                            rowDictSbs[i % maxRow] = new StringBuilder();
                            rowDictSbs[i % maxRow].append(dictNameList.get(i));
                        } else {
                            rowDictSbs[i % maxRow].append("  ").append(dictNameList.get(i));
                        }
                    }
                    int startIndex = lastLineDictNum * maxRow;
                    int newMaxRow = Math.max(maxRow - 1, 1);
                    for (int i = startIndex; i < dictNum; i++) {
                        rowDictSbs[(i - startIndex) % newMaxRow].append("  ").append(dictNameList.get(i));
                    }
                }
                for (int i = 0; i < maxRow; i++) {
                    System.out.println(rowDictSbs[i].toString());
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
