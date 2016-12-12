package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Religion;
import dto.School;
import dto.Skill;
import dto.Staff;
import dto.StaffSkill;

public class Dao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Religion> religion;
	Religion r;
	ArrayList<School> school;
	School s;
	ArrayList<Skill> skill;
	Skill sk;

	
	
	
	
	
	//스태프스킬 입력
	public int staffSkillInsert(int generatedkey, int skillno){
		System.out.println("staffSkillInsert 메소드 실행");
		int rowCount = 0;
		try{
			DBUtill db = new DBUtill();
			conn = db.getConnection();
			String sql = "insert into staffskill(staffno,skillno) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, generatedkey);
			pstmt.setInt(2, skillno);
			rowCount = pstmt.executeUpdate();
			System.out.println("rowCount 확인 :"+rowCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, pstmt, null);
		}
		return rowCount;
		
	}

	// 스태프 입력명령 처리
	public int staffInsert(Staff staff){
		System.out.println("staffInsert 메소드 실행");
		int generatedkey = 0;
		try{
			DBUtill db = new DBUtill();
			conn = db.getConnection();
			System.out.println("staff이름값 넘어오는지 확인 :"+ staff.getName());
			String sql = "insert into staff(name,sn,graduateday,schoolno,religionno) values(?,?,?,?,?)";			
			pstmt = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, staff.getName());
			pstmt.setString(2, staff.getSn());
			pstmt.setString(3, staff.getGraduateday());
			pstmt.setInt(4, staff.getSchoolNo());
			pstmt.setInt(5, staff.getReligionNo());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				generatedkey = rs.getInt(1);
			}
			
			System.out.println("generatedkey 확인 :"+generatedkey);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, pstmt, null);
			
		}
		return generatedkey;
		
	}

	
	// 스킬 셀렉트
		public ArrayList<Skill> selectSkill(){
			skill = new ArrayList<Skill>();
			try{
				DBUtill db = new DBUtill();
				conn = db.getConnection();
				String sql = "SELECT no, name FROM skill";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("rs셀렉트확인 :"+rs);
				while(rs.next()){
					sk = new Skill();
					sk.setNo(rs.getInt("no"));
					sk.setName(rs.getString("name"));
					skill.add(sk);
					
				}

			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, pstmt, rs);
			}
			return skill;
		}
		
	// 학력 셀렉트
	public ArrayList<School> selectSchool(){
		school = new ArrayList<School>();
		try{
			DBUtill db = new DBUtill();
			conn = db.getConnection();
			String sql = "SELECT no, graduate FROM school";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("rs셀렉트확인 :"+rs);
			while(rs.next()){
				s = new School();
				s.setNo(rs.getInt("no"));
				s.setGraduate(rs.getString("graduate"));
				school.add(s);
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(conn, pstmt, rs);
		}
		return school;
	}
	
	//종교 목록 셀렉트
		public ArrayList<Religion> selectReligion(){
			religion = new ArrayList<Religion>();
			try{
				DBUtill db = new DBUtill();
				conn = db.getConnection();
				String sql = "SELECT no, name FROM religion";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("rs셀렉트확인 :"+rs);
				while(rs.next()){
					r = new Religion();
					r.setNo(rs.getInt("no"));
					r.setName(rs.getString("name"));
					religion.add(r);
				}
	
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.close(conn, pstmt, rs);
			}
			return religion;
		}
		
		public void close(Connection conn, Statement pstmt, ResultSet rs){
			if(rs != null){
				try{rs.close();}
				catch(Exception e){}
			}
			if(pstmt != null){
				try{pstmt.close();}
				catch(Exception e){}
			}
			if(conn != null){
				try{conn.close();}
				catch(Exception e){}
			}
}
}
