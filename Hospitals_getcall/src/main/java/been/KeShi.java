package been;


import java.util.List;

public class KeShi {
    //sql id
    private int id;
    //科室名称
    private String name;

    private String describe;

    public KeShi(String name, String describe) {
        this.name = name;
        this.describe=describe;
    }

    public KeShi(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "科室Id=" + id +
                ", 科室名称='" + name + '\'' +
                ", 科室描述='" + describe + '\'';
    }
}

