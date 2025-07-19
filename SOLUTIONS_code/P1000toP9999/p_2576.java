package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p_2576 {
    //    p_2576 : 홀수
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> odds = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 != 0) {
                sum += num;
                odds.add(num);
            }
        }
        if (odds.isEmpty())
            System.out.println(-1);
        else {
            Collections.sort(odds);
            System.out.println(sum);
            System.out.println(odds.get(0));
        }
    }
}
