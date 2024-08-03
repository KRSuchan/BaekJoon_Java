package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p_2605 {
    //    p_2605 : 줄 세우기
    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // alg
        for (int i = 0; i < N; i++) {
            list.add(i - Integer.parseInt(st.nextToken()), i + 1);
        }
        // output
        for (int v : list) {
            sb.append(v).append(" ");
        }
        System.out.print(sb);
    }
}
