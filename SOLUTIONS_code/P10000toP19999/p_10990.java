package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_10990 {
    //    p_10990 : 별 찍기 - 15
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(N - 1)).append("*").append("\n");
        for (int i = 1; i < N; i++)
            sb.append(" ".repeat(N - 1 - i)).append("*").append(" ".repeat((i - 1) * 2 + 1)).append("*").append("\n");
        System.out.println(sb);
    }
}
