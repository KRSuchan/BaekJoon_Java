package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_24265 {
    //    p_24265 : 알고리즘 수업 - 알고리즘의 수행 시간 4
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.println(n * (n - 1) / 2);
        System.out.println(2);
    }
}