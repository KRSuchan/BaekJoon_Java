package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_5639 {
    //    p_5639 : 이진 검색 트리
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty())
                break;
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }


    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        void insert(int v) {
            if (v < value) {
                if (left == null)
                    left = new Node(v);
                else
                    left.insert(v);
            } else {
                if (right == null)
                    right = new Node(v);
                else
                    right.insert(v);
            }
        }
    }
}
