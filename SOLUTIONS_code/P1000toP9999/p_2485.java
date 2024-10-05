package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2485 {
    //    p_2485 : 가로수
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }
        int gcd = 0;
        for (int i = 1; i < N; i++) {
            int distance = trees[i] - trees[i - 1];
            gcd = gcd(distance, gcd);
        }
        // gcd == distances' gcd
        System.out.println((trees[N - 1] - trees[0]) / gcd + 1 - N);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
