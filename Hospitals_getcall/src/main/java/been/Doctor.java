package been;


public class Doctor {
    //sql ID
    private int id;
    //工号
    private String doctorID;
    //名字
    private String name;
    //部门名称
    private String departmentName;
    //性别
    private String gender;
    //年龄
    private int age;
    //专业
    private String specialty;
    //入职时间
    private String joinDate;
    //科室信息
    private String describe;

    public Doctor() {
    }

    public Doctor(int id, String doctorID, String name, String departmentName, String gender, int age, String specialty, String joinDate, String describe) {
        this.id = id;
        this.doctorID = doctorID;
        this.name = name;
        this.departmentName = departmentName;
        this.gender = gender;
        this.age = age;
        this.specialty = specialty;
        this.joinDate = joinDate;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }


    @Override
    public String toString() {
        return "医生编号=" + id +
                ", 工号='" + doctorID + '\'' +
                ", 名字='" + name + '\'' +
                ", 部门名称='" + departmentName + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄=" + age +
                ", 专业='" + specialty + '\'' +
                ", 入职时间='" + joinDate + '\'' +
                ", 科室信息='" + describe + '\'';
    }
}
