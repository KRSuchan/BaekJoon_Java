package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1780 {
    //    p_1780 : 종이의 개수
    static int[][] paper;
    static int[] nums = new int[3];

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        split(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }

    private static void split(int x, int y, int size) {
        if (isPossible(x, y, size)) {
            nums[paper[x][y] + 1]++;
            return;
        }
        int nextSize = size / 3;
        for (int i = 0; i < size; i += nextSize) {
            for (int j = 0; j < size; j += nextSize) {
                split(x + i, y + j, nextSize);
            }
        }
    }

    private static boolean isPossible(int x, int y, int size) {
        int value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
