package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.Arrays;

public class p_2108 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mid = 0;
        int mod = 0;
        int[] arr = new int[cnt];
        int num = 0;

        // 총합계, 최대, 최소 구하기

        for (int i = 0; i < cnt; i++) {
            num = Integer.parseInt(br.readLine());
            sum+= num;
            arr[i] = num;
            if (num < min) min = num;
            if (max < num) max = num;
        }
        Arrays.sort(arr);
        // 중앙값 구하기
        mid = arr[cnt/2];

        // 최빈값 구하기
        int maxCnt = 1;
        int curCnt = 1;
        mod = arr[0];
        boolean flag = true;
        for (int i = 1; i < cnt; i++) {
            if (arr[i-1] == arr[i]) {
                curCnt++;
            }
            else curCnt = 1;
            if (curCnt>maxCnt) {
                maxCnt = curCnt;
                mod = arr[i];
                flag = true;
            }else if (curCnt==maxCnt && flag){
                mod = arr[i];
                flag = false;
            }
        }

        bw.write((int) Math.round((double) sum/cnt)+"\n"); // 산술평균
        bw.write(mid+"\n"); // 중앙값
        bw.write(mod+"\n"); // 최빈값
        bw.write(max-min+"\n"); // 범위

        bw.flush();
        bw.close();
        br.close();
    }
}
