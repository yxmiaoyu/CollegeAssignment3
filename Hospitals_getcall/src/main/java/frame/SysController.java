package frame;

import been.Doctor;
import been.KeShi;
import been.Patient;
import been.TimeTable;
import tools.DBUtil;
import tools.Tools;

import java.sql.SQLException;
import java.util.*;

public class SysController {

    Tools tools = new Tools();
    DBUtil dbUtil = new DBUtil();

    public SysController() throws ClassNotFoundException {

    }


    //科室新增
    public void addKeShi() throws SQLException, ClassNotFoundException {
        //获得输入信息
        System.out.println("请输入科室名称\n");
        String name = tools.scannerString();
        System.out.println("请输入科室描述\n");
        String describe = tools.scannerString();
        //开始调用SQL
        dbUtil.addKeShi(name, describe);
    }


    //科室-查看所有
    public void getAllKeShi() throws SQLException, ClassNotFoundException {
        List<KeShi> list = dbUtil.getAllKeShi();
        if (list != null && list.size() > 0) {
            System.out.println("====================\n科室Id  | 科室名称  | 科室描述");
        }
        for (KeShi k : list) {
            System.out.println(k.toString());
        }
    }


    //科室-修改
    public void changeKeShi() throws SQLException, ClassNotFoundException {
        System.out.println("请输入想修改的科室ID\n");
        int id = tools.scannerInt();
        System.out.println("请输入科室新的名称\n");
        String name = tools.scannerString();
        System.out.println("请输入科室新的描述\n");
        String describe = tools.scannerString();
        dbUtil.changeKeShiByID(id, name, describe);

    }

    //科室-删除
    public void deleteKeShi() throws SQLException, ClassNotFoundException {
        System.out.println("请输入想删除的科室ID\n");
        int id = tools.scannerInt();
        dbUtil.deleteKeShiByID(id);
    }


    //------------------------------------------------------------------------------------------------------------------

    //医生新增
    public void addDoctor() throws SQLException, ClassNotFoundException {
        //获得输入信息
        System.out.println("请输入医生工号\n");
        String doctorID = tools.scannerString();
        System.out.println("请输入医生姓名\n");
        String name = tools.scannerString();
        System.out.println("请输入医生部门名称\n");
        String departmentName = tools.scannerString();
        System.out.println("请输入医生性别\n");
        String gender = tools.scannerString();
        System.out.println("请输入医生年龄\n");
        int age = tools.scannerInt();
        System.out.println("请输入医生专业\n");
        String specialty = tools.scannerString();
        System.out.println("请输入医生入职时间\n");
        String joinDate = tools.scannerString();
        System.out.println("请输入医生科室信息\n");
        String describe = tools.scannerString();
        //开始调用SQL
        dbUtil.addDoctor(doctorID, name, departmentName, gender, age, specialty, joinDate, describe);
    }


    //医生-查看所有
    public void getAllDoctor() throws SQLException, ClassNotFoundException {
        List<Doctor> list = dbUtil.getAllDoctor();
        for (Doctor d : list) {
            System.out.println(d.toString());
        }
    }


    //医生-修改
    public void changeDoctor() throws SQLException, ClassNotFoundException {
        System.out.println("请输入想修改的医生ID\n");
        int id = tools.scannerInt();
        System.out.println("请输入医生新的工号\n");
        String doctorID = tools.scannerString();
        System.out.println("请输入医生新的名称\n");
        String name = tools.scannerString();
        System.out.println("请输入医生新的部门名称\n");
        String departmentName = tools.scannerString();
        System.out.println("请输入医生新的性别\n");
        String gender = tools.scannerString();
        System.out.println("请输入医生新的年龄\n");
        int age = tools.scannerInt();
        System.out.println("请输入医生新的专业\n");
        String specialty = tools.scannerString();
        System.out.println("请输入医生新的入职时间\n");
        String joinDate = tools.scannerString();
        System.out.println("请输入医生新的科室信息\n");
        String describe = tools.scannerString();
        dbUtil.changeDoctorByID(id, doctorID, name, departmentName, gender, age, specialty, joinDate, describe);

    }


    //------------------------------------------------------------------------------------------------------------------


