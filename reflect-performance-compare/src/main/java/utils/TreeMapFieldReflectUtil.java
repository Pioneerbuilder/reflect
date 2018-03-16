package utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class TreeMapFieldReflectUtil<T> {

    private T t;
    private String verifyKey;

    public TreeMapFieldReflectUtil() {
    }

    public TreeMapFieldReflectUtil(T t, String verifyKey) {
        this.t = t;
        this.verifyKey = verifyKey;
    }

    /**
     * <p>方法描述: 跨越鉴权值</p>

     * <p>方法备注: </p>
     *
     * @return
     * @throws Exception
     *
     * <p>创建人：zhangld</p>
     *
     * <p>创建时间：2018年3月15日 下午7:10:29</p>
     *
     */
    public String authentication() throws Exception {
        //非空值按参数名字符升序，得到排序参数名称+值字符
        Map<String, String> map = covertNotEmptySortMap();

        StringBuilder sortStr = new StringBuilder(100);
        sortStr.append(verifyKey);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sortStr.append(entry.getKey());
        }

        //MD5：32位大写MD5值
//        return Md5Util.md5Encode(sortStr.toString()).toUpperCase();
        return sortStr.toString();
    }

    /**
     * put into a treeMap
     * @return map
     * @throws Exception
     */
    private Map<String, String> covertNotEmptySortMap() throws Exception {
        Map<String, String> map = new TreeMap<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            Object fieldVal = f.get(t);
            String fieldName = f.getName();
            if(!"serialVersionUID".equals(fieldName) && null != fieldVal && !"".equals(fieldVal.toString())){
                map.put(fieldName, fieldVal.toString());
            }
        }
        return map;
    }

}
