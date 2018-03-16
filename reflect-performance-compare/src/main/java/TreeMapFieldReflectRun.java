import beans.AppBean;
import utils.TreeMapFieldReflectUtil;
import conf.JVMRuntimeConf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class TreeMapFieldReflectRun {

    public static final int CAPACITY = 10000000;

    private AppBean init() {
        return new AppBean(new Random().nextInt() * 100, "bbfbsdwew", new Random().nextLong() * 100);
    }

    public static void main(String[] args) throws Exception {
        long initStart = System.currentTimeMillis();
        TreeMapFieldReflectRun treeMapFieldReflectRun = new TreeMapFieldReflectRun();
        List<AppBean> appBeanList = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            appBeanList.add(treeMapFieldReflectRun.init());
        }

        long initDuration = System.currentTimeMillis()-initStart;
        Thread.sleep(5000);
        System.out.println("init treeMapFieldReflectRun for " + initDuration +" milliseconds to start!!!");



        long start = System.currentTimeMillis();
        for (AppBean appBean : appBeanList) {
            TreeMapFieldReflectUtil<AppBean> kyutil = new TreeMapFieldReflectUtil<>(appBean, "dferhrdgryy");
            kyutil.authentication();
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);

        JVMRuntimeConf.showJVMRuntime();
    }
}
