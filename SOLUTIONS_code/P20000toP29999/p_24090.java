package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_24090 {
    //    p_24090 : 알고리즘 수업 - 퀵 정렬 1
    static int[] arr;
    static int cnt = 0;
    static int res1;
    static int res2;
    static int K;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st1 = new StringTokenizer(br.readLine());
        var st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        K = Integer.parseInt(st1.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        quick_sort(0, N - 1);
        StringBuilder sb = new StringBuilder();
        if (cnt < K) {
            sb.append(-1);
        } else {
            sb.append(res1).append(" ").append(res2);
        }
        System.out.println(sb);
    }

    private static void quick_sort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quick_sort(p, q - 1);
            quick_sort(q + 1, r);
        }
    }

    public static int partition(int p, int r) {
        int x = arr[r];
        int i = p - 1;
        if (K == cnt) return p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                int tmp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = tmp;
                i++;
                cnt++;
                if (K == cnt) {
                    res1 = arr[i];
                    res2 = arr[j];
                    break;
                }
            }
        }
        if (i + 1 != r && K != cnt) {
            int tmp = arr[i + 1];
            arr[i + 1] = arr[r];
            arr[r] = tmp;
            cnt++;
            if (K == cnt) {
                res1 = arr[i + 1];
                res2 = arr[r];
            }
        }
        return i + 1;
    }
}
