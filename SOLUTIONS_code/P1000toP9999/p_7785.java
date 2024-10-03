package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class p_7785 {
    //    p_7785 : 회사에 있는 사람
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String enterLeave = st.nextToken();
            if (enterLeave.equals("enter")) {
                map.put(name, map.getOrDefault(name, 0));
            } else {
                map.remove(name);
            }
        }
        for (int i = 0, size = map.size(); i < size; i++) {
            String x = map.lastKey();
            System.out.println(x);
            map.remove(x);
        }
    }
}
