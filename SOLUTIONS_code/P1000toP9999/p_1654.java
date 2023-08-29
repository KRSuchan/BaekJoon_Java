package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_1654 {

    int need;
    long max = 0;
    int[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        need = Integer.parseInt(st.nextToken());
        max = 0;
        long end = 0;
        arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (end<arr[i]) end = arr[i];
        }

        long start = 0;
        max = end;

        end++;
        // 이진 탐색
        while(start+1 < end){
            long mid = (start+end) / 2;
            if (checkCutting(mid)){
                start = mid;
            } else {
                end = mid;
            }
        }
        // 따로 저장했던 필요 개수 값 출력
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }

    // 매개 변수 탐색
    public boolean checkCutting(long height){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]/height;
        }
        // 필요 개수가 합과 크거나 같으면 별도로 저장
        if (sum >= need) {
            max = height;
            return true;
        }
        else return false;
    }
}
