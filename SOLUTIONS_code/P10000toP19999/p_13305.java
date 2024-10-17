package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p_13305 {
    //    p_13305 : 주유소
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        long[] distance = new long[N];
        long[] prices = new long[N];
        City[] cities = new City[N];
        int total = 0;
        for (int i = 1; i < N; i++) {
            int dist = Integer.parseInt(st.nextToken());
            distance[i] = distance[i - 1] + dist;
            total += dist;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            cities[i] = new City(prices[i], total - distance[i]);
        }

        Arrays.sort(cities, Comparator.comparingLong(o -> o.cost));
        long move = 0;
        long res = 0;
        for (int i = 0; i < N; i++) {
            City city = cities[i];
            long d;
            if ((d = city.dist - move) > 0) {
                res += d * city.cost;
                move += d;
            }
        }
        System.out.println(res);
    }

    static class City {
        long cost;
        long dist;

        public City(long cost, long dist) {
            this.cost = cost;
            this.dist = dist;
        }

    }
}
