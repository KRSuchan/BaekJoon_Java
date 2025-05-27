package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1009 {
    //    p_1009 : 분산처리
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = 0;
            int temp = a % 10;
            int res = 1;
            if (temp == 1 || temp == 5 || temp == 6 || temp == 0) {
                res = temp;
                if (res == 0) res = 10;
                sb.append(res).append("\n");
                continue;
            } else if (temp == 4 || temp == 9) {
                c = b % 2;
                if (c == 0) c = 2;
            } else {
                c = b % 4;
                if (c == 0) c = 4;
            }
            for (int i = 0; i < c; i++) {
                res = (res * a) % 10;
            }
            if (res == 0) res = 10;
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
