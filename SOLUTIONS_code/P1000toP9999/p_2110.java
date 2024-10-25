package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_2110 {
    //    p_2110 : 공유기 설치
    static int[] house;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        int low = 1;
        int high = house[N - 1] - house[0] + 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (cntInstall(mid) < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low - 1);
    }

    private static int cntInstall(int d) {
        int cnt = 1;
        int last = house[0];
        for (int i = 1; i < house.length; i++) {
            int cur = house[i];
            if (cur - last >= d) {
                cnt++;
                last = cur;
            }
        }
        return cnt;
    }
}
