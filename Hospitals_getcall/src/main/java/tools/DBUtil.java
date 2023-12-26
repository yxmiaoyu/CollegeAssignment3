package tools;

import been.Doctor;
import been.KeShi;
import been.Patient;
import been.TimeTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBUtil {
    private String connStr = "jdbc:mysql://localhost:3306/red1";
    private String user = "root";
    private String pwd = "123456";

    public DBUtil() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /*

1.execute(String query)方法用来执行任意的SQL语句查询，如果查询的结果是一个ResultSet,这个方法就返回true,
    如果结果不是ResultSet，比如：insert或update，就会返回false.可以通过getResultSet方法来获取ResultSet。
2.executeQuery(String query)接口用来执行select查询，并返回ResultSet,
    即便查询不到记录，返回的ResultSet也不会为null.
3.executeUpdate(String query)方法用来执行insert，delete或者update语句，返回值是int类型，
    如果是DML语句，则是更新的条数，如果是DDL，则返回0



    */


    public void addKeShi(String str1, String str2) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "INSERT INTO ke_shi(name,describe1) VALUES ('" + str1 + "','" + str2 + "')";
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        if (num == 1) {
            System.out.println("科室新增成功\n");
        } else {
            System.out.println("科室新增失败，SQL语句为：" + sql + "\n");
        }
        //关闭数据库连接
        statement.close();
        conn.close();
    }


    public List<KeShi> getAllKeShi() throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "SELECT * FROM ke_shi";
        ResultSet rs = statement.executeQuery(sql);
        List<KeShi> list = new ArrayList<>();
        KeShi keShi=null;
        while (rs.next()) {
            //获取当前记录中的数据
            //方法1. 通过字段索引获取id，列索引是从1开始的。
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String describe = rs.getString(3);
            keShi=new KeShi(id,name,describe);
            list.add(keShi);
        }
        //关闭数据库连接
        statement.close();
        conn.close();
        return list;
    }


    public void changeKeShiByID(int id, String str1, String str2) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "UPDATE ke_shi SET  name='" + str1 + "',describe1='" + str2 + "' WHERE id = " + id;
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        if (num == 1) {
            System.out.println("科室修改成功\n");
        } else {
            System.out.println("科室修改失败，SQL语句为：" + sql + "\n");
        }
        //关闭数据库连接
        statement.close();
        conn.close();
    }


    public void deleteKeShiByID(int id) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "DELETE FROM  ke_shi WHERE id =" + id;
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        if (num == 1) {
            System.out.println("科室删除成功\n");
        } else {
            System.out.println("科室删除失败，SQL语句为：" + sql + "\n");
        }
        //关闭数据库连接
        statement.close();
        conn.close();
    }


    //------------------------------------------------------------------------------------------------------------------
    public void addDoctor(String str1, String str2, String str3, String str4, int num5, String str6, String str7, String str8) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "INSERT INTO doctor(doctor_id,name,department_name,gender,age,specialty,join_date,describe1) VALUES ('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "'," + num5 + ",'" + str6 + "','" + str7 + "','" + str8 + "')";
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        if (num == 1) {
            System.out.println("医生新增成功\n");
        } else {
            System.out.println("医生新增失败，SQL语句为：" + sql + "\n");
        }
        //关闭数据库连接
        statement.close();
        conn.close();
    }


    public List<Doctor> getAllDoctor() throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql 部分分类，
        String sql = "SELECT * FROM doctor";
        ResultSet rs = statement.executeQuery(sql);
        List<Doctor> list = new ArrayList<>();
        Doctor doctor = new Doctor();
        while (rs.next()) {
            //获取当前记录中的数据
            //方法1. 通过字段索引获取id，列索引是从1开始的。
            int id = rs.getInt(1);
            String doctorID = rs.getString(2);
            String name = rs.getString(3);
            String departmentName = rs.getString(4);
            String gender = rs.getString(5);
            int age = rs.getInt(6);
            String specialty = rs.getString(7);
            String joinDate = rs.getString(8);
            String describe = rs.getString(9);
            doctor = new Doctor(id, doctorID, name, departmentName, gender, age, specialty, joinDate, describe);
            list.add(doctor);

        }
        //关闭数据库连接
        statement.close();
        conn.close();
        return list;
    }


    public void changeDoctorByID(int id, String str1, String str2, String str3, String str4, int num5, String str6, String str7, String str8) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "UPDATE doctor SET  doctor_id='" + str1 + "',name='" + str2 + "',department_name='" + str3 + "',gender='" + str4 + "',age=" + num5 + ",specialty='" + str6 + "',join_date='" + str7 + "',describe1='" + str8 + "'  WHERE id = " + id;
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        if (num == 1) {
            System.out.println("医生修改成功\n");
        } else {
            System.out.println("医生修改失败，SQL语句为：" + sql + "\n");
        }
        //关闭数据库连接
        statement.close();
        conn.close();
    }




    //------------------------------------------------------------------------------------------------------------------
    public TimeTable findTimeTableByThings(int doctorId, int bigTime, String smallTime) throws SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM time_table WHERE doctor_id = "+doctorId+" AND big_time="+bigTime+" AND small_time = '"+smallTime+"'";
