package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_27918 {
    //    p_27918 : 탁구 경기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int X = 0;
        int Y = 0;
        for (int i = 0; i < N; i++) {
            switch (br.readLine()) {
                case "D" -> X++;
                case "P" -> Y++;
            }
            if (Math.abs(X - Y) == 2) break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(X).append(":").append(Y);
        System.out.println(sb);
    }
}
