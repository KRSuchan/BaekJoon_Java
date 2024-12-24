package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1263 {
    //    p_1263 : 시간 관리
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] timetable = new boolean[1_000_001];
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = s;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        boolean check = false;
        for (int i = 0; i < N; i++) {
            int t = arr[i][0];
            int s = arr[i][1];
            for (int j = 0, idx = s; j < t; j++, idx--) {
                while (timetable[idx]) {
                    idx--;
                    if (idx < 0) {
                        check = true;
                        break;
                    }
                }
                timetable[idx] = true;
                if (idx == 0) {
                    check = true;
                    break;
                }
            }
            if (check) break;
        }
        for (int i = 0; i < 1_000_001; i++) {
            if (timetable[i]) {
                System.out.println(i - 1);
                break;
            }
        }
    }
}
