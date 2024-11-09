package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_10707 {
    //    p_10707 : 수도요금
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int x_per_cost = Integer.parseInt(br.readLine());
        int y_base = Integer.parseInt(br.readLine());
        int y_limit = Integer.parseInt(br.readLine());
        int y_add = Integer.parseInt(br.readLine());
        int water = Integer.parseInt(br.readLine());
        int a = water * x_per_cost;
        int b = water <= y_limit ? y_base : y_base + (water - y_limit) * y_add;
        System.out.println(Math.min(a, b));
    }
}
