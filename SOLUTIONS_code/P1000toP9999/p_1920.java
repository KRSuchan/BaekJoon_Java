package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_1920 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        int[] numbers = new int[times];
        int number = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        // 정수 입력
        for (int i = 0; i < times; i++) {
            numbers[i]=Integer.parseInt(st.nextToken());
        }
        int cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        // 정수 탐색
        for (int i = 0; i < cnt; i++) {
            number = Integer.parseInt(st.nextToken());
            bw.write(isExist(numbers,number)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public int isExist(int[] numbers, int number){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) return 1;
        }
        return 0;
    }
}
