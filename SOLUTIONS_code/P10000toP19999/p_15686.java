package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_15686 {
    //    p_15686 : 치킨 배달
    static final int B = 0, H = 1, C = 2; // blank, house, chicken
    static int n, m;
    static ArrayList<Pos> house, chicken;
    static int ans;
    static boolean[] visited;

    public static void solution(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == H) house.add(new Pos(i, j));
                else if (map[i][j] == C) chicken.add(new Pos(i, j));
            }
        }
        // alg
        ans = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        //output
        System.out.println(ans);
    }

    private static void dfs(int start, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        tmp = Math.min(tmp, dist);
                    }
                }
                sum += tmp;
            }
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
