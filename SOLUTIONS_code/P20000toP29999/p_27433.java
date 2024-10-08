package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_27433 {
    //    p_27433 : 팩토리얼 2
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorial(Integer.parseInt(br.readLine())));
    }

    private static long factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }
}
