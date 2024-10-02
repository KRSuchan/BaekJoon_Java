package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_24266 {
    //    p_24266 : 알고리즘 수업 - 알고리즘의 수행 시간 5
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.println(n * n * n);
        System.out.println(3);
    }
}
