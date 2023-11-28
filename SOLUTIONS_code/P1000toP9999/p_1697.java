package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.LinkedList;

public class p_1697 {
    int N;
    int K;
    int visited[] = new int[100001];

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] inputs = s.split(" ");

        N = Integer.parseInt(inputs[0]); // 나의 위치
        K = Integer.parseInt(inputs[1]); // 너의 위치

        int result = BFS(N); // 결과

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS(int s) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(s);
        int idx = s;
        int n = 0;
        visited[idx] = 1;

        while (!queue.isEmpty()) {
            n = queue.remove();
            if (n == K) { // 찾았다.
                return visited[n] - 1;
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) { // n-1이 범위 내 && 방문 여부
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 <= 100000 && visited[n + 1] == 0) { // n+1이 범위 내 && 방문 여부
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (n * 2 <= 100000 && visited[2 * n] == 0) { // n+1이 범위 내 && 방문 여부
                visited[2 * n] = visited[n] + 1;
                queue.add(2 * n);
            }
        }
        return -1;
    }
}