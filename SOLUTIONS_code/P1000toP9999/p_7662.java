package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class p_7662 {
    //    p_7662 : 이중 우선순위 큐
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>(); // <값, 개수>
            for (int j = 0; j < k; j++) {
                String[] s = br.readLine().split(" ");
                char c = s[0].charAt(0);
                int a = Integer.parseInt(s[1]);

                if (c == 'I') { // insert 연산
                    map.put(a, map.getOrDefault(a, 0) + 1);
                } else { // delete 연산
                    if (map.isEmpty()) continue;
                    int num = (a == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(num) == 1) {
                        map.remove(num);
                    } else {
                        map.put(num, map.get(num) - 1);
                    }
                }
            }
            System.out.println(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
}
