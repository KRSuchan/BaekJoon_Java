package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_17094 {
    //    p_17094 : Serious Problem
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int two = 0, e = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'e') e++;
            else two++;
        }
        String output;
        if (two > e) output = "2";
        else if (e > two) output = "e";
        else output = "yee";

        System.out.println(output);
    }
}
