package dto;

public class StaffSkill {
	private int no;
	private int staffNo;
	private int skillNo;
	public StaffSkill() {
		super();
	}
	public StaffSkill(int no, int staffNo, int skillNo) {
		super();
		this.no = no;
		this.staffNo = staffNo;
		this.skillNo = skillNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(int staffNo) {
		this.staffNo = staffNo;
	}
	public int getSkillNo() {
		return skillNo;
	}
	public void setSkillNo(int skillNo) {
		this.skillNo = skillNo;
	}
	@Override
	public String toString() {
		return "StaffSkill [no=" + no + ", staffNo=" + staffNo + ", skillNo=" + skillNo + "]";
	}
	
	
	
}