    //医生-设置一周预约情况
    public void setDoctorWeek() throws SQLException, ClassNotFoundException {
        System.out.println("请输入想修改的坐诊医生ID\n");
        int doctorId = tools.scannerInt();
        System.out.println("请输入想修改的坐诊日期（请输入1~7“天”）\n");
        int bigTime = tools.scannerInt();
        while (bigTime > 7) {
            System.out.println("系统设计只可以修改一周哦");
            bigTime = tools.scannerInt();
        }
        System.out.println("请输入想修改的坐诊时间段\n");
        String smallTime = tools.scannerString();
        System.out.println("请输入可预约数量");
        int availableNum = tools.scannerInt();
        //先找一下，有没有数据
        TimeTable timeTable = dbUtil.findTimeTableByThings(doctorId, bigTime, smallTime);
        int num = 0;
        if (timeTable != null) {
            //说明有数据了，开始修改
            num = dbUtil.changeTimeTableAvailableNumByID(timeTable.getId(), availableNum);
        } else {
            //说明没有数据了，开始新增
            num = dbUtil.addTimeTable(doctorId, bigTime, smallTime, availableNum);
        }

        if (num == 0) {
            System.out.println("数据修改失败");
        } else {
            System.out.println("数据修改成功");
        }
    }


    //展示展示每个医生七天的坐诊情况，需要按照科室归类展示。
    public void showTimeTable() throws SQLException, ClassNotFoundException {
        //按照科室，
        //所有科室的信息
        List<KeShi> keShiList = new ArrayList<>();
        //所有医生的信息，Map（医生id。名字）
        List<Doctor> doctorList = new ArrayList<>();
        //所有时间表信息
        List<TimeTable> timeTableList = new ArrayList<>();


        //所有时间表信息
        List<Patient> patientsList = new ArrayList<>();

        //查询所有科室信息
        keShiList = dbUtil.getAllKeShi();
        //查询所有医生信息
        doctorList = dbUtil.getAllDoctor();
        //查询所有时间表信息
        timeTableList = dbUtil.getAllTimeTable();
        //预约表
        patientsList = dbUtil.getAllPatient();

        //便利科室信息列表
        for (KeShi k : keShiList) {
            //便利医生信息
            System.out.println("科室名称：" + k.getName());
            for (Doctor d : doctorList) {
                if (k.getName().equals(d.getDepartmentName())) {
                    System.out.println("    医生名称：" + d.getName() + "  医生唯一身份标识符id：" + d.getId());
                    for (TimeTable t : timeTableList) {
                        if (t.getDoctorId() == d.getId() && d.getDepartmentName().equals(k.getName())) {
                            //展示预约情况
                            System.out.println("            第 " + t.getBigTime() + " 天， 第 " + t.getSmallTime() + " 时间段预约情况为：");
                            int count = 0;
                            for (Patient p : patientsList) {
                                if (p.getTimeTableId() == t.getId()) {
                                    System.out.println("                预约的信息：患者id：" + p.getId() + " 患者姓名:" + p.getName() + " 患者病情描述：" + p.getDescribe());

                                    ++count;
                                }
                            }
                            System.out.println("                已预约人数：" + count + " 可预约人数：" + t.getAvailableNum());
                        }

                    }
                }
            }
        }
        System.out.println("===================================");
    }


    //------------------------------------------------------------------------------------------------------------------

//用户可以选择要预约的科室、医生、日期和时间段，==并输入患者的个人信息==，系统将自动判断该时间段是否还有预约的名额，并保存预约信息。
    public void appointment() throws SQLException, ClassNotFoundException {

        //用户可以选择要预约的科室、医生、日期和时间段，==并输入患者的个人信息==，系统将自动判断该时间段是否还有预约的名额，并保存预约信息。
        System.out.println("请输入想预约的科室名称\n");
        String KeShiName = tools.scannerString();
        System.out.println("请输入想预约的医生Id\n");
        int doctorId = tools.scannerInt();
        System.out.println("请输入想预约的日期\n");
        int bigTime = tools.scannerInt();
        System.out.println("请输入想预约的时间段\n");
        String smallTime = tools.scannerString();

        //所有科室的信息
        List<KeShi> keShiList = new ArrayList<>();
        //所有医生的信息，Map（医生id。名字）
        List<Doctor> doctorList = new ArrayList<>();
        //所有时间表信息
        List<TimeTable> timeTableList = new ArrayList<>();

        //查询所有科室信息
        keShiList = dbUtil.getAllKeShi();
        //查询所有医生信息
        doctorList = dbUtil.getAllDoctor();
        //查询所有时间表信息
        timeTableList = dbUtil.getAllTimeTable();

        //指定的时间表
        TimeTable timeTable = null;

        //便利科室信息列表
        for (KeShi k : keShiList) {
            //科室匹配
            if (k.getName().equals(KeShiName)) {
                for (Doctor d : doctorList) {
                    //医生匹配
                    if (d.getId() == doctorId) {
                        for (TimeTable t : timeTableList) {
                            //预约时间，时间段{
                            if (t.getBigTime() == bigTime && t.getSmallTime().equals(smallTime) && d.getId() == t.getDoctorId()) {
                                timeTable = t;
                                break;
                            }
                        }
                    }
                }
            }
        }


        //判断医生有无排班
        if (timeTable == null) {
            System.out.println("很抱歉，" + KeShiName + " 科室的唯一身份编号为 " + doctorId + " 的医生，在未来第" + (bigTime - 1) + "天的 " + smallTime + " 时间段内没有排班，请查询其他医生或时间");
        } else {
            //可以预约
            //判断有无名额
            if (timeTable.getAvailableNum() <= 0) {
                System.out.println("很遗憾，医生的可预约人数不足，请更换其他医生或者时间段");
            } else {
                System.out.println("开始预约");
                System.out.println("请输入患者名字\n");
                String userName = tools.scannerString();
                System.out.println("请输入患者其他信息\n");
                String describe = tools.scannerString();
                //开始sql操作
                dbUtil.addPatient(userName, timeTable.getId(), describe);

                //医生可预约数量-1
                dbUtil.changeTimeTableAvailableNumByID(timeTable.getId(), timeTable.getAvailableNum() - 1);
            }
        }
    }


