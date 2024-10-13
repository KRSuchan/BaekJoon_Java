package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11054 {
    //    p_11054 : 가장 긴 바이토닉 부분 수열
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        var st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] increaseArr = new int[N];
        for (int i = 0; i < N; i++) {
            increaseArr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && increaseArr[i] < increaseArr[j] + 1) {
                    increaseArr[i] = increaseArr[j] + 1;
                }
            }
        }
        int[] decreaseArr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            decreaseArr[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && decreaseArr[i] < decreaseArr[j] + 1) {
                    decreaseArr[i] = decreaseArr[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, increaseArr[i] + decreaseArr[i]);
        }
        System.out.println(max - 1);
    }
}
