package test;


import frame.SysController;
import tools.Tools;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Tools tools = new Tools();
        SysController sys = new SysController();
        System.out.println("======== 欢迎使用本医院系统 ========");
        String order = "";
        while (order.equals("0") == false) {
            System.out.println("====================\n" +
                    "请输入您的下一步操作\n" +
                    "0. 退出本系统\n" +
                    "1. 科室管理-添加科室\n" +
                    "2. 科室管理-查看所有科室\n" +
                    "3. 科室管理-修改科室\n" +
                    "4. 科室管理-删除科室\n" +
                    "5. 医生管理-添加/录入医生\n" +
                    "6. 医生管理-查看所有医生信息\n" +
                    "7. 医生管理-修改医生信息\n" +
                    "8. 医生管理-医生坐诊设置（未来一周的坐诊情况）\n" +
                    "9. 医生管理-展示全部医生的坐诊详情（未来一周的坐诊情况）\n" +
                    "10. 医生管理-挂号预约\n" +
                    "11. 搜索某个医生当前与未来6天内（未来一周）的病人预约情况\n" +
                    "12. 通过日期与时间段，搜索未来七天内可以坐诊的医生，并按照科室进行分类\n" +
                    "   请输入操作命令\n" +
                    "====================\n");
            order = tools.scannerString();
            if (order.equals("0")) {
                System.out.println("===========谢谢使用，系统退出=======");
                System.exit(0);
            } else if (order.equals("1")) {
                sys.addKeShi();
            } else if (order.equals("2")) {
                sys.getAllKeShi();
            } else if (order.equals("3")) {
                sys.changeKeShi();
            } else if (order.equals("4")) {
                sys.deleteKeShi();
            } else if (order.equals("5")) {
                sys.addDoctor();
            } else if (order.equals("6")) {
                sys.getAllDoctor();
            } else if (order.equals("7")) {
                sys.changeDoctor();
            } else if (order.equals("8")) {
                sys.setDoctorWeek();
            } else if (order.equals("9")) {
                sys.showTimeTable();
            } else if (order.equals("10")) {
                sys.appointment();
            } else if (order.equals("11")) {
                sys.getDoctorWeekTimeTable();
            } else if (order.equals("12")) {
                sys.getOneDayTimeTable();
            } else {
                System.out.println("输入不合法，请检查重新输入");
            }
        }
        System.out.println("===========谢谢使用，系统退出=======");
        System.exit(0);
    }
}