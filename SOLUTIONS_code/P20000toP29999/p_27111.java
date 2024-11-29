package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p_27111 {
    //    p_27111 : 출입 기록
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> status = new HashMap<>();
        int rec = 0;
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());
            int action = Integer.parseInt(st.nextToken());

            if (action == 1) { // 들어옴
                if (status.getOrDefault(person, 0) == 1) {
                    // 들어왔는데 들어온 경우
                    rec++;
                }
                status.put(person, 1); // 들어온 사람 기록
            } else { // 나감
                if (status.getOrDefault(person, 0) == 0) {
                    // 안 들어왔는데 나간 경우
                    rec++;
                }
                status.put(person, 0);
            }
        }
        for (int v : status.values()) {
            if (v == 1) rec++;
        }
        System.out.println(rec);
    }
}
