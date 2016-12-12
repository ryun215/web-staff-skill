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
		System.out.println("입력명령 처리 메소드 실행");
		
		String staffName = request.getParameter("staffName");
		String staffNum =  request.getParameter("staffNum1")+"-"+request.getParameter("staffNum2");
		int religionNo = Integer.parseInt(request.getParameter("religionName"));
		int graduateNo = Integer.parseInt(request.getParameter("graduate"));
		String[] skill = request.getParameterValues("skill");
		String graduateday = request.getParameter("date");
		
		System.out.println("스텝이름 : "+staffName);
		System.out.println("주민번호 : "+staffNum);
		System.out.println("종교별 숫자 : "+religionNo);
		System.out.println("학력별 숫자 : "+ graduateNo);
//		System.out.println("스킬 : "+skill[0]);
		System.out.println("날짜 : "+graduateday);
		
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
