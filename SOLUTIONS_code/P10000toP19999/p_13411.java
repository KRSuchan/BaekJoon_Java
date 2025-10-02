package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_13411 {
    //    p_13411 : 하늘에서 정의가 빗발친다!
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Robot[] robots = new Robot[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            robots[i] = new Robot(i, x, y, v);
        }
        Arrays.sort(robots, ((o1, o2) -> {
            if (o1.time == o2.time) return Integer.compare(o1.id, o2.id);
            return Double.compare(o1.time, o2.time);
        }));
        for (int i = 0; i < N; i++) {
            System.out.println(robots[i].id + 1);
        }
    }

    static class Robot {
        int id;
        double time;

        public Robot(int id, int x, int y, int v) {
            this.id = id;
            this.time = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / v;
        }
    }
}
