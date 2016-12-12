package controller;

public class FrontController {
	//전역변수 하나는 포워드할것인가?리다이렉트할것인가?
		//전역변수 두번째는 경로
		private boolean isRedirect=false;
		private String path=null;
		
		public boolean isRedirect() {
			return isRedirect;
		}
		public void setRedirect(boolean isRedirect) {
			System.out.println("isRedirect 값 확인"+isRedirect);
			this.isRedirect = isRedirect;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			System.out.println("이동시킬 경로 path값 확인 :"+path);
			this.path = path;
		}
}
