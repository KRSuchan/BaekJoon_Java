package SOLUTIONS_code.P10000toP19999;

import java.text.SimpleDateFormat;
import java.util.Date;

public class p_10699 {
    public void solution() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }
}
