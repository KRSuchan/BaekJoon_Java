package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_27323 {
    //    p_27323 : 직사각형
    public static void solution(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        System.out.println(A * B);
    }
}
