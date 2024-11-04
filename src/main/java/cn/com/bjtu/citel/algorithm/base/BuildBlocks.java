package cn.com.bjtu.citel.algorithm.base;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BuildBlocks {
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
            print(matrix);
            while (true) {
                String command = scanner.nextLine();
                if ("q".equals(command)) {
                    System.exit(0);
                }
                String legalCommand = "[a-z][a-z] \\d [a-z][a-z] \\d";
                if (!Pattern.matches(legalCommand, command)) {
                    continue;
                }
                String[] rows = command.split(" ");
                int first = Integer.parseInt(rows[1]);
                int second = Integer.parseInt(rows[3]);
                if (Pattern.matches("^mv \\d on \\d$", command)) {
                    mvAOnB(matrix, position, first, second);
                } else if (Pattern.matches("^mv \\d ov \\d$", command)) {
                    mvAOvB(matrix, position, first, second);
                } else if (Pattern.matches("^st \\d on \\d$", command)) {
                    stAOnB(matrix, position, first, second);
                } else if (Pattern.matches("^st \\d ov \\d$", command)) {
                    stAOvB(matrix, position, first, second);
                } else if (Pattern.matches("^xh \\d an \\d$", command)) {
                    xhAAnB(matrix, position, first, second);
                }
                print(matrix);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static void mvAOnB(Integer[][] matrix, String[] position, int first, int second) {
        resetByElem(matrix, position, first);
        resetByElem(matrix, position, second);
        putAToB(matrix, position, first, second);
    }

    public static void mvAOvB(Integer[][] matrix, String[] position, int first, int second) {
        resetByElem(matrix, position, first);
        putAToB(matrix, position, first, second);
    }

    public static void stAOnB(Integer[][] matrix, String[] position, int first, int second) {
        resetByElem(matrix, position, second);
        putAToB(matrix, position, first, second);
    }

    public static void stAOvB(Integer[][] matrix, String[] position, int first, int second) {
        putAToB(matrix, position, first, second);
    }

    public static void xhAAnB(Integer[][] matrix, String[] position, int first, int second) {
        xchange(matrix, position, first, second);
    }

    /**
     * 恢复
     *
     * @param matrix
     * @param position
     * @param elem
     */
    public static void resetByElem(Integer[][] matrix, String[] position, Integer elem) {
        int[] rowAndColum = Arrays.stream(position[elem].split("-")).mapToInt(Integer::parseInt).toArray();
        int row = rowAndColum[0];
        int column = rowAndColum[1];
        int index = column + 1;
        while (index < matrix[row].length && matrix[row][index] != null) {
            matrix[matrix[row][index]][0] = matrix[row][index];
            //恢复位置
            position[matrix[row][index]] = matrix[row][index] + "-0";
            matrix[row][index] = null;
            index++;
        }
    }

    /**
     * 把A放到B的顶端（包含A和A上面的所有）
     *
     * @param matrix
     * @param first
     * @param second
     */
    public static void putAToB(Integer[][] matrix, String[] position, int first, int second) {
        int[] rowAndColumFirst = Arrays.stream(position[first].split("-")).mapToInt(Integer::parseInt).toArray();
        int rowFirst = rowAndColumFirst[0];
        int columnFirst = rowAndColumFirst[1];
        int[] rowAndColumSecond = Arrays.stream(position[second].split("-")).mapToInt(Integer::parseInt).toArray();
        int rowSecond = rowAndColumSecond[0];
        int indexFirst = columnFirst;
        int indexSecond = 0;
        while (matrix[rowSecond][indexSecond] != null) {
            indexSecond++;
        }
        if (rowFirst != rowSecond) {
            while (matrix[rowFirst][indexFirst] != null && indexFirst < matrix[rowSecond].length) {
                matrix[rowSecond][indexSecond] = matrix[rowFirst][indexFirst];
                position[matrix[rowFirst][indexFirst]] = rowSecond + "-" + indexSecond;
                matrix[rowFirst][indexFirst] = null;
                indexFirst++;
                indexSecond++;
            }
        }
    }

    /**
     * 交互a和b
     *
     * @param matrix
     * @param first
     * @param second
     */
    public static void xchange(Integer[][] matrix, String[] position, int first, int second) {
        int[] rowAndColumnFirst = Arrays.stream(position[first].split("-")).mapToInt(Integer::parseInt).toArray();
        int rowFirst = rowAndColumnFirst[0];
        int[] rowAndColumnSecond = Arrays.stream(position[second].split("-")).mapToInt(Integer::parseInt).toArray();
        int rowSecond = rowAndColumnSecond[0];
        for (int index = 0; index < matrix[rowFirst].length; ++index) {
            if (matrix[rowFirst][index] == null && matrix[rowSecond][index] == null) {
                return;
            }
            Integer temp = matrix[rowFirst][index];
            matrix[rowFirst][index] = matrix[rowSecond][index];
            matrix[rowSecond][index] = temp;
            //设置位置
            if (matrix[rowSecond][index] != null) {
                position[matrix[rowSecond][index]] = rowSecond + "-" + index;
            }
            if (matrix[rowFirst][index] != null) {
                position[matrix[rowFirst][index]] = rowFirst + "-" + index;
            }
        }
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
