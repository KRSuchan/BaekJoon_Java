package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_29751 {
    //    p_29751 : 삼각형
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        double w = Integer.parseInt(st.nextToken());
        double h = Integer.parseInt(st.nextToken());
        System.out.println(w * h / 2);
    }
}
