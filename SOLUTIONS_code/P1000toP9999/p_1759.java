package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_1759 {
    //    p_1759 : 암호 만들기
    static StringBuilder sb = new StringBuilder();
    static int c, l;
    static char[] arr, code;

    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st1 = new StringTokenizer(br.readLine());
        var st2 = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st1.nextToken());
        c = Integer.parseInt(st1.nextToken());
        code = new char[l];
        arr = new char[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st2.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int x, int idx) {
        if (idx == l) {
            if (isValid()) {
                sb.append(code).append("\n");
            }
            return;
        }

        for (int i = x; i < c; i++) {
            code[idx] = arr[i];
            dfs(i + 1, idx + 1);
        }
    }

    private static boolean isValid() {
        int moum = 0;
        int jaum = 0;
        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                moum++;
            } else {
                jaum++;
            }
        }
        return moum >= 1 && jaum >= 2;
    }
}
