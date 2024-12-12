package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1011 {
    //    p_1011 : Fly me to the Alpha Centauri
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (N-- > 0) {
            var st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y - x;
            int max = (int) Math.sqrt(distance);
            if (max == Math.sqrt(distance)) {
                sb.append(2 * max - 1).append("\n");
            } else if (distance <= max * max + max) {
                sb.append(2 * max).append("\n");
            } else {
                sb.append(2 * max + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
