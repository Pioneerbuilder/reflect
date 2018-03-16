package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class CacheMethodUtil {

    private static Map<String, List<Method>> methodCache = new HashMap<>();


//    static StringBuilder stringBuilder = new StringBuilder(100 * CacheMethodRun.CAPACITY);

    public static void init() throws ClassNotFoundException {
        Class clazz = Class.forName("beans.AppBean");
        Method[] methods = clazz.getMethods();
        List<Method> cacheMethodList = new ArrayList<>(10);
        List<Method> methodList = Arrays.asList(methods);
        Collections.sort(methodList, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                String o1Temp = o1.getName().substring(3);
                String o2Temp = o2.getName().substring(3);
                return o1Temp.compareTo(o2Temp);
            }
        });

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get") && !methodName.equals("getClass")) {
                cacheMethodList.add(method);
            }
        }
        methodCache.put(clazz.getName(), cacheMethodList);
    }
//
//    public static <T> String authenticate(List<T> tList, String verifyKey) throws InvocationTargetException, IllegalAccessException {
//        if (tList == null || verifyKey == null || verifyKey.isEmpty()) {
//            throw new IllegalArgumentException("t, verifyKey cannot be null!!");
//        }
//        List<Method> methodList = methodCache.get(tList.get(0).getClass().getName());
//        for (T t : tList) {
//            stringBuilder.append(verifyKey);
//            for (Method method : methodList) {
//                Object value = method.invoke(t);
//                if (value != null) {
//                    stringBuilder.append(value);
//                }
//            }
//        }
//        return stringBuilder.toString();
//    }

    public static <T> String authenticate(T t, String verifyKey) throws InvocationTargetException, IllegalAccessException {
        if (t == null || verifyKey == null || verifyKey.isEmpty()) {
            throw new IllegalArgumentException("t, verifyKey cannot be null!!");
        }
        List<Method> methodList = methodCache.get(t.getClass().getName());
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(verifyKey);
        for (Method method : methodList) {
            Object value = method.invoke(t);
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }
}
