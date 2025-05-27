package SOLUTIONS_code.P1000toP9999;

import java.io.IOException;

public class p_4673 {
    //    p_4673 : 셀프 넘버
    public static void solution(String[] args) throws IOException {
        boolean[] isSelfNum = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int n = d(i);
            if (n <= 10000) {
                isSelfNum[n] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!isSelfNum[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
