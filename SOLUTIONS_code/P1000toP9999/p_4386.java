package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_4386 {
    //    p_4386 : 별자리 만들기
    static ArrayList<Star> stars;
    static int[] parent;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            var st = new StringTokenizer(br.readLine());
            stars.add(new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }
        double result = kruskal();
        System.out.printf("%.2f", result);
    }

    public static double kruskal() {
        PriorityQueue<Distance> q = new PriorityQueue<>();
        for (int i = 0; i < stars.size(); i++) {
            for (int j = i + 1; j < stars.size(); j++) {
                double dist = Math.sqrt(Math.pow(stars.get(i).x - stars.get(j).x, 2) + Math.pow(stars.get(i).y - stars.get(j).y, 2));
                q.add(new Distance(i, j, dist));
            }
        }
        parent = new int[stars.size()];
        for (int i = 0; i < stars.size(); i++) {
            parent[i] = i;
        }
        double total = 0;
        while (!q.isEmpty()) {
            Distance cur = q.poll();
            int star1 = find(cur.from);
            int star2 = find(cur.to);
            if (star1 != star2) {
                union(star1, star2);
                total += cur.dist;
            }
        }
        return total;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        parent[y] = x;
    }

    static class Distance implements Comparable<Distance> {
        int from;
        int to;
        double dist;

        public Distance(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Distance o) {
            if (this.dist < o.dist) return -1;
            return 1;
        }
    }

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
