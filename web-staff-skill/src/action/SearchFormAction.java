package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.FrontController;
import dao.Dao;

public class SearchFormAction implements Action {
	
	@Override
	public FrontController execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String staffName = request.getParameter("staffName");
		String gender01 = request.getParameter("gender01");
		String gender02 = request.getParameter("gender02");
		String[] religionName = request.getParameterValues("religionName");
		String[] graduate = request.getParameterValues("graduate");
		String[] skill = request.getParameterValues("skill");
		String date01 = request.getParameter("date01");
		String date02 = request.getParameter("date02");
		
		Dao dao = new Dao();
		if(staffName != null){
			//이름조회 셀렉트 실행
		}
		
		
		return null;
	}

}
