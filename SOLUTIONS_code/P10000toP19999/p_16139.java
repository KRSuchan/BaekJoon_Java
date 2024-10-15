package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_16139 {
    //    p_16139 : 인간-컴퓨터 상호작용
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] alphabet = new int[S.length() + 1][26];
        for (int i = 1; i <= S.length(); i++) {
            int idx = S.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                alphabet[i][j] = (j == idx) ? alphabet[i - 1][j] + 1 : alphabet[i - 1][j];
            }
        }
        var sb = new StringBuilder();
        while (q-- > 0) {
            var st = new StringTokenizer(br.readLine());
            int alph = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(alphabet[r + 1][alph] - alphabet[l][alph]).append("\n");
        }
        System.out.print(sb);
    }
}
