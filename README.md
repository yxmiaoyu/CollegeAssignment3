# 任务说明

设计医院挂号管理项目程序，要求实现：
1.科室管理：新增科室、删除科室，修改科室
2.医生管理：录入医生信息，以及科室信息，修改医生信息
3.坐诊信息设置：可以设置医生当天和未来6天的坐诊情况，包括上午和下午的坐诊时间段和可预约数量，系统自动保存到对应医生的坐诊信息列表中。
4.全部信息展示：按照科室，展示每个医生七天的坐诊情况，需要按照科室归类展示。
5.预约功能：用户可以选择要预约的科室、医生、日期和时间段，并输入患者的个人信息，系统将自动判断该时间段是否还有预约的名额，并保存预约信息。
6.搜索功能：用户可以输入搜索日期和时间段，系统将自动搜索未来七天内在该时间段坐诊的医生信息，并按照科室分类展示。
7.查询功能：可以查询某个医生未来七天，病人对该医生的预约情况。
8.撰写设计报告。

# 任务分析

1.程序设计方案
本次课程设计，根据任务需要，将创建Hospitals项目，在项目下创建Hospitals_getcall模块，此模块下设

-	been（实体类管理）、
-	frame（系统核心逻辑处理）、
-	test（程序入口）
-	tools（自定义工具类管理）四个包。

# been包下类设计：

1）Doctor类，此类为医生类，

~~~java
1.	//数据库主键，唯一身份标识符  
2.	private int id;  
3.	//医生的工号 
4.	private String doctorID;  
5.	//医生的名字  
6.	private String name;  
7.	//医生的所在的部门名称  
8.	private String departmentName;  
9.	//医生的性别  
10.	private String gender;  
11.	//医生的年龄  
12.	private int age;  
13.	//医生的专业  
14.	private String specialty;  
15.	//医生的入职时间  
16.	private String joinDate;  
17.	//医生所在的科室信息  
18.	private String describe;
~~~

2）KeShi类，用于保存科室与医生的所属关系

~~~java
1.	//数据库主键，唯一身份标识符  
2.	private int id;    
3.	//科室名称    
4.	private String name;    
5.	//科室描述  
6.	private String describe;
~~~

3）Patient类，用于保存患者预约信息，

~~~java
2.	private int id;    
3.	//患者名字  
4.	private String name;    
5.	//患者预约的时间表的id  
6.	private int timeTableId;    
7.	//患者病情描述  
8.	private String describe;
~~~

4）TimeTable类，用于患者的预约数据与医生的值班数据，

~~~java
1.	//数据库主键，唯一身份标识符    
2.	private int id;  
3.	//医生ID  
4.	private int doctorId;  
5.	//坐诊时间/日期 1-7  
6.	private int bigTime;  
7.	//坐诊时间段 如：am1 am2 pm1 pm2  
8.	private String smallTime;  
9.	//可接诊数量  
10.	private int availableNum;
~~~



# frame包下类设计

~~~java
1.	//科室-新增科室  
2.	//此方法为公开无返回值类型  
1.	public void addKeShi() throws SQLException, ClassNotFoundException   
3.	//科室-查看所有科室信息  
4.	//此方法为公开无返回值类型   
2.	public void getAllKeShi() throws SQLException, ClassNotFoundException  
5.	//科室-通过科室id修改科室信息   
3.	//此方法为公开无返回值类型
4.	public void changeKeShi() throws SQLException, ClassNotFoundException   
6.	//科室-通过科室id删除科室信息   
5.	//此方法为公开无返回值类型
6.	public void deleteKeShi() throws SQLException, ClassNotFoundException   
7.	//医生-新增医生信息   
7.	//此方法为公开无返回值类型
8.	public void addDoctor() throws SQLException, ClassNotFoundException   
8.	//医生-查看所有医生信息   
9.	//此方法为公开无返回值类型
10.	public void getAllDoctor() throws SQLException, ClassNotFoundException   
9.	//医生-通过医生id修改医生信息   
11.	//此方法为公开无返回值类型
12.	public void changeDoctor() throws SQLException, ClassNotFoundException   
10.	//医生-通过医生id，日期，时间段设置一周预约情况   
13.	//此方法为公开无返回值类型
14.	public void setDoctorWeek() throws SQLException, ClassNotFoundException   
11.	//预约-展示展示每个医生七天的坐诊情况，按照科室归类展示。   
15.	//此方法为公开无返回值类型
16.	public void showTimeTable() throws SQLException, ClassNotFoundException   
12.	//预约-用户可以选择要预约的科室、医生、日期和时间段，并输入患者的个人信息，系统将自动判断该时间段是否还有预约的名额，并保存预约信息。   
17.	//此方法为公开无返回值类型
18.	public void appointment() throws SQLException, ClassNotFoundException   
13.	//预约-查询某个医生未来七天预约情况   
19.	//此方法为公开无返回值类型
20.	public void getDoctorWeekTimeTable() throws SQLException, ClassNotFoundException   
14.	//预约-搜索日期和时间段，自动搜索未来七天内在该时间段坐诊的医生信息，并按照科室分类展示。 
21.	//此方法为公开无返回值类型  
22.	public void getOneDayTimeTable() throws SQLException, ClassNotFoundException
~~~

