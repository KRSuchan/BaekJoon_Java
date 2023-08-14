import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
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
      for (int j = 0; j < width; j++) {
        if (s.charAt(j)=='B') board[i][j]=true;
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
        if (whiteMin<blackMin && whiteMin<min) min = whiteMin;
        else if(blackMin<whiteMin && blackMin<min) min = blackMin;
      }
    }
    bw.write(min+"");
    bw.flush();
    bw.close();
    br.close();
  }
  public static int getMin(boolean[][] board){
    int curMin = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j]!=(i*j%2==0)) curMin++;
      }
    }
    return curMin;
  }
  public static int getReverseMin(boolean[][] board){
    int curMin = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j]==((i+1)*(j+1)%2==0)) curMin++;
      }
    }
    return curMin;
  }
}