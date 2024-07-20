package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_9713 {
    //    p_9713 : Sum of Odd Sequence
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j = 1; j <= n; j += 2) {
                sum += j;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
