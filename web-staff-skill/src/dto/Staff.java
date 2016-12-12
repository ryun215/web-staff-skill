package dto;

public class Staff {
	private int no;
	private String name;
	private String sn;
	private String graduateday;
	private int schoolNo;
	private int religionNo;
	public Staff() {
		super();
	}
	public Staff(int no, String name, String sn, String graduateday, int schoolNo, int religionNo) {
		super();
		this.no = no;
		this.name = name;
		this.sn = sn;
		this.graduateday = graduateday;
		this.schoolNo = schoolNo;
		this.religionNo = religionNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getGraduateday() {
		return graduateday;
	}
	public void setGraduateday(String graduateday) {
		this.graduateday = graduateday;
	}
	public int getSchoolNo() {
		return schoolNo;
	}
	public void setSchoolNo(int schoolNo) {
		this.schoolNo = schoolNo;
	}
	public int getReligionNo() {
		return religionNo;
	}
	public void setReligionNo(int religionNo) {
		this.religionNo = religionNo;
	}
	@Override
	public String toString() {
		return "Staff [no=" + no + ", name=" + name + ", sn=" + sn + ", graduateday=" + graduateday + ", schoolNo="
				+ schoolNo + ", religionNo=" + religionNo + "]";
	}

	
	
}
