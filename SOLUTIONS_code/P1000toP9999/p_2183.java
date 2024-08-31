package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2183 {
//    static int N;
//    static int[] ballScore, gameScore;
//    static int player;

    //    p_2183 : 테니스 시합 (시도했지만 맞지 못한 문제 : 뭐가 틀린건지 전혀 모르겠음) -> 질문게시판 훑어보고 온 후 : 이딴게 문제? 나의 4시간 돌려줘
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        System.out.println(s.charAt(s.length() - 1));
    }
//
//    public static void solution(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//        while (scanner.hasNextLine()) {
//            StringTokenizer st = new StringTokenizer(scanner.nextLine());
//            N = Integer.parseInt(st.nextToken());
//            String S = st.nextToken();
//            int games = S.length();
//            ballScore = new int[N];
//            gameScore = new int[N];
//            int[] setScore = new int[N];
//            for (int i = 0; i < games; i++) {
//                int winner = S.charAt(i) - 'A';
//                boolean isGameOver = false;
//                // rule of game
//                if (ballScore[winner] == 3 && !hasMoreThan2Points(winner)) {// If P currently has 3 points and no other player has more than 2 points,
//                    // then P wins the current game.
//                    isGameOver = true;
//                } else if (ballScore[winner] == 4) { // If P currently has 4 points
//                    // then he wins the game.
//                    isGameOver = true;
//                } else if (playerHasMoreThan4Points(winner) > 0) { // If any other player currently has 4 points
//                    // then that player loses one point.
//                    ballScore[player]--;
//                } else {
//                    // P gains a point.
//                    ballScore[winner]++;
//                }
//                // rule of set
//                if (isGameOver) {
//                    gameScore[winner]++;
//                    if (gameScore[winner] >= 6 && isWinMoreThan2Games(winner)) { // won at least 6 games in this set
//                        boolean isAllWin = true;
//                        for (int j = 0; j < N; j++) {
//                            if (j != winner && gameScore[j] != 0) {
//                                isAllWin = false;
//                                break;
//                            }
//                        }
//                        if (isAllWin) setScore[winner] += 2;
//                        else setScore[winner]++;
//                        gameScore = new int[N];
//                    }
//                    ballScore = new int[N];
//                }
//                // rule of tennis
//                if (setScore[winner] >= 3) {
//                    sb.append((char) ('A' + winner));
//                    setScore = new int[N];
//                    break;
//                }
//            }
//        }
//        System.out.println(sb);
//        scanner.close();
//    }
//
//    private static boolean isWinMoreThan2Games(int winner) {
//        for (int i = 0; i < N; i++) {
//            if (i != winner && gameScore[winner] - gameScore[i] < 2) return false;
//        }
//        return true;
//    }
//
//    private static boolean hasMoreThan2Points(int winner) {
//        for (int i = 0; i < N; i++) {
//            if (i != winner && ballScore[i] == 2) return true;
//        }
//        return false;
//    }
//
//    private static int playerHasMoreThan4Points(int winner) {
//        player = -1;
//        for (int i = 0; i < N; i++) {
//            if (i != winner && ballScore[i] == 4) {
//                player = i;
//                return i;
//            }
//        }
//        return player;
//    }
}
