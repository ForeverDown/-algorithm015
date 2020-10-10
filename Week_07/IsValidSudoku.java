package week7;

import java.util.HashMap;
/*
有效的数独
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];//记录行的数字
        HashMap<Integer, Integer>[] columns = new HashMap[9];//记录列的数字
        HashMap<Integer, Integer>[] boxes = new HashMap[9];//记录9格框的数字
        //初始化
        for (int i = 0; i < 9; i ++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        //遍历棋盘
        for (int row = 0; row < 9; row ++) {
            for (int col = 0; col < 9; col ++) {
                //获取当前值
                char num = board[row][col];
                if (num != '.') {
                    int n = (int)num;
                    //获得9宫格编号
                    int boxIndex = (row / 3) * 3 + col / 3;
                    //记录数字出现的次数
                    //键：数字n，值为出现次数，若没出现过就取1，出现过就取n+1
                    rows[row].put(n, rows[row].getOrDefault(n, 0) + 1);
                    columns[col].put(n, columns[col].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
                    if (rows[row].get(n) > 1 || columns[col].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
