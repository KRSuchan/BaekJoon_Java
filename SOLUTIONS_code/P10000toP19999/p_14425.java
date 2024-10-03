package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class p_14425 {
    //    p_14425 : 문자열 집합
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            treeMap.put(br.readLine(), i);
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            Integer x = treeMap.getOrDefault(br.readLine(), -1);
            if (x > -1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
