package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3135 {
    //    p_3135 : 라디오
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int likes = Integer.parseInt(br.readLine());

        // A ➡️ B 거리보다 즐찾 ➡️ B 거리+1이 작으면 후자 값이 최소 거리
        int dist = Math.abs(A - B);
        for (int i = 0; i < likes; i++) {
            int likeDist = Math.abs(Integer.parseInt(br.readLine()) - B) + 1;
            if (dist > likeDist) {
                dist = likeDist;
            }
        }

        // 출력
        System.out.println(dist);
    }
}
