package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_1529 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        while(true){
            s = br.readLine();
            if (s.equals("0")){
                bw.flush();
                break;
            }
            if (isPalindrome(s)){
                bw.write("yes\n");
            }else {
                bw.write("no\n");
            }
        }
        bw.close();
        br.close();
    }
    public boolean isPalindrome(String number){
        int length = number.length();
        for (int i = 0; i < length/2; i++) {
            if (number.charAt(i) != number.charAt(length-i-1)) return false;
        }
        return true;
    }
}
