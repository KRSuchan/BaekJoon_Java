package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14888 {
    //    p_14888 : 연산자 끼워넣기
    static int[] arr;
    static int[] operator;
    static int N, res;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operator = new int[4];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int op = -1;
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
            if (op == -1 && operator[i] != 0) {
                op = i;
            }
        }
        res = arr[0];
        dfs(1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int x) {
        if (x == N) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                int backup = res;
                switch (i) {
                    case 0 -> res += arr[x];
                    case 1 -> res -= arr[x];
                    case 2 -> res *= arr[x];
                    case 3 -> res /= arr[x];
                }
                operator[i]--;
                dfs(x + 1);
                operator[i]++;
                res = backup;
            }
        }
    }
}
