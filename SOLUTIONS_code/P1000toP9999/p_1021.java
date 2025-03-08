package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p_1021 {
    //    p_1021 : 회전하는 큐
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st1 = new StringTokenizer(br.readLine());
        var st2 = new StringTokenizer(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();
        int cnt = 0;
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        // 찾는 값과 중간값을 비교해서 less poll하는 방법으로..
        for (int i = 0; i < M; i++) {
            int target_idx = deque.indexOf(arr[i]);
            int half_idx;
            if (deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }
            if (target_idx <= half_idx) {
                // 2번
                for (int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    cnt++;
                }
            } else {
                // 3번
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
