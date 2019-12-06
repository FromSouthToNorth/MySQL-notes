insert into subject(SubjectName,ClassHour,GradeId)
values('C++',90,1)

insert into `subject`(SubjectName,ClassHour,GradeId)
VALUES('C++',90,1),('C++',90,1),('C++',90,1)

update subject set SubjectName='B++',ClassHour=90
where subjectName='B++'

delete from `subject` where subjectID=20

TRUNCATE table subject

create table newSubject(
	select * from subject where gradeID=1
)

select sum(classHour) from `subject`
where gradeID=1

select count(1) from `subject`
where gradeID=1

select * from student

select substring('好喜欢你哟',2,3)
select * from student order by borndate;
select * from student order by borndate desc
limit 0,3


select * from student


select studentNo as 学号,studentName as 姓名,LoginPwd as 密码 from student


select * from student where gradeID=1
and sex='男'
#姓王的学生说
select * from student where studentName like '王%'
#出生的年在88~95之间
select * from student where year(borndate)
between 1988 and 1995

select * from student where year(borndate)
in(1988,1989,1990)
#每  聚合函数
#每个年级各多少人
select GradeID,count(1) from student group by GradeID
#每门课的平局分
select subjectID,avg(Studentresult)
 from result group by subjectID
#每个学生每门课的最高分
select  StudentNo,subjectID,max(Studentresult) 
from result group by StudentNo,subjectID
#大一男女生各多少 每
select sex,count(1) from student where gradeID=1
group by sex

#查询平局分高于60的课程信息
select subjectID,avg(Studentresult)
 from result group by subjectID 
 having  avg(Studentresult)>60

#大一学生

select * from student 
full join grade on 
student.GradeID =grade.GradeID

#查询大一的所有的学生信息
select * from student where gradeID=(
	select gradeID from grade where gradeName='大一'
)
#大一的年级编号
select gradeID from grade where gradeName='大一'
#查询年龄比王美丽小的学生信息
#查询出生日期大于王美丽的出生日期的学生信息
select * from student where borndate>(
	select borndate from student 
	where studentName='王美丽'
)
select borndate from student 
where studentName='王美丽'
#查询java课程考试成绩考了60分的学生的信息比
#如姓名 email 电话
select * from student where studentNO not in(
	#java考了60分的学生的学号
		select studentNo from result where studentresult=60
	and subjectID=(
		select subjectID from subject where subjectName='java'
	)
)
#java考了60分的学生的学号
select studentNo from result where studentresult=60
and subjectID=(
	select subjectID from subject where subjectName='java'
)
#java的课程编号
select subjectID from subject where subjectName='java'

#查询参加了最近一次java考试并且及格了的学生信息

select * from student where studentNo in(
	#查询参加了最近一次java考试并且及格了的学生的学号
	select studentNo from result where subjectID=(select subjectID from `subject`
where subjectName='java') and examdate =(select max(examdate) from result where subjectID=(
	select subjectID from `subject` where subjectName='java'
)) and studentresult>=60
)
#查询参加了最近一次java考试并且及格了的学生的学号
select studentNo from result where subjectID=(select subjectID from `subject`
where subjectName='java') and examdate =(select max(examdate) from result where subjectID=(
	select subjectID from `subject` where subjectName='java'
)) and studentresult>=60
#java的编号
select subjectID from `subject` where subjectName='java'
#java最近一次的时间
select max(examdate) from result where subjectID=(
	select subjectID from `subject` where subjectName='java'
)
show databases
show TABLE
