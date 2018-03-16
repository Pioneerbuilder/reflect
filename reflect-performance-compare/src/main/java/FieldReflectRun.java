import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import beans.AppBean;
import utils.FieldReflectUtil;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class FieldReflectRun {

    public static final int CAPACITY = 10000000;

    private AppBean init() {
        return new AppBean(new Random().nextInt() * 100, "bbfbsdwew", new Random().nextLong() * 100);
    }

    public static void main(String[] args) throws Exception {
        long initStart = System.currentTimeMillis();
        FieldReflectRun FieldReflectRun = new FieldReflectRun();
        List<AppBean> appBeanList = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            appBeanList.add(FieldReflectRun.init());
        }

        long initDuration = System.currentTimeMillis()-initStart;
        Thread.sleep(5000);
        System.out.println("init FieldReflectRun for " + initDuration +" milliseconds to start!!!");



        long start = System.currentTimeMillis();
        for (AppBean appBean : appBeanList) {
            FieldReflectUtil<AppBean> kyutil = new FieldReflectUtil<>(appBean, "dferhrdgryy");
            kyutil.authentication();
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);

    }
}
