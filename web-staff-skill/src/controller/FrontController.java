package controller;

public class FrontController {
	//�������� �ϳ��� �������Ұ��ΰ�?�����̷�Ʈ�Ұ��ΰ�?
		//�������� �ι�°�� ���
		private boolean isRedirect=false;
		private String path=null;
		
		public boolean isRedirect() {
			return isRedirect;
		}
		public void setRedirect(boolean isRedirect) {
			System.out.println("isRedirect �� Ȯ��"+isRedirect);
			this.isRedirect = isRedirect;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			System.out.println("�̵���ų ��� path�� Ȯ�� :"+path);
			this.path = path;
		}
}
