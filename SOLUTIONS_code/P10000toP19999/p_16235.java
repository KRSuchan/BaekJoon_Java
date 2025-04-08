package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p_16235 {
    //    p_16235 : 나무 재테크
    static int N, M, K;
    static int[][] A, map;
    static ArrayList<Tree> trees, deadTrees;

    public static void solution(String[] args) throws IOException {

        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        trees = new ArrayList<>();              // 나무 맵
        deadTrees = new ArrayList<>();          // 죽은 나무 맵
        map = new int[N + 1][N + 1];      // 현재 양분 맵
        A = new int[N + 1][N + 1];              // 겨울 추가 양분 정보

        for (int i = 1; i <= N; i++) { // 추가 양분 정보 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) { // 나무 맵 초기화
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r, c, z));
        }

        trees.sort(Comparator.comparingInt(t -> t.age));

        while (K-- > 0) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(trees.size());

    }

    private static void spring() {
        // 양분 먹는 날
        ArrayList<Tree> temp = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.age > map[tree.r][tree.c]) {
                // 땅의 양분 < 나무 나이 then 죽은 나무
                deadTrees.add(tree);
            } else {
                //  아니면 나이 만큼 양분 먹기 & 나무 나이++
                map[tree.r][tree.c] -= tree.age;
                tree.age++;
                temp.add(tree);
            }
        }
        trees = temp; // 살아남은 나무로 초기화
    }

    private static void summer() {
        // 봄에 죽은 나무의 나이/2 만큼 양분 추가
        for (Tree tree : deadTrees) {
            map[tree.r][tree.c] += tree.age / 2;
        }
        deadTrees = new ArrayList<>(); // 초기화
    }

    private static void autumn() {
        // 나무의 나이가 5의 배수인 경우 인접 8칸에 나이 1인 나무 추가
        int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        ArrayList<Tree> newTrees = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = tree.r + dx[j];
                    int ny = tree.c + dy[j];
                    if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
                        newTrees.add(new Tree(nx, ny, 1));
                    }
                }
            }
        }
        newTrees.addAll(trees);
        trees = newTrees;
    }

    private static void winter() {
        // 겨울의 추가 양분 주기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += A[i][j];
            }
        }

    }

    static class Tree {
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }
}
