package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_14649 {
    //    p_14649 : 문홍안
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double P = Double.parseDouble(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());
        int[] steps = new int[100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            if (dir == 'R')
                for (int j = idx; j < 100; j++) steps[j]++;
            else  // 'L'
                for (int j = idx - 2; j >= 0; j--) steps[j]++;
        }

        int[] count = new int[3]; // blue : 0, red : 1, green : 2
        for (int c : steps) count[c % 3]++;

        double blue = P * count[0] / 100.0;
        double red = P * count[1] / 100.0;
        double green = P * count[2] / 100.0;
        System.out.printf("%.2f\n%.2f\n%.2f", blue, red, green);
    }
}
