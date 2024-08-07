package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p_1991 {
    //    p_1991 : 트리 순회
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Character[]> map;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            map.put(parent, new Character[]{st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }
        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        System.out.print(sb);
    }

    public static void preorder(char key) throws IOException {
        if (key == '.') return;
        sb.append(key);
        preorder(map.get(key)[0]);
        preorder(map.get(key)[1]);
    }

    public static void inorder(char key) throws IOException {
        if (key == '.') return;
        inorder(map.get(key)[0]);
        sb.append(key);
        inorder(map.get(key)[1]);
    }

    public static void postorder(char key) throws IOException {
        if (key == '.') return;
        postorder(map.get(key)[0]);
        postorder(map.get(key)[1]);
        sb.append(key);
    }
}
