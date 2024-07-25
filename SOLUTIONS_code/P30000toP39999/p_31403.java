package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_31403 {
    //    p_31403 : A+B-C
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int c = Integer.parseInt(br.readLine());
        System.out.println((Integer.parseInt(a) + Integer.parseInt(b) - c) + "\n" +
                (Integer.parseInt(a + b) - c));
    }
}
