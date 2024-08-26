package SOLUTIONS_code.P20000toP29999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_25329 {
    //    p_25329 : 학생별 통화 요금 계산
    static final int BASE_TIME = 100;
    static final int BASE_COST = 10;
    static final int UNIT_TIME = 50;
    static final int UNIT_COST = 3;

    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> consumer = new HashMap<>();
        while (n-- > 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ":");
            String name = st1.nextToken();
            int time = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
            int savedTime = consumer.getOrDefault(name, 0);
            consumer.put(name, time + savedTime);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0, len = consumer.size(); i < len; i++) {
            String name = consumer.keySet().iterator().next();
            int time = consumer.remove(name) - BASE_TIME;
            int cost = BASE_COST;
            if (time > 0) {
                cost += time % UNIT_TIME > 0 ?
                        (time / UNIT_TIME + 1) * UNIT_COST
                        : time / UNIT_TIME * UNIT_COST;
            }
            list.add(new Student(name, cost));
        }
        Collections.sort(list);
        for (Student s : list) {
            sb.append(s.name).append(" ").append(s.cost).append("\n");
        }
        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int cost;

        public Student(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public int compareTo(Student o) {
            if (cost == o.cost) {
                return name.compareTo(o.name);
            }
            return o.cost - cost;
        }
    }
}
