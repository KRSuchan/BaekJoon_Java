package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_6064 {
    //    p_6064번 : 카잉 달력
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            boolean flag = false;
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = m * n;
            for (int j = x; j < z; j += m) {
                if (j % n == y) {
                    sb.append(j + 1).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
    }
}
