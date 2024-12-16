package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1041 {
    //    p_1041 : 주사위
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        var st = new StringTokenizer(br.readLine());
        int one = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            one = Math.min(one, arr[i]);
        }

        if (N == 1) {
            Arrays.sort(arr);
            long res = 0;
            for (int i = 0; i < 5; i++) {
                res += arr[i];
            }
            System.out.println(res);
            return;
        }

        long totalSide = N * N * N - (N - 2) * (N - 2) * (N - 1);
        long side1 = (N - 2) * (N - 2 + (N - 1) * 4);
        long side2 = totalSide - side1 - 4;
        long side3 = 4;

        int three = Math.min(arr[0], arr[5]) + Math.min(arr[1], arr[4]) + Math.min(arr[2], arr[3]);
        int two = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue;
                two = Math.min(two, arr[i] + arr[j]);
            }
        }
        long res = side1 * one + side2 * two + side3 * three;
        System.out.println(res);
    }
}