# tools包

Tools工具类

~~~java
	此类是自定义工具类，内含两个拥有自动获取控制台输入并判断时候符合数据要求，并转换成相应的数据格式返回。拥有数据校验，自动回复提示信息并从新获取输入的功能，用于简化项目代码开发逻辑，加快开发进度。内含两个工具方法
1.	//获取控制台输入并返回String数据  
2.	//此方法为公开,返回值String类型    
3.	public String scannerString()  
4.	//获取控制台输入并返回int数据  
5.	//此方法为公开,返回值int类型    
6.	public int scannerInt()
~~~

# 功能实现

## 1.科室管理

该功能设计可以实现：新增科室、删除科室，修改科室，查看所有课室等操作，能够满足医院科室的日常部门管理
功能1：新增科室，运行程序后根据控制台提示信息如下：

~~~java
1.	   请输入操作命令，//这里省略大段指令提示信息展示  
2.	   ====================  
3.	   //用户输入上面展示的操作指令   
4.	   1  
5.	   //系统输出提示信息  
6.	   请输入科室名称  
7.	   //用户上面提示信息对应的输入数据   
8.	   心脏科  
9.	   //系统输出提示信息  
10.	   请输入科室描述  
11.	   //用户上面提示信息对应的输入数据   
12.	   心脏的科目  
13.	   //系统输出提示信息  
14.	   科室新增成功 
       功能2：查看所有科室，运行程序后根据控制台提示信息如下：
15.	   请输入操作命令，//这里省略大段指令提示信息展示  
16.	   ====================  
17.	   //用户输入上面展示的操作指令   
18.	   2  
19.	   ====================  
20.	   //系统输出展示数据  
21.	   科室Id  | 科室名称  | 科室描述  
22.	   科室Id=12, 科室名称='牙科', 科室描述='这是治疗牙齿的'  
23.	   科室Id=13, 科室名称='眼科', 科室描述='眼睛的科目'  
24.	   科室Id=14, 科室名称='脑科', 科室描述='脑子的科目'  
25.	   科室Id=16, 科室名称='心脏科', 科室描述='心脏的科目'  
26.	   ====================  
       功能3：修改科室，运行程序后根据控制台提示信息如下：
27.	   请输入操作命令，//这里省略大段指令提示信息展示  
28.	   ====================  
29.	   //用户输入上面展示的操作指令   
30.	   3  
31.	   //系统输出提示信息  
32.	   请输入想修改的科室ID  
33.	   //用户输入上面提示信息对应的输入数据   
34.	   16  
35.	   //系统输出提示信息  
36.	   请输入科室新的名称  
37.	   //用户输入上面提示信息对应的输入数据   
38.	   血液内科  
39.	   //系统输出提示信息  
40.	   请输入科室新的描述  
41.	   //用户输入上面提示信息对应的输入数据   
42.	   这是旧的心脏科，新的血液内科  
43.	   科室修改成功  
44.	   ====================  
       功能4：删除科室，运行程序后根据控制台提示信息如下：
45.	   请输入操作命令，//这里省略大段指令提示信息展示  
46.	   ====================  
47.	   //用户输入上面展示的操作指令    请输入操作命令  
48.	   4  
49.	   //系统输出提示信息  
50.	   请输入想删除的科室ID  
51.	   //用户输入上面提示信息对应的输入数据   
52.	   16  
53.	   //系统输出提示信息  
54.	   科室删除成功  
55.	   ====================  
       
~~~


---------

# Sql文件

SET NAMES utf8mb4; SET FOREIGN_KEY_CHECKS = 0; CREATE TABLE `doctor` ( `id` int(11) NOT NULL AUTO_INCREMENT,
         `doctor_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `age` int(11) NULL DEFAULT NULL,
         `specialty` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `join_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `describe1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         PRIMARY KEY (`id`)
USING BTREE ) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic; CREATE TABLE `ke_shi` ( `id` int(11) NOT NULL AUTO_INCREMENT,
         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `describe1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         PRIMARY KEY (`id`)
USING BTREE ) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic; CREATE TABLE `patient` ( `id` int(8) NOT NULL AUTO_INCREMENT,
         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `time_table_id` int(11) NOT NULL,
         `describe1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         PRIMARY KEY (`id`)
USING BTREE ) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic; CREATE TABLE `time_table` ( `id` int(11) NOT NULL AUTO_INCREMENT,
         `doctor_id` int(11) NULL DEFAULT NULL,
         `big_time` int(11) NULL DEFAULT NULL,
         `small_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
         `available_num` int(11) NULL DEFAULT NULL,
         PRIMARY KEY (`id`)
USING BTREE ) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic; SET FOREIGN_KEY_CHECKS = 1;
