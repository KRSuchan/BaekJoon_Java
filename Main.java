import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //    p_29767 : 점수를 최대로
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cs[i] = Integer.parseInt(st.nextToken());
        }
        // alg
        long[] dp = new long[n];
        dp[0] = cs[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + cs[i];
        }
        Arrays.sort(dp);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += dp[n - 1 - i];
        }
        // output
        System.out.println(sum);
    }
}