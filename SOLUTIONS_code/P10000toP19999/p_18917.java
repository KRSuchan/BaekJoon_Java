package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_18917 {
    //    p_18917 : 수열과 쿼리 38
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyArray myArray = new MyArray();
        while (n-- > 0) {
            var st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1 -> myArray.addX(Integer.parseInt(st.nextToken()));
                case 2 -> myArray.removeX(Integer.parseInt(st.nextToken()));
                case 3 -> System.out.println(myArray.getSum());
                case 4 -> System.out.println(myArray.getXor());
            }
        }
    }

    static class MyArray {
        long sum = 0;
        int xor = 0;


        public void addX(int x) {
            sum += x;
            xor ^= x;
        }

        public void removeX(int x) {
            sum -= x;
            xor ^= x;
        }

        public long getSum() {
            return sum;
        }

        public int getXor() {
            return xor;
        }
    }
}
