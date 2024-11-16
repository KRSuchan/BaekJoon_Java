package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p_2628 {
    //    p_2628 : 종이자르기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        ArrayList<Integer> ws = new ArrayList<>();
        ArrayList<Integer> hs = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) {
                hs.add(Integer.parseInt(st.nextToken()));
            } else {
                ws.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(ws);
        Collections.sort(hs);
        ws.add(width);
        hs.add(height);
        int tw = 0;
        int max = 0;
        for (int w : ws) {
            int dw = w - tw;
            int th = 0;
            for (int h : hs) {
                int dh = h - th;
                max = Math.max(max, dw * dh);
                th = h;
            }
            tw = w;
        }

        System.out.println(max);
    }
}
