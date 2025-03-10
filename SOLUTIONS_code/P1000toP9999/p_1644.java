package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p_1644 {
    //    p_1644 : 소수의 연속합
    static ArrayList<Integer> list;
    static int n;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        getPrime();
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while (start <= end && end < list.size()) {
            if (sum < n) {
                sum += list.get(end++);
            } else {
                if (sum == n) cnt++;
                sum -= list.get(start++);
            }
        }
        System.out.println(cnt);
    }

    private static void getPrime() { // 에라토스테네스의 체
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2, sqrt_i = i * i; sqrt_i <= n; i++, sqrt_i = i * i) {
            if (isPrime[i]) {
                for (int j = sqrt_i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) list.add(i);
        }
        list.add(0);
    }
}
