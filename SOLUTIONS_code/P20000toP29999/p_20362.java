package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class p_20362 {
    //    p_20362 : 유니대전 퀴즈쇼
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String S = st.nextToken();
        String answer = "";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nickname = st.nextToken();
            String log = st.nextToken();
            if (nickname.equals(S)) {
                answer = log;
                break;
            } else {
                map.put(log, map.getOrDefault(log, 0) + 1);
            }
        }
        System.out.println(map.getOrDefault(answer, 0));
    }
}
