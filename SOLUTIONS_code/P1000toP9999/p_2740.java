package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2740 {
    //    p_2740 : 행렬 곱셈
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] mat1 = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] mat2 = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                mat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        matMul(mat1, mat2);
        System.out.println(sb);
    }

    private static void matMul(int[][] mat1, int[][] mat2) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < K; k++) {
                int x = 0;
                for (int j = 0; j < M; j++) {
                    x += mat1[i][j] * mat2[j][k];
                }
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
    }
}
