package utils;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class FieldReflectUtil<T> {

    private T t;
    private String verifyKey;

    public FieldReflectUtil() {
    }

    public FieldReflectUtil(T t, String verifyKey) {
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
     * <p>方法描述: 对象非空属性键值转map，按键排序</p>

     * <p>方法备注: </p>
     *
     * @return
     * @throws Exception
     *
     * <p>创建人：zhangld</p>
     *
     * <p>创建时间：2018年3月15日 下午6:40:29</p>
     *
     */
    private Map<String, String> covertNotEmptySortMap() throws Exception {
        Map<String, String> map = new TreeMap<String, String>();
        Field[] fields = t.getClass().getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            Field f = fields[i];
            f.setAccessible(true);
            Object fieldVal = f.get(t);
            String fieldName = f.getName();
            if(!"serialVersionUID".equals(fieldName) && null != fieldVal && !"".equals(fieldVal.toString())){
                map.put(fieldName+fieldVal, fieldVal.toString());
            }
        }
        return sortMapByKey(map);
    }

    /**
     * <p>方法描述: 使用 Map按key进行排序</p>

     * <p>方法备注: </p>
     *
     * @param map
     * @return
     *
     * <p>创建人：zhangld</p>
     *
     * <p>创建时间：2018年3月15日 下午6:30:29</p>
     *
     */

    public Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return map;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 项目名称：chunbo-tms-service<br>
     * *********************************<br>
     * <P>类名称：MapKeyComparator</P>
     * *********************************<br>
     * <P>类描述：map key 排序</P>
     * 创建人：zhangld<br>
     * 创建时间：2018年3月15日 下午6:10:29<br>
     * @version 1.0<br>
     */
    class MapKeyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

}
