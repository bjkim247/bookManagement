package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Rental;
import model.RentalPrint;

public class RENTALDAO {
	// 비디오 대여(실수)
	public void setRENTALRegiste(Rental tvo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = "insert into rental(no,id,video_no,rent_date) values(rental_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tvo.getId());
			pstmt.setInt(2, tvo.getVideoNo());
			pstmt.setString(3, tvo.getRentDate());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("비디오 대여 신청 완료.");
			} else {
				System.out.println("비디오 대여 신청 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 비디오 반납 
	public void setRENTALDelete(int num) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from rental where no = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("반납 완료.");
				System.out.println("반납 성공");
			} else {
				System.out.println("반납 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 개인 대여 신청 전체 목록
	public void getRENTALTotalList(int no) throws Exception {
		String sql = "select * from rental";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Rental tVo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			System.out.println("일련번호 \t\t비디오명\t장르");
			while (rs.next()) {
				tVo = new Rental();
//				tVo.setName(rs.getString("name"));
//				tVo.setType(rs.getString("type"));
				System.out.println(
						tVo.getNo() +  "\t" + rs.getString("name")
								+ "\t" + rs.getString("type"));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}
	
	//비디오 대여 전체 목록 리스트
	public void getRENTALTotalList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RentalPrint rp = null;
		ArrayList<RentalPrint> listRentalPrint = new ArrayList<RentalPrint>();
		try {
			con = DBUtil.getConnection();
			String sql = "select m.id, m.name, m.phone, v.name video_name, v.type, r.rent_date, r.return_date from member m, rental r, video v "
					+ "where m.id = r.id and r.video_no = v.no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rp = new RentalPrint();
				rp.setId(rs.getString("id"));
				rp.setName(rs.getString("name"));
				rp.setPhone(rs.getString("phone"));
				rp.setVidoName(rs.getString("video_name"));
				rp.setType(rs.getString("type"));
				rp.setRentDate(rs.getString("rent_date"));
				rp.setReturnDate(rs.getString("return_date"));
				System.out.println(rp.toString());
				listRentalPrint.add(rp);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}
	
	//가입한 회원 전체 비디오 대여 정보 리스트 
	public void getMemberRentalTotalList(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RentalPrint rp = null;
		ArrayList<RentalPrint> listRentalPrint = new ArrayList<RentalPrint>();
		try {
			con = DBUtil.getConnection();
			String sql = "select m.id, m.name, m.phone, v.name video_name, v.type, r.rent_date, r.return_date from member m, rental r, video v "
					+ "where m.id = r.id and r.video_no = v.no and r.id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rp = new RentalPrint();
				rp.setId(rs.getString("id"));
				rp.setName(rs.getString("name"));
				rp.setPhone(rs.getString("phone"));
				rp.setVidoName(rs.getString("video_name"));
				rp.setType(rs.getString("type"));
				rp.setRentDate(rs.getString("rent_date"));
				rp.setReturnDate(rs.getString("return_date"));
				System.out.println(rp.toString());
				listRentalPrint.add(rp);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	//비디오대여 반납처리
	public void setRentalReturn(String id, String videoName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = "update rental set return_date = sysdate "
					+ "where id= ? and video_no = (select no from video where name = ? )";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, videoName);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("비디오 대여 반납 완료.");
			} else {
				System.out.println("비디오 대여 반납 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
