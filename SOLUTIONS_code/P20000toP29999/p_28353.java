package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_28353 {
    //    p_28353 : 고양이 카페
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cats = new int[N];
        for (int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cats);
        int cnt = 0;
        int min = cats[0];
        int max = cats[N - 1];
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int sum = min + max;
            if (sum > K) {
                max = cats[j--];
            } else {
                min = cats[i++];
                max = cats[j--];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
