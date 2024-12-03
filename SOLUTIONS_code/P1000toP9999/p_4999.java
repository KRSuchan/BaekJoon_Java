package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_4999 {
    //    p_4999 : 아!
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int s1 = br.readLine().length();
        int s2 = br.readLine().length();
        System.out.println(s1 >= s2 ? "go" : "no");
    }
}
