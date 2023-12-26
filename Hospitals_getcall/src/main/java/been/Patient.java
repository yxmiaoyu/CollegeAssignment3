package been;

/**
 * @ClassName Patient
 * @Author YiXia
 * @Date 2023/12/19 22:53
 * @Version 1.0
 * @Description TODO
 **/
public class Patient {
    private int id;
    private String name;
    private int timeTableId;
    private String describe;

    public Patient(String name, int timeTableId, String describe) {
        this.name = name;
        this.timeTableId = timeTableId;
        this.describe = describe;
    }

    public Patient(int id, String name, int timeTableId, String describe) {
        this.id = id;
        this.name = name;
        this.timeTableId = timeTableId;
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

    public int getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(int timeTableId) {
        this.timeTableId = timeTableId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeTableId=" + timeTableId +
                ", describe='" + describe + '\'' +
                '}';
    }
}
