package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_16506 {
    //    p_16506 : CPU (java 15)
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            String rD = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
            String rA = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
            String rB = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
            String code0to4 = "";

            boolean isEndC = opcode.charAt(opcode.length() - 1) == 'C';
            if (isEndC) opcode = opcode.substring(0, opcode.length() - 1);
            switch (opcode) {
                case "ADD" -> code0to4 = "0000";
                case "SUB" -> code0to4 = "0001";
                case "MOV" -> code0to4 = "0010";
                case "AND" -> code0to4 = "0011";
                case "OR" -> code0to4 = "0100";
                case "NOT" -> code0to4 = "0101";
                case "MULT" -> code0to4 = "0110";
                case "LSFTL" -> code0to4 = "0111";
                case "LSFTR" -> code0to4 = "1000";
                case "ASFTR" -> code0to4 = "1001";
                case "RL" -> code0to4 = "1010";
                case "RR" -> code0to4 = "1011";
            }
            sb
                    .append(code0to4)
                    .append(!isEndC ? 0 : 1)
                    .append("0")
                    .append(byteString(rD, 3))
                    .append((opcode.startsWith("MOV") || opcode.startsWith("NOT")) ? "000" : byteString(rA, 3))
                    .append(!isEndC ? byteString(rB, 3) + "0" : byteString(rB, 4))
                    .append("\n");
        }
        System.out.print(sb);
    }

    private static String byteString(String rA, int length) {
        StringBuilder sb = new StringBuilder();
        for (int j = rA.length(); j < length; j++) {
            sb.append(0);
        }
        sb.append(rA);
        return sb.toString();
    }
}
