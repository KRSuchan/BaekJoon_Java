package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2520 {
    //    p_2520 : 팬케이크 사랑
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            var st = new StringTokenizer(br.readLine());
            double cm = Double.parseDouble(st.nextToken()) / 8;
            double y = Double.parseDouble(st.nextToken()) / 8;
            double su = Double.parseDouble(st.nextToken()) / 4;
            double sa = Double.parseDouble(st.nextToken());
            double f = Double.parseDouble(st.nextToken()) / 9;
            int dough = (int) (Math.min(cm, Math.min(y, Math.min(su, Math.min(sa, f)))) * 16);
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int gs = Integer.parseInt(st.nextToken()) / 30;
            int gc = Integer.parseInt(st.nextToken()) / 25;
            int w = Integer.parseInt(st.nextToken()) / 10;
            int topping = b + gs + gc + w;
            sb.append(Math.min(dough, topping)).append("\n");
        }
        System.out.println(sb);
    }
}
