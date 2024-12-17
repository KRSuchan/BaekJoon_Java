package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p_1174 {
    //    p_1174 : 줄어드는 수
    static ArrayList<Long> list = new ArrayList<>();

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        try {
            for (int i = 0; i < 10; i++) {
                dfs(i);
            }
            Collections.sort(list);
            System.out.println(list.get(N - 1));
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

    private static void dfs(long n) {
        list.add(n);
        long modNum = n % 10;
        if (modNum == 0) {
            return;
        }
        for (long i = modNum - 1; i >= 0; i--) {
            dfs((n * 10) + i);
        }
    }
}
