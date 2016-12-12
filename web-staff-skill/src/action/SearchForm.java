package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.FrontController;
import dao.Dao;
import dto.Religion;
import dto.School;
import dto.Skill;

public class SearchForm implements Action {
	ArrayList<Religion> religion = new ArrayList<Religion>();
	ArrayList<School> school = new ArrayList<School>();
	ArrayList<Skill> skill = new ArrayList<Skill>();
	
	@Override
	public FrontController execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Dao dao = new Dao();
		religion = dao.selectReligion();
		System.out.println("religion 확인 : "+religion.get(1));
		
		Dao dao2 = new Dao();
		school = dao2.selectSchool();
		System.out.println("school 확인 : "+school.get(1));
		
		Dao dao3 = new Dao();
		skill = dao3.selectSkill();

		request.setAttribute("religion", religion);
		request.setAttribute("school", school);
		request.setAttribute("skill", skill);
		
		FrontController front = new FrontController();
		front.setPath("/WEB-INF/jsp/staffSearch.jsp");
		front.setRedirect(false);
		System.out.println("경로확인 : "+front.getPath());
		return front;
	}
	
}
