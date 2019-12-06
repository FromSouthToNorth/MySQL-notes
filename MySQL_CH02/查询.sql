#建库语句
create database MySchool256;
use MySchool256;
#删除数据库
drop database MySchool256;
#建表操作
drop table Grade
CREATE table Grade
(
	gradeID int primary key AUTO_INCREMENT,
	gradeName enum('S1','S2','Y2')
);

drop table if EXISTS student;
CREATE TABLE student
(
	StudentNo char(20) not null primary key comment '学号' ,
  LoginPwd char(20) not null comment'密码' ,
	StudentName char(30) unique not null comment '姓名',
  Sex enum('男','女') ,
  GradeID int ,
  Phone char(20),
  Address varchar(50) DEFAULT '成都',
  BornDate TIMESTAMP DEFAULT now(),
  Email varchar(20),
  IndentityCard varchar(18),
	#外键
	FOREIGN key (GradeId) REFERENCES Grade(GradeID)
)comment '学生表';

ALTER table student add COLUMN Test varchar(20)

insert into grade(gradeName) value('S1')

select now();