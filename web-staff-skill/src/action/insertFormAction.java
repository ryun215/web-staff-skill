package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.FrontController;
import dao.Dao;
import dto.Staff;
import dto.StaffSkill;

public class insertFormAction implements Action {

	@Override
	public synchronized FrontController execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		System.out.println("�Է¸�� ó�� �޼ҵ� ����");
		
		String staffName = request.getParameter("staffName");
		String staffNum =  request.getParameter("staffNum1")+"-"+request.getParameter("staffNum2");
		int religionNo = Integer.parseInt(request.getParameter("religionName"));
		int graduateNo = Integer.parseInt(request.getParameter("graduate"));
		String[] skill = request.getParameterValues("skill");
		String graduateday = request.getParameter("date");
		
		System.out.println("�����̸� : "+staffName);
		System.out.println("�ֹι�ȣ : "+staffNum);
		System.out.println("������ ���� : "+religionNo);
		System.out.println("�зº� ���� : "+ graduateNo);
//		System.out.println("��ų : "+skill[0]);
		System.out.println("��¥ : "+graduateday);
		
		Staff staff = new Staff();
		staff.setName(staffName);
		staff.setSn(staffNum);
		staff.setSchoolNo(graduateNo);
		staff.setReligionNo(religionNo);
		staff.setGraduateday(graduateday);
		Dao dao = new Dao();
		int generatedkey = dao.staffInsert(staff);
		
	
		StaffSkill staffskill = new StaffSkill();
		Dao dao2 = new Dao();
		
		
		for(int i = 0; i < skill.length ; i++){
			int skillno = Integer.parseInt(skill[i]);
			
			dao2.staffSkillInsert(generatedkey, skillno);
		}
		
	
		
		
		return null;
	}
}
