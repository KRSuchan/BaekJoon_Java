package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2580 {
    //    p_2580 : 스도쿠
    static int row = 9, col = 9;
    static int[][] arr;
    static StringBuilder sb;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0);
    }

    private static void sudoku(int r, int c) {
        if (c == col) {
            sudoku(r + 1, 0);
            return;
        }
        if (r == row) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        if (arr[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(r, c, i)) {
                    arr[r][c] = i;
                    sudoku(r, c + 1);
                }
            }
            arr[r][c] = 0;
            return;
        }

        sudoku(r, c + 1);
    }

    private static boolean possibility(int r, int c, int v) {
        // row 1~9 확인
        for (int i = 0; i < row; i++) {
            if (arr[r][i] == v) {
                return false;
            }
        }
        // col 1~9 확인
        for (int i = 0; i < col; i++) {
            if (arr[i][c] == v) {
                return false;
            }
        }
        // 3by3에 1~9 확인
        int start_row = (r / 3) * 3;
        int start_col = (c / 3) * 3;

        for (int i = start_row; i < start_row + 3; i++) {
            for (int j = start_col; j < start_col + 3; j++) {
                if (arr[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}
