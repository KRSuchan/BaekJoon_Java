package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10830 {
    //    p_10830 : 행렬 제곱
    static int N;
    static int[][] mat;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] res = pow(mat, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] pow(int[][] A, long exp) {
        if (exp == 1) {
            return A;
        }
        int[][] ret = pow(A, exp / 2);
        ret = matMul(ret, ret);
        if (exp % 2 == 1) {
            ret = matMul(ret, mat);
        }
        return ret;
    }

    private static int[][] matMul(int[][] a, int[][] b) {
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }
        return ret;
    }
}
