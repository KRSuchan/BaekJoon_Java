package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_2684 {
    //    p_2684 : 동전 게임
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(br.readLine());
        String[] pattern = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};
        while (p-- > 0) {
            int[] result = new int[8];
            String s = br.readLine();
            for (int i = 0; i <= 37; i++) {
                for (int j = 0; j < 8; j++) {
                    if (s.substring(i, i + 3).equals(pattern[j])) {
                        result[j]++;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
