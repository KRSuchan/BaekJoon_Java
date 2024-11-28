package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p_1268 {
    //    p_1268 : 임시 반장 정하기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> rel = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[i][j] == arr[k][j] && i != k) {
                        rel.add(k);
                    }
                }
            }
            if (rel.size() > max) {
                res = i;
                max = rel.size();
            }
        }
        System.out.println(res + 1);
    }
}
