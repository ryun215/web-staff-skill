package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.FrontController;

	public interface Action {

		public FrontController execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
		
}
