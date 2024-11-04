package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;
import java.util.Arrays;

public class DictPrint2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                String linesStr = scanner.nextLine();
                String[] nums = linesStr.split(" ");
                int dictNum = Integer.parseInt(nums[0]);
                int maxColum = Integer.parseInt(nums[1]);
                String[] dictStrs = new String[dictNum];
                int maxLen = 0;
                for (int i = 0; i < dictNum; i++) {
                    dictStrs[i] = scanner.next();
                    if (dictStrs[i].length() > maxLen) {
                        maxLen = dictStrs[i].length();
                    }
                }
                Arrays.sort(dictStrs);
                StringBuilder maxColumnSb = new StringBuilder();
                for (int i = 0; i < maxColum; i++) {
                    maxColumnSb.append("-");
                }
                System.out.println(maxColumnSb);
                int columnEachRow = (maxColum + 2) / (maxLen + 2);
                int widthEachColumn = (int) Math.ceil((double) dictNum / columnEachRow);

                if (widthEachColumn == 1) {
                    int columnIndex = 0;
                    for (int i = 0; i < columnEachRow; ++i) {
                        System.out.print(dictStrs[i]);
                        for (int j = 0; j < maxLen + 2 - dictStrs[i].length(); j++) {
                            if (columnIndex == columnEachRow - 1) break;
                            System.out.print(" ");
                        }
                        columnIndex++;
                    }
                    System.out.println();
                } else if (dictNum % columnEachRow == 0) {
                    for (int i = 0; i < columnEachRow; i++) {
                        int a = 0, columnIndex = i;
                        while (a < columnEachRow) {
                            System.out.print(dictStrs[columnIndex]);
                            for (int j = 0; j < maxLen + 2 - dictStrs[columnIndex].length(); j++) {
                                if (a == columnEachRow - 1) break;
                                System.out.print(" ");
                            }
                            a++;
                            columnIndex += widthEachColumn;
                        }
                        System.out.println();
                    }
                } else {
                    for (int i = 0; i < widthEachColumn - 1; i++) {
                        int a = 0, columnIndex = i;
                        while (a < dictNum % columnEachRow) {
                            System.out.print(dictStrs[columnIndex]);
                            for (int j = 0; j < maxLen + 2 - dictStrs[columnIndex].length(); j++) {
                                System.out.print(" ");
                            }
                            a++;
                            columnIndex += widthEachColumn;
                        }
                        while (a >= dictNum % columnEachRow && a < columnEachRow) {
                            System.out.println(dictStrs[columnIndex]);
                            for (int j = 0; j < maxLen + 2 - dictStrs[columnIndex].length(); j++) {
                                if (a == columnEachRow - 1) break;
                                System.out.print(" ");
                            }
                            a++;
                            columnIndex = columnIndex + widthEachColumn - 1;
                        }
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}

