package SOLUTIONS_code.P1000toP9999;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class p_1181 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        String[] words=new String[cnt];
        for (int i = 0; i < cnt; i++) {
            words[i] = br.readLine();
        }
        // 단어 정렬 알고리즘
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // 단어 길이가 같은 경우
                if (s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }else { // 그 외의 경우
                    return s1.length()-s2.length();
                }
            }
        });
        // 단어 출력
        bw.write(words[0]+"\n");
        for (int i = 1; i < cnt; i++) { // 단어가 중복 될 경우 한번만 출력
            if (!words[i].equals(words[i-1])) bw.write(words[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