//        System.out.println(sql);
        ResultSet rs = statement.executeQuery(sql);
        List<TimeTable> list = new ArrayList<>();
        TimeTable timeTable=null;
        while (rs.next()) {
            int num1 = rs.getInt(1);
            int num2 = rs.getInt(2);
            int num3 = rs.getInt(3);
            String str4 = rs.getString(4);
            timeTable=new TimeTable(num1,num2,num3,str4);
            list.add(timeTable);
        }
        //关闭数据库连接
        statement.close();
        conn.close();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }



    public int changeTimeTableAvailableNumByID(int id,int availableNum) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "UPDATE time_table SET  available_num = "+availableNum+" WHERE id = " + id;
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        //关闭数据库连接
        statement.close();
        conn.close();
        return num;
    }



    public int addTimeTable(int doctorId, int bigTime, String smallTime,int availableNum) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "INSERT INTO time_table(doctor_id,big_time,small_time,available_num) VALUES (" + doctorId + "," + bigTime + ",'" + smallTime + "','" + availableNum + "')";
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        //关闭数据库连接
        statement.close();
        conn.close();
        return num;
    }

    public List<TimeTable> getAllTimeTable() throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "SELECT * FROM time_table order by big_time asc";
        ResultSet rs = statement.executeQuery(sql);
        List<TimeTable> list = new ArrayList<>();
        TimeTable timeTable=null;
        while (rs.next()) {
            int num1 = rs.getInt(1);
            int num2 = rs.getInt(2);
            int num3 = rs.getInt(3);
            String str4 = rs.getString(4);
            int num5 = rs.getInt(5);
            timeTable=new TimeTable(num1,num2,num3,str4,num5);
            list.add(timeTable);
        }
        //关闭数据库连接
        statement.close();
        conn.close();
        return list;
    }



    //------------------------------------------------------------------------------------------------------------------
    public void addPatient(String name,int timeTableId,String describe) throws ClassNotFoundException, SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "INSERT INTO patient(name,time_table_id,describe1) VALUES ('" + name + "'," + timeTableId + ",'" + describe + "')";
//        System.out.println(sql);
        int num = statement.executeUpdate(sql);
        if (num == 1) {
            System.out.println("预约成功\n");
        } else {
            System.out.println("预约失败，SQL语句为：" + sql + "\n");
        }
        //关闭数据库连接
        statement.close();
        conn.close();
    }



    public List<Patient> getAllPatient() throws SQLException {
        //获得连接
        Connection conn = DriverManager.getConnection(connStr, user, pwd);
        Statement statement = conn.createStatement();
        //sql
        String sql = "SELECT * FROM patient ";
        ResultSet rs = statement.executeQuery(sql);
        List<Patient> list = new ArrayList<>();
        Patient patient=null;
        while (rs.next()) {
            int num1 = rs.getInt(1);
            String str2 = rs.getString(2);
            int num3 = rs.getInt(3);
            String str4 = rs.getString(4);
            patient=new Patient(num1,str2,num3,str4);
            list.add(patient);
        }
        //关闭数据库连接
        statement.close();
        conn.close();
        return list;
    }



}

