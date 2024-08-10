package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11800 {
    //    p_11800 : Tawla
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append("Case ").append(i).append(": ");
            if ((a == 5 && b == 6) || (a == 6 && b == 5)) {
                sb.append("Sheesh Beesh");
            } else if (a > b) {
                comment(a);
                comment(b);
            } else if (a == b) {
                comment(a, b);
            } else {
                comment(b);
                comment(a);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void comment(int a) {
        switch (a) {
            case 1:
                sb.append("Yakk");
                break;
            case 2:
                sb.append("Doh");
                break;
            case 3:
                sb.append("Seh");
                break;
            case 4:
                sb.append("Ghar");
                break;
            case 5:
                sb.append("Bang");
                break;
            case 6:
                sb.append("Sheesh");
                break;
        }
        sb.append(" ");
    }

    private static void comment(int a, int b) {
        switch (a) {
            case 1:
                sb.append("Habb Yakk");
                break;
            case 2:
                sb.append("Dobara");
                break;
            case 3:
                sb.append("Dousa");
                break;
            case 4:
                sb.append("Dorgy");
                break;
            case 5:
                sb.append("Dabash");
                break;
            case 6:
                sb.append("Dosh");
                break;
        }
    }
}
