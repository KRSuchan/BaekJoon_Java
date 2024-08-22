package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_16485 {
    //    p_16485 : 작도하자! - ②
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double c = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        if (c % b == 0) System.out.println((int) (c / b));
        else System.out.println(c / b);
    }
}
