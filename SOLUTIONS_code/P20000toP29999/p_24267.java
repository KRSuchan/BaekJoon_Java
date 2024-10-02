package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_24267 {
    //    p_24267 : 알고리즘 수업 - 알고리즘의 수행 시간 6
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        for (int i = 2; i < n; i++) {
            sum += (long) i * (i - 1) / 2;
        }
        System.out.println(sum);
        System.out.println(3);
    }
}
