package SOLUTIONS_code.P1000toP9999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p_8979 {
    //    p_8979 : 올림픽
    public static void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int res = -1;
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Country(num, gold, silver, bronze));
        }
        Collections.sort(countries);
        Country prev = countries.get(0);
        prev.rank = 1;
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            if (prev.compareTo(country) == 0) country.rank = prev.rank;
            else country.rank = i + 1;
            if (country.num == K) {
                res = country.rank;
                break;
            }
            prev = country;
        }
        System.out.println(res);
    }

    static class Country implements Comparable<Country> {
        int num;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (gold != o.gold) {
                return o.gold - gold;
            } else if (silver != o.silver) {
                return o.silver - silver;
            } else if (bronze != o.bronze) {
                return o.bronze - bronze;
            }
            return 0;
        }
    }
}
