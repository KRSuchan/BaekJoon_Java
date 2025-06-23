package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_20492 {
    //    p_20492 : 세금
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int res1 = N - N / 100 * 22;
        int res2 = N - N / 100 * 20 / 100 * 22;
        System.out.printf("%d %d", res1, res2);
    }
}
