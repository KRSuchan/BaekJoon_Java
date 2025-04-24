package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_28702 {
    //    p_28702 : FizzBuzz
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int num;
        if (isNumber(str1)) num = Integer.parseInt(str1) + 3;
        else if (isNumber(str2)) num = Integer.parseInt(str2) + 2;
        else num = Integer.parseInt(str3) + 1;

        System.out.println(getFizzBuzzNumber(num));
    }

    private static String getFizzBuzzNumber(int num) {
        if (num % 15 == 0) return "FizzBuzz";
        else if (num % 3 == 0) return "Fizz";
        else if (num % 5 == 0) return "Buzz";
        else return Integer.toString(num);
    }

    private static boolean isNumber(String str) {
        return !str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz");
    }
}
