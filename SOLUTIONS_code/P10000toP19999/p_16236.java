package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_16236 {
    //    p_16236 : 아기 상어
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] shark = null;
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }
        int size = 2;
        int eat = 0;
        int move = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ?
                            Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ?
                            Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visited = new boolean[N][N];
            pq.add(new int[]{shark[0], shark[1], 0});
            visited[shark[0]][shark[1]] = true;

            boolean check = false; // 먹이가 먹혔는가?
            while (!pq.isEmpty()) {
                shark = pq.poll();

                if (map[shark[0]][shark[1]] != 0 && map[shark[0]][shark[1]] < size) {
                    // 먹이가 있고 size가 작다면 먹는다
                    map[shark[0]][shark[1]] = 0;
                    eat++;
                    move += shark[2];
                    check = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = shark[0] + dx[i];
                    int ny = shark[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > size) {
                        continue;
                    }
                    pq.offer(new int[]{nx, ny, shark[2] + 1});
                    visited[nx][ny] = true;
                }
            }
            if (!check) {
                break;
            }
            if (size == eat) {
                size++;
                eat = 0;
            }
        }
        System.out.println(move);
    }
}
