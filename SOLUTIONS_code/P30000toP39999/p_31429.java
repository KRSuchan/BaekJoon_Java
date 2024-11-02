package SOLUTIONS_code.P30000toP39999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_31429 {
    //    p_31429 : SUAPC 2023 Summer
    public static void solution(String[] args) throws IOException {
        int[][] arr = {
                {},
                {12, 1600},
                {11, 894},
                {11, 1327},
                {10, 1311},
                {9, 1004},
                {9, 1178},
                {9, 1357},
                {8, 837},
                {7, 1055},
                {6, 556},
                {6, 773}
        };
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(arr[n][0]).append(" ").append(arr[n][1]);
        System.out.println(sb);
    }
}
