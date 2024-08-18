package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_25904 {
    //    p_25904 : 안녕 클레오파트라 세상에서 제일가는 포테이토칩
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        while (true) {
            if (p[idx] < x) {
                System.out.println(idx % n + 1);
                break;
            }
            idx++;
            idx %= n;
            x++;
        }
    }
}
