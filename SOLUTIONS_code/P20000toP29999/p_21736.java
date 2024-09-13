package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_21736 {
    int n;
    int m;
    char[][] map;
    boolean[][] isVisited;
    int cnt = 0;

    private void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        isVisited[x][y] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !isVisited[nx][ny] && map[nx][ny] != 'X') {
                    q.add(new Node(nx, ny));
                    isVisited[nx][ny] = true;
                    if (map[nx][ny] == 'P') {
                        cnt++;
                    }
                }
            }
        }
    }

    // p_21736
    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        isVisited = new boolean[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'I') {
                    x = i;
                    y = j;
                    isVisited[i][j] = true;
                } else if (map[i][j] == 'X') {
                    isVisited[i][j] = true;
                }
            }
        }
        bfs(x, y);
        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

