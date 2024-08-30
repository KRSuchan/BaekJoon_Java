package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_9663 {
    //    p_9663 : N-Queen
    static int N, cnt;
    static int[] arr;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nQueen(0);
        System.out.print(cnt);
    }

    private static void nQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possible(depth))
                nQueen(depth + 1);
        }
    }

    private static boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[row] == arr[i]) // you're on the column
                return false;
            if (Math.abs(arr[row] - arr[i]) == Math.abs(row - i)) // you're on the cross line
                return false;
        }
        return true;
    }
}
