package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p_25192 {
    //    p_25192 : 인사성 밝은 곰곰이
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> list = new HashSet<>();
        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String log = br.readLine();
            if (log.equals("ENTER")) {
                list = new HashSet<>();
                flag = true;
            } else if (flag && !list.contains(log)) {
                cnt++;
                list.add(log);
            }
        }
        System.out.println(cnt);
    }
}
