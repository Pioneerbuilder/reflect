import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import beans.AppBean;
import utils.CacheMethodUtil;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class CacheMethodRun {

    public static final int CAPACITY = 10000000;

    private AppBean init() {
        return new AppBean(new Random().nextInt() * 100, "bbfbsdwew", new Random().nextLong() * 100);
    }

    public static void main(String[] args) throws Exception {
        long initStart = System.currentTimeMillis();
        CacheMethodRun signRun = new CacheMethodRun();
        List<AppBean> appBeanList = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            appBeanList.add(signRun.init());
        }
        CacheMethodUtil.init();
        long initDuration = System.currentTimeMillis()-initStart;
        Thread.sleep(5000);
        System.out.println("init CacheMethodRun for " + initDuration +" milliseconds to start!!!");



        long start = System.currentTimeMillis();
        for (AppBean appBean : appBeanList) {
            CacheMethodUtil.authenticate(appBean, "dferhrdgryy");
        }
//        String str = utils.CacheMethodUtil.authenticate(appBeanList, "dferhrdgryy");
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);

    }
}
