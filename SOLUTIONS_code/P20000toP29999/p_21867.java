package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_21867 {
    //    p_21867 : Java Bitecode
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), "JAV");
        StringBuilder sb = new StringBuilder();
        if (st.countTokens() == 0) {
            System.out.println("nojava");
        } else {
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
            System.out.println(sb);
        }
    }
}
