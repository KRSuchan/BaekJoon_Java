package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_26041 {
    //    p_26041 : 비슷한 전화번호 표시
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String B = br.readLine();
        int res = 0;
        while (st.hasMoreTokens()) {
            String tel = st.nextToken();
            if (tel.equals(B))
                continue;
            for (int i = 0; i < tel.length(); i++) {
                String prefix = tel.substring(0, i);
                if (prefix.equals(B)) {
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
