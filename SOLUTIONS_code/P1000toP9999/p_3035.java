package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3035 {
    //    p_3035 : 스캐너
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2;
        for (int i = 0; i < R; i++) {
            sb2 = new StringBuilder();
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < ZC; k++) {
                    sb2.append(s.charAt(j));
                }
            }
            s = sb2.toString();
            sb2.append("\n");
            for (int j = 1; j < ZR; j++) {
                sb2.append(s).append("\n");
            }
            sb1.append(sb2);
        }
        System.out.print(sb1);
    }
}
