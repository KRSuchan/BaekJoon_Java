package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_2342 {
    //    p_2342 : Dance Dance Revolution
    static int size;
    static int[][][] dp;
    static ArrayList<Integer> ddr;
    static int[][] move;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        ddr = new ArrayList<>();
        move = new int[][]{ // [from][to]
                {0, 2, 2, 2, 2}, // [0][to]
                {0, 1, 3, 4, 3}, // [1][to]
                {0, 3, 1, 3, 4}, // [2][to]
                {0, 4, 3, 1, 3}, // [3][to]
                {0, 3, 4, 3, 1}  // [4][to]
        };
        while (true) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            ddr.add(num);
        }
        size = ddr.size();
        dp = new int[ddr.size()][5][5];
        int result = search(0, 0, 0);
        System.out.println(result);
    }

    private static int search(int idx, int left, int right) {
        if (idx == size) return 0;
        if (dp[idx][left][right] != 0) return dp[idx][left][right];
        int next = ddr.get(idx);
        return dp[idx][left][right]
                = Math.min(
                search(idx + 1, next, right) + move[left][next],
                search(idx + 1, left, next) + move[right][next]);
    }
}
