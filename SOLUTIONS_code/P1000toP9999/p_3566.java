package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3566 {
    //    p_3566 : 대형 스크린
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rh = Integer.parseInt(st.nextToken());
        int rv = Integer.parseInt(st.nextToken());
        int sh = Integer.parseInt(st.nextToken());
        int sv = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int price = 987654321;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int rhi = Integer.parseInt(st.nextToken());
            int rvi = Integer.parseInt(st.nextToken());
            int shi = Integer.parseInt(st.nextToken());
            int svi = Integer.parseInt(st.nextToken());
            int pi = Integer.parseInt(st.nextToken());

            int h = (int) Math.max(Math.ceil((double) rh / rhi), Math.ceil((double) sh / shi));
            int v = (int) Math.max(Math.ceil((double) rv / rvi), Math.ceil((double) sv / svi));
            price = Math.min(price, h * v * pi);

            h = (int) Math.max(Math.ceil((double) rh / rvi), Math.ceil((double) sh / svi));
            v = (int) Math.max(Math.ceil((double) rv / rhi), Math.ceil((double) sv / shi));
            price = Math.min(price, h * v * pi);
        }
        System.out.println(price);
    }
}
