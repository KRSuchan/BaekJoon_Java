package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_2456 {
    //    p_2456 : 나는 학급회장이다
    static int[][] cand = new int[4][4];
    static int max_sum;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            cand[1][s] += s;
            s = Integer.parseInt(st.nextToken());
            cand[2][s] += s;
            s = Integer.parseInt(st.nextToken());
            cand[3][s] += s;
        }
        int winner = step_one();
        if (winner == 0) winner = step_two();
        if (winner == 0) winner = step_three();

        var sb = new StringBuilder();
        sb.append(winner);
        sb.append(" ");
        sb.append(max_sum);
        System.out.println(sb);
    }

    private static int step_one() {
        int[] sum = {
                0,
                cand[1][1] + cand[1][2] + cand[1][3],
                cand[2][1] + cand[2][2] + cand[2][3],
                cand[3][1] + cand[3][2] + cand[3][3],
        };
        max_sum = Math.max(sum[1], Math.max(sum[2], sum[3]));
        if (sum[1] > sum[2] && sum[1] > sum[3]) {
            return 1;
        }
        if (sum[2] > sum[3] && sum[2] > sum[1]) {
            return 2;
        }
        if (sum[3] > sum[1] && sum[3] > sum[2]) {
            return 3;
        }
        if (sum[1] == sum[2] && sum[2] == sum[3]) {
            list.add(1);
            list.add(2);
            list.add(3);
            return 0;
        }
        if (sum[1] == sum[2]) {
            list.add(1);
            list.add(2);
            return 0;
        }
        if (sum[1] == sum[3]) {
            list.add(1);
            list.add(3);
            return 0;
        }
        if (sum[2] == sum[3]) {
            list.add(2);
            list.add(3);
            return 0;
        }
        return 0;
    }

    private static int step_two() {
        int max = 0;
        int res = 0;
        for (int idx : list) {
            if (max < cand[idx][3]) {
                max = cand[idx][3];
                res = idx;
            }
        }
        for (int idx : list) {
            if (idx != res && max == cand[idx][3]) {
                return 0;
            }
        }
        return res;
    }

    private static int step_three() {
        int max = 0;
        int res = 0;
        for (int idx : list) {
            if (max < cand[idx][2]) {
                max = cand[idx][2];
                res = idx;
            }
        }
        for (int idx : list) {
            if (idx != res && max == cand[idx][2]) {
                return 0;
            }
        }
        return res;
    }


}
