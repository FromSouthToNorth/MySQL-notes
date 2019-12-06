package manmager;

import dao.impel.StudentImpel;

public class Menu {
	StudentImpel stuImpel=new StudentImpel();
	public void printMenu()
	{
		System.out.println("------------------xxx学生管理系统-----------------");
		System.out.println("1.新增学生 2.删除学生");
		int num=1;
		if(num==1){
			
			
			
			//stuImpel.addStudent(stu);
		}else if(num==2){
			
			//stuImpel.delStudent(stuNo);
		}
	}
}
