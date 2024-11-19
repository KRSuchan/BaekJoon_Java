package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_16471 {
    //    p_16471 : 작은 수 내기
    static int N;

    static int[] ju, master;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        var st1 = new StringTokenizer(br.readLine());
        var st2 = new StringTokenizer(br.readLine());
        ju = new int[N];
        master = new int[N];
        for (int i = 0; i < N; i++) {
            ju[i] = Integer.parseInt(st1.nextToken());
            master[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(ju);
        Arrays.sort(master);

        System.out.println(greed() ? "YES" : "NO");
    }

    private static boolean greed() {
        int cnt = 0;
        int std = N / 2 + 1;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (cnt >= std) return true;
            for (int j = idx; j < N; j++) {
                if (ju[i] < master[j]) {
                    cnt++;
                    idx = j + 1;
                    break;
                }
            }
        }
        return cnt >= std;
    }
}
