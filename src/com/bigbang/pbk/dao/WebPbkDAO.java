package com.bigbang.pbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bigbang.pbk.vo.WebPbkVO;

public class WebPbkDAO {

	public WebPbkVO login(String id, String pw) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		DBConnection dbCon 		= DBConnection.getInstance();
		WebPbkVO person 		= new WebPbkVO();
		
		StringBuilder query 	= new StringBuilder();
		query.append("SELECT id					");
		query.append("     , pw         		");
		query.append("     , name         		");
		query.append("  FROM webpbk_login		");
		query.append(" WHERE id = ?				");
		query.append("   AND pw = ?				");
		
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				person.setId(rs.getString("id"));
				person.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs != null) {
					rs.close();
					dbCon.close(con, pstmt);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return person;
	}
	
	public ArrayList<WebPbkVO> selectAll(){
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		DBConnection dbCon 		= null;
		
		ArrayList<WebPbkVO> people 	= new ArrayList<WebPbkVO>();
		StringBuilder query 		= new StringBuilder();
		
		query.append("SELECT p.id						");
		query.append("     , p.name 					");
		query.append("     , p.phone1 					");
		query.append("     , p.phone2 					");
		query.append("     , p.phone3 					");
		query.append("     , g.group_name AS	 gpnm	");
		query.append("  FROM webpbk p					");
		query.append("     , webpbk_group g			 	");
		query.append(" WHERE p.group_num = g.group_num	");
		
		try {
			dbCon = DBConnection.getInstance();
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WebPbkVO person = new WebPbkVO();
//				person.setId(rs.getString("id"));
				person.setName(rs.getString("name"));
				person.setPhone1(rs.getString("phone1"));
				person.setPhone2(rs.getString("phone2"));
				person.setPhone3(rs.getString("phone3"));
				person.setGpnm(rs.getString("gpnm"));
				
				people.add(person);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dbCon.close(con, pstmt);
		}
		return people;
	}
	
	public ArrayList<WebPbkVO> selectAll(String id){
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		DBConnection dbCon 		= null;
		
		ArrayList<WebPbkVO> people 	= new ArrayList<WebPbkVO>();
		StringBuilder query 		= new StringBuilder();
		
		query.append("SELECT p.name	 					");
		query.append("     , p.phone1 					");
		query.append("     , p.phone2 					");
		query.append("     , p.phone3 					");
		query.append("     , g.group_name AS	 gpnm	");
		query.append("  FROM webpbk p					");
		query.append("     , webpbk_group g			 	");
		query.append(" WHERE p.group_num = g.group_num	");
		query.append("   AND id = ?						");
		
		try {
			dbCon = DBConnection.getInstance();
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WebPbkVO person = new WebPbkVO();
				person.setName(rs.getString("name"));
				person.setPhone1(rs.getString("phone1"));
				person.setPhone2(rs.getString("phone2"));
				person.setPhone3(rs.getString("phone3"));
				person.setGpnm(rs.getString("gpnm"));
				
				people.add(person);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dbCon.close(con, pstmt);
		}
		return people;
	}
	
	public WebPbkVO updatePbk(String id) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		DBConnection dbCon 		= DBConnection.getInstance();
		WebPbkVO person 		= null;
		StringBuilder query		= new StringBuilder();
		
		query.append("UPDATE webpbk				");
		query.append("   SET name = ?			");
		query.append("     , phone1 = ?			");
		query.append("     , phone2 = ?			");	
		query.append("     , phone3 = ?			");
		query.append("     , group_num = ?		");
		query.append(" WHERE id = ?				");
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, "name");
			pstmt.setString(2, "phone1");
			pstmt.setString(3, "phone2");
			pstmt.setString(4, "phone3");
			pstmt.setString(5, "gpnm");
			pstmt.setString(6, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				person = new WebPbkVO();
				
				person.setName(rs.getString("name"));
				person.setId(rs.getString("id"));
				person.setPw(rs.getString("pw"));
				person.setPhone1(rs.getString("phone1"));
				person.setPhone2(rs.getString("phone2"));
				person.setPhone3(rs.getString("phone3"));
				person.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				dbCon.close(con, pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return person;
	}

	public void insert(WebPbkVO person) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		DBConnection dbCon 		= DBConnection.getInstance();
		String query 			= "INSERT INTO WebPbk_login VALUES(?,?,?,?,?,?,?)";
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getId());
			pstmt.setString(3, person.getPw());
			pstmt.setString(4, person.getPhone1());
			pstmt.setString(5, person.getPhone2());
			pstmt.setString(6, person.getPhone3());
			pstmt.setString(7, person.getGender());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt);
		}
	}

	public void insertPbk(WebPbkVO person) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		DBConnection dbCon 		= DBConnection.getInstance();
		StringBuilder query 	= new StringBuilder();
		
		query.append("INSERT INTO webpbk (id			");
		query.append("					, name			");
		query.append("					, phone1		");
		query.append("		   		    , phone2		");
		query.append("				    , phone3		");
		query.append("				    , group_num) 	");
		query.append("	   VALUES (?					");
		query.append("  		,  ?					");
		query.append("  	 	,  ?					");
		query.append("  	 	,  ?					");
		query.append("  	  	,  ?					");
		query.append("  	  	,  ?)					");
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getName());
			pstmt.setString(3, person.getPhone1());
			pstmt.setString(4, person.getPhone2());
			pstmt.setString(5, person.getPhone3());
			pstmt.setString(6, person.getGpnm());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt);
		}
	}
	
	public void update(WebPbkVO person) {
		Connection con = null;
		PreparedStatement pstmt = null;
		DBConnection dbCon = DBConnection.getInstance();
		StringBuilder query = new StringBuilder();
		
		query.append("UPDATE webpbk_login	");
		query.append("   SET name = ?		");
		query.append("     , pw = ?			");
		query.append("     , phone1 = ?		");
		query.append("     , phone2 = ?		");
		query.append("     , phone3 = ?		");
		query.append("     , gender = ?		");
		query.append(" WHERE id = ?			");
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getPw());
			pstmt.setString(3, person.getPhone1());
			pstmt.setString(4, person.getPhone2());
			pstmt.setString(5, person.getPhone3());
			pstmt.setString(6, person.getGender());
			pstmt.setString(7, person.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbCon.close(con, pstmt);
		}
	}
	public WebPbkVO selectById(String id) {
		Connection con 			= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		WebPbkVO person			= null;
		DBConnection dbCon		= DBConnection.getInstance();
		StringBuilder query 	= new StringBuilder();
		
		query.append("SELECT *				");
		query.append("  FROM webpbk_login	");
		query.append(" WHERE id = ?			");
		
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				person = new WebPbkVO();
				person.setName(rs.getString("name"));
				person.setPw(rs.getString("pw"));
				person.setPhone1(rs.getString("phone1"));
				person.setPhone2(rs.getString("phone2"));
				person.setPhone3(rs.getString("phone3"));
				person.setGender(rs.getString("gender"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				dbCon.close(con, pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return person;
	}
}


//public void updateLogin(WebPbkVO person) {
//Connection con 			= null;
//PreparedStatement pstmt = null;
//DBConnection dbCon 		= DBConnection.getInstance();
//StringBuilder query 	= new StringBuilder();
//
//query.append("UPDATE webpbk_login	");
//query.append("   SET name = ?		");
//query.append("     , pw = ?			");
//query.append("     , phone1 = ?		");
//query.append("     , phone2 = ?		");
//query.append("     , phone3 = ?		");
//query.append("     , gender = ?		");
//query.append(" WHERE id = ?			");
//
//try {
//	con = dbCon.getConnection();
//	pstmt = con.prepareStatement(query.toString());
//	pstmt.setString(1, person.getName());
//	pstmt.setString(2, person.getPw());
//	pstmt.setString(3, person.getPhone1());
//	pstmt.setString(4, person.getPhone2());
//	pstmt.setString(5, person.getPhone3());
//	pstmt.setString(6, person.getGender());
//	pstmt.setString(7, person.getId());
//	pstmt.executeQuery();
//}catch(Exception e) {
//	e.printStackTrace();
//}finally {
//	dbCon.close(con, pstmt);
//}
//}