package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_2587 {
    //    p_2587 : 대표값2
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int average = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            average += x;
        }
        Arrays.sort(arr);
        System.out.println(average / 5);
        System.out.println(arr[2]);
    }
}
