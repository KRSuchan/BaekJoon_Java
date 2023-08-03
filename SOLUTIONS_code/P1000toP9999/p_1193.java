package SOLUTIONS_code.P1000toP9999;

import java.io.*;

public class p_1193 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 초기화
        int target = Integer.parseInt(br.readLine());
        int floor=0;
        int deno=1, nume=1; // 분모 : denominator, 분자 : numerator
        int sumFloors=0;
        int[] answer;
        // X보다 커질 때까지 층수 덧셈 진행
        for (; sumFloors<target; floor++) {
            sumFloors+=floor;
        }
        floor--; // 층 수는 한 칸 더 갔으므로 1감소
        // if 홀수 then 분자:층, 분모:1; 짝수이면 반대
        if (floor%2==0){
            nume=floor;
            deno=1;
            answer=accessToTarget(deno, nume, sumFloors, target);
            deno=answer[0];
            nume=answer[1];
        }else {
            nume = 1;
            deno = floor;
            answer=accessToTarget(nume, deno, sumFloors, target);
            nume=answer[0];
            deno=answer[1];
        }
        bw.write(nume+"/"+deno);
        bw.flush();
        bw.close();
        br.close();
    }

    // 각각의 분모 혹은 분자를 목표 값만큼 증가 감소하는 함수
    public int[] accessToTarget(int plus, int minus, int start, int target){
        for (; target < start; start--) {
            plus++;
            minus--;
        }
        int[] answer = {plus, minus};
        return answer;
    }
}
