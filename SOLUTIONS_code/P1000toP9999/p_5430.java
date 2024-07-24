package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p_5430 {
    //    p_5430 : AC
    static ArrayDeque<String> arr = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static boolean isLeft;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            // input
            String f = br.readLine(); // function
            int n = Integer.parseInt(br.readLine()); // arr length
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, "[],");
            arr = new ArrayDeque<>(); // array
            for (int j = 0; j < n; j++) {
                arr.add(st.nextToken());
            }

            boolean check = true;
            isLeft = true;
            // alg
            int times = f.length();
            for (int j = 0; j < times; j++) {
                if (f.charAt(j) == 'R') {
                    isLeft = !isLeft;
                } else if (f.charAt(j) == 'D' && !arr.isEmpty()) {
                    D();
                } else {
                    sb.append("error\n");
                    check = false;
                    break;
                }
            }

            // output
            if (check && isLeft) {
                sb.append("[");
                int cnt = arr.size();
                for (int j = 0; j < cnt; j++) {
                    sb.append(arr.pollFirst());
                    if (!arr.isEmpty())
                        sb.append(",");
                }
                sb.append("]\n");
            } else if (check) {
                sb.append("[");
                int cnt = arr.size();
                for (int j = 0; j < cnt; j++) {
                    sb.append(arr.pollLast());
                    if (!arr.isEmpty())
                        sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }

    public void D() {
        if (isLeft) {
            arr.removeFirst();
        } else {
            arr.removeLast();
        }
    }
}
