package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14563 {
    //    p_14563 : 완전수
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int value = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = 1; j < value; j++) {
                if (value % j == 0) {
                    sum += j;
                    if (sum > value) {
                        break;
                    }
                }
            }
            if (sum == value) {
                System.out.println("Perfect");
            } else if (sum > value) {
                System.out.println("Abundant");
            } else {
                System.out.println("Deficient");
            }
        }
    }
}
