package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class p_26150 {
    //    p_26150 : Identify, Sort, Index, Solve
    public static void main(String[] args) throws IOException {
        // input & sort
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Problem> problems = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int I = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            problems.put(I, new Problem(title, D));
        }
        // Index & Solve
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            Problem p = problems.remove(problems.firstKey());
            ans[i] = p.title.toUpperCase().charAt(p.difficulty - 1);
        }
        System.out.println(ans);
    }

    static class Problem {
        String title;
        int difficulty;

        Problem(String title, int difficulty) {
            this.title = title;
            this.difficulty = difficulty;
        }
    }
}
