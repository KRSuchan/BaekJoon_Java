package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1865 {
    //    p_1865 : 웜홀
    static final int INF = 987654321;

    static int N, M, W;
    static ArrayList<ArrayList<Path>> paths;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            paths = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                paths.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) { // 도로 놓기
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                paths.get(S).add(new Path(E, T));
                paths.get(E).add(new Path(S, T));
            }
            for (int i = 0; i < W; i++) { // 웜홀 놓기
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                paths.get(S).add(new Path(E, -T));
            }
            sb.append(bellmanFord() ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    public static boolean bellmanFord() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update = false;
        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
                for (Path path : paths.get(j)) {
                    if (dist[path.e] > dist[j] + path.w) {
                        dist[path.e] = dist[j] + path.w;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Path path : paths.get(i)) {
                    if (dist[path.e] > dist[i] + path.w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Path {
        int e, w;

        Path(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}
