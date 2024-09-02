package SOLUTIONS_code.P10000toP19999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p_14612 {
    //    p_14612 : 김식당
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Order> orders = new ArrayList<Order>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "order":
                    orders.add(new Order(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                    for (Order o : orders) {
                        sb.append(o.n).append(" ");
                    }
                    sb.append("\n");
                    break;
                case "sort":
                    if (orders.isEmpty()) sb.append("sleep");
                    else {
                        orders.sort((o1, o2) -> {
                            if (o1.t == o2.t) {
                                return o1.n - o2.n;
                            }
                            return o1.t - o2.t;
                        });
                        for (Order o : orders) {
                            sb.append(o.n).append(" ");
                        }
                    }
                    sb.append("\n");
                    break;
                case "complete":
                    int tn = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < orders.size(); j++) {
                        if (orders.get(j).n == tn) {
                            orders.remove(j);
                        }
                    }
                    if (orders.isEmpty()) sb.append("sleep");
                    else
                        for (Order o : orders) {
                            sb.append(o.n).append(" ");
                        }
                    sb.append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    static class Order {
        int n;
        int t;

        public Order(int n, int t) {
            this.n = n;
            this.t = t;
        }
    }
}
