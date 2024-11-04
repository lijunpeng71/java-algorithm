package cn.com.bjtu.citel.algorithm.base;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BuildBlocksByPython {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] linesStr = scanner.nextLine().split(" ");
            int line = Integer.parseInt(linesStr[0]);
            //积木的位置
            String[] position = new String[line];
            for (int i = 0; i < line; i++) {
                position[i] = i + "-" + 0;
            }
            Integer[][] matrix = new Integer[line][line];
            for (int i = 0; i < line; i++) {
                matrix[i][0] = i;
            }
            while (true) {
                String command = scanner.nextLine();
                if ("q".equals(command)) {
                    print(matrix);
                    System.exit(0);
                }
                String legalCommand = "[a-z][a-z] \\d [a-z][a-z] \\d";
                if (!Pattern.matches(legalCommand, command)) {
                    continue;
                }
                String[] rows = command.split(" ");
                int first = Integer.parseInt(rows[1]);
                int second = Integer.parseInt(rows[3]);
                int[] firstPosition = findPosition(first, matrix);
                int[] secondPosition = findPosition(second, matrix);
                if (first == second) {
                    continue;
                }
                if (firstPosition[0] == secondPosition[0]) {
                    continue;
                }
                if (Pattern.matches("^mv \\d on \\d$", command)) {
                    mvAOnB(firstPosition[0], firstPosition[1], secondPosition[0], secondPosition[1], matrix);
                } else if (Pattern.matches("^mv \\d ov \\d$", command)) {
                    mvAOvB(firstPosition[0], firstPosition[1], secondPosition[0], secondPosition[1], matrix);
                } else if (Pattern.matches("^st \\d on \\d$", command)) {
                    stAOnB(firstPosition[0], firstPosition[1], secondPosition[0], secondPosition[1], matrix);
                } else if (Pattern.matches("^st \\d ov \\d$", command)) {
                    stAOvB(firstPosition[0], firstPosition[1], secondPosition[0], secondPosition[1], matrix);
                } else if (Pattern.matches("^xh \\d an \\d$", command)) {
                    xhAAnB(firstPosition[0], firstPosition[1], secondPosition[0], secondPosition[1], matrix);
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static void mvAOnB(int firstRow, int firstColumn, int secondRow, int secondColumn, Integer[][] matrix) {
        recover(firstRow, firstColumn, matrix);
        recover(secondRow, secondColumn, matrix);
        matrix[secondRow][secondColumn + 1] = matrix[firstRow][firstColumn];
        matrix[firstRow][firstColumn] = null;
    }

    public static void mvAOvB(int firstRow, int firstColumn, int secondRow, int secondColumn, Integer[][] matrix) {
        //把first上面的积木复原
        for (int i = firstColumn + 1; i < matrix[firstRow].length; i++) {
            if (matrix[firstRow][i] != null) {
                matrix[matrix[firstRow][i]][0] = matrix[firstRow][i];
                matrix[firstRow][i] = null;
            }
        }
        //找到second上没有元素的位置
        int secondColumnIndex = 0;
        for (secondColumnIndex = 0; secondColumnIndex < matrix[0].length; secondColumnIndex++) {
            if (matrix[secondRow][secondColumnIndex] == null) {
                break;
            }
        }
        matrix[secondRow][secondColumnIndex] = matrix[firstRow][firstColumn];
        matrix[firstRow][firstColumn] = null;
    }

    public static void stAOnB(int firstRow, int firstColumn, int secondRow, int secondColumn, Integer[][] matrix) {
        recover(secondRow, secondColumn, matrix);
        int secondColumnIndex = 1;
        for (int i = 0; i < matrix[firstRow].length; i++) {
            if (matrix[firstRow][i] == null) {
                break;
            } else {
                matrix[secondRow][secondColumn + secondColumnIndex] = matrix[firstRow][i];
                matrix[firstRow][i] = null;
                secondColumnIndex++;
            }
        }
    }

    public static void stAOvB(int firstRow, int firstColumn, int secondRow, int secondColumn, Integer[][] matrix) {
        int secondColumnIndex = 0;
        for (int i = 0; i < matrix[firstRow].length; i++) {
            if (matrix[secondRow][i] == null) {
                secondColumnIndex = i;
                break;
            }
        }
        for (int j = firstColumn; j < matrix[firstRow].length; j++) {
            if (matrix[firstRow][j] == null) {
                break;
            } else {
                matrix[secondRow][secondColumnIndex] = matrix[firstRow][j];
                matrix[firstRow][j] = null;
                secondColumnIndex++;
            }
        }
    }

    public static void xhAAnB(int firstRow, int firstColumn, int secondRow, int secondColumn, Integer[][] matrix) {
        for (int i = 0; i < matrix[firstRow].length; i++) {
            Integer temp = matrix[firstRow][i];
            matrix[firstRow][i] = matrix[secondRow][i];
            matrix[secondRow][i] = temp;
        }
    }

    public static void recover(int row, int column, Integer[][] martix) {
        for (int i = column + 1; i < martix[row].length; i++) {
            if (martix[row][i] != null) {
                martix[martix[row][i]][0] = martix[row][i];
                martix[row][i] = null;
            }
        }
    }

    public static int[] findPosition(int elem, Integer[][] martix) {
        for (int i = 0; i < martix[0].length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                if (martix[i][j] == null) {
                    break;
                }
                if (martix[i][j] == elem) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void print(Integer[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    break;
                }
                if (j == 0) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(" " + matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
