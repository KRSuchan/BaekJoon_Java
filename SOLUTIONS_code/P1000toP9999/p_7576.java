package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_7576 {
    static int n;
    static int m;
    static Tomato[][] board;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new Tomato[n][m];
//        board 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == -1){
                    board[i][j]= new Tomato(i, j,-1,true);
                } else if (status == 1) {
                    board[i][j]= new Tomato(i, j,1,true);
                    queue.add(board[i][j]);
                } else {
                    board[i][j]= new Tomato(i, j,0,false);
                }
            }
        }
        bfs();
        System.out.println(getDays());
    }
    private static int getDays(){
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j].day == 0) return -1;
                else if (board[i][j].day > max) max = board[i][j].day;
            }
        }
        return max-1;
    }
    private static void bfs() {
        int day = 0;
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            t.isVisited = true;
            day = t.day;
            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !board[nx][ny].isVisited && board[nx][ny].day == 0) {
                    board[nx][ny].day = day+1;
                    queue.add(board[nx][ny]);
                }
            }
        }
    }
}
class Tomato {
    int x;
    int y;
    int day;
    boolean isVisited;
    Tomato(int x, int y, int day, boolean isVisited) {
        this.x = x;
        this.y = y;
        this.day = day;
        this.isVisited = isVisited;
    }
}