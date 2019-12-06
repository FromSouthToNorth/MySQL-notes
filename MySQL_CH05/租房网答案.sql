#查询输出第6条～第10条出租房屋信息
SELECT * from hos_house limit 5,5

#张三出租的房屋
select * from hos_house inner join hos_street
on hos_house.sid=hos_street.sid inner join hos_district
on hos_street.sdid=hos_district.did where uid=(
	select uid from sys_user where uname='张三'
)
#为至少有两个街道有出租房屋的区县
#制作出租房屋清单
#查询出来 每个区县 每条街道房屋的出租数量
select * from hos_house inner join hos_street
on hos_house.sid=hos_street.sid inner join hos_district
on hos_street.sdid=hos_district.did INNER JOIN hos_type
on hos_house.htid=hos_type.HTID inner join sys_user
on hos_house.uid=sys_user.uid where did in(
	select temp.did from 
	(select did,hos_street.sid from hos_house inner join hos_street
	on hos_house.sid=hos_street.sid 
	inner join hos_district on hos_street.sdid=hos_district.did
	group by did,hos_street.sid )as temp
	group by temp.did HAVING count(1)>1
)

#
#每个季度房屋出租的总数量
SELECT QUARTER(htime)as 季度,' 合计' as 区县,
''as 街道,''as 户型, count(1) as 房屋数量 
from hos_house group by QUARTER(htime)
union
#每个季度 每个区县 出租的总数量
select QUARTER(htime),DNAME,' 小计','',count(1) from hos_house inner join hos_street
on hos_house.sid=hos_street.sid inner join hos_district
on hos_street.sdid=hos_district.did group by QUARTER(htime),DNAME
union
#每个季度 每个区县 每条街道 每种户型
select QUARTER(htime),DNAME,SNAME,HTNAME,count(1) from hos_house inner join hos_street
on hos_house.sid=hos_street.sid inner join hos_district
on hos_street.sdid=hos_district.did inner join hos_type
on hos_house.htid=hos_type.HTID group by QUARTER(htime),DNAME,SNAME,HTNAME
order by 1,2,3,4


