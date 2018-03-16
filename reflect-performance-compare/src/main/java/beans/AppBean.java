package beans;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class AppBean {
    private Integer integer;

    private String str;

    private Long aLong;

    private AppBean() {
    }

    public AppBean(Integer integer, String str, Long aLong) {
        this.integer = integer;
        this.str = str;
        this.aLong = aLong;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }
}
