package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1015 {
    //    p_1015 : 수열 정렬
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] origin = new int[N];
        boolean[] flags = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            origin[i] = value;
        }
        Arrays.sort(arr);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!flags[j] && origin[j] == arr[i]) {
                    result[j] = i;
                    flags[j] = true;
                    origin[j] = -1;
                    break;
                }
            }
        }
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
