package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class p_2667 {
    //    p_2667 : 단지번호붙이기
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> nums;

    public void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    cnt++;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        nums.add(cnt);
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '0') {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(nums);
        int size = nums.size();
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(nums.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}