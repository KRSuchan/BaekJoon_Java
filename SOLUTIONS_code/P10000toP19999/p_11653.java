package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_11653 {
    //    p_11653 : 소인수분해
    public static void solution(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while (N > 1) {
            for (int i = 2; i < N / 2; i++) {
                if (N % i == 0) {
                    sb.append(i).append("\n");
                    N /= i;
                    break;
                }
            }

        }
        System.out.print(sb);
    }
}
