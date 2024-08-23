package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3622 {
    //    p_3622 : 어떤 호박의 할로윈 여행
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Ring A = new Ring(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Ring B = new Ring(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int P = Integer.parseInt(st.nextToken());
        boolean possiblity = false;
        if (A.out + B.out <= P) possiblity = true;
        else if (A.out <= B.in && B.out <= P) possiblity = true;
        else if (B.out <= A.in && A.out <= P) possiblity = true;

        System.out.println(possiblity ? "Yes" : "No");
    }

    static class Ring {
        int out, in;

        public Ring(int out, int in) {
            this.out = out;
            this.in = in;
        }
    }
}
