package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_1929 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        boolean[] array = new boolean[max+1];
        array[0] = false;
        array[1] = false;
        for (int i = 2; i <= max; i++) {
            array[i] = true;
        }

        // 에라토스테네스의 체 : i*i<=max 의 경우
        // i보다 작은 수는 이미 소수로 처리되었기 때문에
        // i*i<=max 로 반복 횟수 최소화
        for (int i = 2; i*i <= max; i++) {
            if (array[i]) { // i*i부터 i 간격으로 소수 아닌 것 제거
                for (int j = i*i; j <= max; j+=i) {
                    array[j] = false;
                }
            }
        }
        for (int i = min; i <= max; i++) {
            if (array[i]) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
