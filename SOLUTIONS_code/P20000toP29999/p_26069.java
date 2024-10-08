package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p_26069 {
    //    p_26069 : 붙임성 좋은 총총이
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (set.contains(a) || set.contains(b)) {
                set.add(a);
                set.add(b);
            }
        }
        System.out.println(set.size());
    }
}
