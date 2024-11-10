package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2597 {
    //    p_2597 : 줄자접기
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        double len = Integer.parseInt(br.readLine());
        var st = new StringTokenizer(br.readLine());
        double[] red = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
        };
        st = new StringTokenizer(br.readLine());
        double[] blue = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
        };
        st = new StringTokenizer(br.readLine());
        double[] yellow = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
        };
        double r = red[0] == red[1] ? 0 : (red[0] + red[1]) / 2;
        len = Math.max(r, len - r);
        blue[0] = Math.abs(blue[0] - r);
        blue[1] = Math.abs(blue[1] - r);
        yellow[0] = Math.abs(yellow[0] - r);
        yellow[1] = Math.abs(yellow[1] - r);
        double b = blue[0] == blue[1] ? 0 : (blue[0] + blue[1]) / 2;
        len = Math.max(b, len - b);
        yellow[0] = Math.abs(yellow[0] - b);
        yellow[1] = Math.abs(yellow[1] - b);
        double y = yellow[0] == yellow[1] ? 0 : (yellow[0] + yellow[1]) / 2;
        len = Math.max(y, len - y);
        System.out.println(len);
    }
}
