package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14889 {
    //    p_14889 : 스타트와 링크
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int num, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }
        for (int i = num; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(start - link));
        if (min == 0) {
            System.out.println(min);
            System.exit(0);
        }
    }
}
