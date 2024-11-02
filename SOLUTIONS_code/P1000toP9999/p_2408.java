package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class p_2408 {
    //    p_2408 : 큰 수 계산
    public static void solution(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<BigDecimal> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        nums.push(new BigDecimal(br.readLine()));
        for (int i = 1; i < N; i++) {
            Character operator = br.readLine().charAt(0);
            BigDecimal number = new BigDecimal(br.readLine());
            if (operator.equals('*') || operator.equals('/')) {
                BigDecimal lastNumber = nums.pop();
                BigDecimal result;
                if (operator.equals('*')) {
                    result = lastNumber.multiply(number);
                } else {
                    if (number.compareTo(BigDecimal.ZERO) > 0 && lastNumber.compareTo(BigDecimal.ZERO) < 0
                            || number.compareTo(BigDecimal.ZERO) < 0 && lastNumber.compareTo(BigDecimal.ZERO) > 0) {
                        result = lastNumber.divide(number, 0, RoundingMode.UP);
                    } else {
                        result = lastNumber.divide(number, 0, RoundingMode.DOWN);
                    }
                }
                nums.push(result);
            } else {
                ops.push(operator);
                nums.push(number);
            }
        }

        while (!ops.isEmpty()) {
            BigDecimal num1 = nums.remove(0);
            BigDecimal num2 = nums.remove(0);
            Character operator = ops.remove(0);
            BigDecimal result;

            if (operator.equals('+')) {
                result = num1.add(num2);
            } else {
                result = num1.subtract(num2);
            }
            nums.add(0, result);
        }
        System.out.println(nums.pop());
    }
}
