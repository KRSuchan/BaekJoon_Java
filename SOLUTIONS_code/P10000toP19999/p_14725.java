package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class p_14725 {
    //    p_14725 : 개미굴
    static StringBuilder sb = new StringBuilder();

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node("");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < K; j++) {
                String str = st.nextToken();
                cur = cur.children.computeIfAbsent(str, Node::new);
            }
        }

        preOrder(root, 0);
        System.out.println(sb);
    }

    private static void preOrder(Node node, int depth) {
        for (String key : node.children.keySet()) {
            sb.append("--".repeat(Math.max(0, depth)));
            sb.append(key).append("\n");
            preOrder(node.children.get(key), depth + 1);
        }
    }

    static class Node {
        String value;
        TreeMap<String, Node> children = new TreeMap<>();

        public Node(String str) {
            this.value = str;
        }
    }
}
