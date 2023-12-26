package been;


public class TimeTable {

    //sql id
    private int id;
    //医生ID
    private int doctorId;
    //坐诊时间/日期 1-7
    private int bigTime;
    //坐诊时间段 am1 am2 pm1 pm2
    private String smallTime;
    //剩余接诊数量
    private int availableNum;

    public TimeTable(int id, int doctorId, int bigTime, String smallTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.bigTime = bigTime;
        this.smallTime = smallTime;
    }

    public TimeTable(int id, int doctorId, int bigTime, String smallTime, int availableNum) {
        this.id = id;
        this.doctorId = doctorId;
        this.bigTime = bigTime;
        this.smallTime = smallTime;
        this.availableNum = availableNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getBigTime() {
        return bigTime;
    }

    public void setBigTime(int bigTime) {
        this.bigTime = bigTime;
    }

    public String getSmallTime() {
        return smallTime;
    }

    public void setSmallTime(String smallTime) {
        this.smallTime = smallTime;
    }

    public int getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(int availableNum) {
        this.availableNum = availableNum;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", bigTime=" + bigTime +
                ", smallTime='" + smallTime + '\'' +
                ", availableNum=" + availableNum +
                '}';
    }
}
