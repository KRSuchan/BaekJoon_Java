package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11403 {
    //    p_11403 : 경로 찾기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;

        // init
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜
        for (int m = 0; m < n; m++) { // 중간 idx
            for (int s = 0; s < n; s++) { // 시작 idx
                for (int e = 0; e < n; e++) { // 끝 idx
                    if (arr[s][m] == 1 && arr[m][e] == 1) {
                        arr[s][e] = 1;
                    }
                }
            }
        }

        // output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
