package beans;

/**
 * Created by tangxiaodong on 2018/3/16.
 */
public class AppBean {
    private Integer integer;

    private String str;

    private Long longer;

    private AppBean() {
    }

    public AppBean(Integer integer, String str, Long longer) {
        this.integer = integer;
        this.str = str;
        this.longer = longer;
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

    public Long getLonger() {
        return longer;
    }

    public void setLonger(Long aLong) {
        this.longer = aLong;
    }
}
