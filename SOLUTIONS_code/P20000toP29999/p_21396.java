package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p_21396 {
    //    p_21396 : 이진수 더하기
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            HashMap<Long, Integer> v = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long value = Integer.parseInt(st.nextToken());
                v.put(value, v.getOrDefault(value, 0) + 1);
            }

            long cnt = 0;
            if (x == 0) {
                for (long k : v.keySet()) {
                    long c = v.get(k);
                    cnt += c * (c - 1);
                }
            } else {
                for (long k : v.keySet()) {
                    long a = v.get(k);
                    long b = v.getOrDefault(k ^ x, 0);
                    cnt += a * b;
                }
            }
            sb.append(cnt / 2).append('\n');
        }
        System.out.print(sb);
    }
}
