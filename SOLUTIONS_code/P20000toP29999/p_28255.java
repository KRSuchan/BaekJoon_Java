package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_28255 {
    //    p_28255 : 3단 초콜릿 아이스크림
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String S = br.readLine();
            int length = S.length() % 3 == 0 ? S.length() / 3 : S.length() / 3 + 1;
            String Sp = S.substring(0, length);
            if (S.equals(Sp + rev(Sp) + Sp)
                    || S.equals(Sp + tail(rev(Sp)) + Sp)
                    || S.equals(Sp + rev(Sp) + tail(Sp))
                    || S.equals(Sp + tail(rev(Sp)) + tail(Sp))
            ) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static String rev(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String tail(String str) {
        return str.substring(1);
    }
}