    //查询某个医生未来七天预约情况
    public void getDoctorWeekTimeTable() throws SQLException, ClassNotFoundException {

        //查询功能：可以查询某个医生。
        System.out.println("请输入想查询未来七天，病人对该医生的预约情况的医生Id\n");
        int doctorId = tools.scannerInt();


        //所有时间表信息
        List<TimeTable> timeTableList = new ArrayList<>();
        //所有patient信息
        List<Patient> patientList = new ArrayList<>();

        //查询所有时间表信息
        timeTableList = dbUtil.getAllTimeTable();
        patientList = dbUtil.getAllPatient();

        System.out.println("---------------------------------");

        for (TimeTable t : timeTableList) {
            //指定医生
            if (t.getDoctorId() == doctorId && t.getBigTime() <= 7) {

                //查询已经预约数量
                int num = 0;
                for (Patient p : patientList) {
                    if (p.getTimeTableId() == t.getId()) {
                        num++;
                    }

                }
                System.out.println("第" + (t.getBigTime() - 1) + "天的 " + t.getSmallTime() + " 时间段的剩余已预约数量为：" + num + " 可预约数量为：" + t.getAvailableNum());
            }
        }

    }





    //搜索日期和时间段，系统将自动搜索未来七天内在该时间段坐诊的医生信息，并按照科室分类展示。
    public void getOneDayTimeTable() throws SQLException, ClassNotFoundException {

        System.out.println("请输入想查询的日期\n");
        int bigTime = tools.scannerInt();
        System.out.println("请输入想查询的时间段\n");
        String smallTime = tools.scannerString();


        //所有医生的信息，Map（医生id。名字）
        List<Doctor> doctorList = new ArrayList<>();
        //所有时间表信息
        List<TimeTable> timeTableList = new ArrayList<>();


        //查询所有医生信息
        doctorList = dbUtil.getAllDoctor();
        //查询所有时间表信息
        timeTableList = dbUtil.getAllTimeTable();


        //便利科室信息列表
        Set<Integer> set = new HashSet<>();
        Map<String, List<Doctor>> map = new HashMap<>();


        for (Doctor d : doctorList) {
            //科室与医生绑定
            //医生与时间表绑定
            for (TimeTable t : timeTableList) {
                if (t.getBigTime() >= bigTime && t.getBigTime() <= bigTime + 7 && t.getSmallTime().equals(smallTime) && t.getDoctorId() == d.getId()) {
                    if (set.contains(d.getId()) == false) {
                        //判断集合中有没有
                        if (map.containsKey(d.getDepartmentName())) {
                            List<Doctor> list=map.get(d.getDepartmentName());
                            list.add(d);
                            map.put(d.getDepartmentName(),list);
                        } else {
                            List<Doctor> list=new ArrayList<>();
                            list.add(d);
                            map.put(d.getDepartmentName(),list);
                        }
                        set.add(d.getId());
                    }
                }
            }
        }
        if (set.size() == 0) {
            System.out.println("很抱歉，当前医生，日期，时间段没有预约计划");
        }

        //打印

        for(Map.Entry<String,List<Doctor>> e:map.entrySet()){
            System.out.println(e.getKey()+"科室：");
            for(Doctor d:e.getValue()){
                System.out.println(d.toString());
            }

        }

    }


}





