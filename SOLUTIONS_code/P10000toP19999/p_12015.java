package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_12015 {
    //    p_12015 : 가장 긴 증가하는 부분 수열 2
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] res = new int[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        res[0] = A[0];
        int idx = 1;
        for (int i = 1; i < N; i++) {
            if (res[idx - 1] < A[i]) {
                idx++;
                res[idx - 1] = A[i];
            } else {
                int lo = 0;
                int hi = idx;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (res[mid] >= A[i]) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                res[lo] = A[i];
            }
        }
        System.out.println(idx);
    }
}
