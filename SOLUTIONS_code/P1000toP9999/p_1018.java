package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.StringTokenizer;

public class p_1018 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[height][width];
        boolean[][] newBoard = new boolean[8][8];
        int whiteMin = 0;
        int blackMin = 0;
        String s="";
        int min = 64;

        // board initialize
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            // B칸이면 true, W칸이면 false
            for (int j = 0; j < width; j++) {
                if (s.charAt(j)=='B' || s.charAt(j)=='b') board[i][j]=true;
                else board[i][j]=false;
            }
        }

        // board search
        for (int i = 0; i < height-7; i++) {
            for (int j = 0; j < width-7; j++) {
                // divide board to 8x8
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        newBoard[k][l]=board[k+i][l+j];
                    }
                }
                whiteMin = getMin(newBoard);
                blackMin = getReverseMin(newBoard);
                // 최소값 변환
                if (whiteMin<=blackMin && whiteMin<=min) min = whiteMin;
                else if(blackMin<=whiteMin && blackMin<=min) min = blackMin;
            }
        }
        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }
    public int getMin(boolean[][] board){
        // 좌상단이 B칸이고 자릿수합이 짝수인 칸이 B가 아니면 최소값++
        int curMin = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j)%2==0 && !board[i][j]){
                    curMin++;
                }else if ((i+j)%2!=0 && board[i][j]){
                    curMin++;
                }
            }
        }
        return curMin;
    }
    public int getReverseMin(boolean[][] board){
        // 좌상단이 W칸이고 자릿수 합이 짝수인 칸이 W가 아니면 최소값++
        int curMin = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j)%2==0 && board[i][j]){
                    curMin++;
                }else if ((i+j)%2!=0 && !board[i][j]){
                    curMin++;
                }
            }
        }
        return curMin;
    }
}
