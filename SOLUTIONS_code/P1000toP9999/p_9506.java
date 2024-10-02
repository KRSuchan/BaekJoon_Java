package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p_9506 {
    //    p_9506 : 약수들의 합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list;
        StringBuilder sb = new StringBuilder();
        while (n != -1) {
            sb.append(n);
            list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }
            if (sum == n) {
                sb.append(" = ");
                sb.append(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    sb.append(" + ").append(list.get(i));
                }
                sb.append("\n");
            } else {
                sb.append(" is NOT perfect.\n");
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
