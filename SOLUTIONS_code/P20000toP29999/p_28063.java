package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_28063 {
    //    p_28063 : 동전 복사
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int times;
        if (n == 1) times = 0;
        else if ((x == n && y == n) || (x == 1 && y == n) || (x == n && y == 1) || (x == 1 && y == 1)) times = 2;
        else if (x == 1 || y == 1 || x == n || y == n) times = 3;
        else times = 4;
        System.out.println(times);
    }
}
