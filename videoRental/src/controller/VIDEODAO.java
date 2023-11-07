package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Video;

public class VIDEODAO {
	// 비디오 목록 
	public void getVIDEOTotalList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Video sVo = null;
		ArrayList<Video> videoList = new ArrayList<Video>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from video order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String printTitle = String.format("%-3s \t %-30s \t\t %-30s","번호", "비디오명", "장르");
			System.out.println(printTitle);
			while (rs.next()) {
				sVo = new Video();
				sVo.setNo(rs.getInt("no"));
				sVo.setName(rs.getString("name"));
				sVo.setType(rs.getString("type"));
				videoList.add(sVo);
				System.out.println(sVo.toString());
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

	// 비디오 등록 
	public void setVIDEORegistr(Video svo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection(); 
			String sql = "insert into video values (video_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getName()); 
			pstmt.setString(2, svo.getType());
			int i = pstmt.executeUpdate(); 
			if (i == 1) {
				System.out.println(svo.getName() + " 비디오 등록 완료.");
			} else {
				System.out.println("비디오 등록 실패!!!");
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

	// 비디오 수정 
	public void setVIDEOUpdate(Video svo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = "update video set name=?, type=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getName());
			pstmt.setString(2, svo.getType());
			pstmt.setInt(3, svo.getNo());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(svo.getName() + " 비디오 수정 완료.");
				System.out.println("비디오 수정 성공!!!");
			} else {
				System.out.println("비디오 수정 실패!!!");
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

	// 비디오 삭제 
	public void setVIDEODelete(int no) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false; 
		RENTALDAO rt = new RENTALDAO(); 
		try {
			con = DBUtil.getConnection();
			//자동 커밋을 처리하지 못하게 막는다.
			con.setAutoCommit(false);
			//비디오 대여에서 참조하고 있는 비디오번호를 -> null 만들어야한다.
			String sql = "update rental set video_no = null where video_no = ?"; 
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if (i != 0) {
				System.out.println("비디오대여 테이블 반납진행 완료.");
			} else {
				System.out.println("비디오대여 테이블 대여이력 없음.");
			}
			//비디오 테이블에서 해당되는 비디오를 삭제
			String sql2= "delete from video where no = ?";
			pstmt = con.prepareStatement(sql2.toString());
			pstmt.setInt(1, no);
			int i2 = pstmt.executeUpdate();
			if (i2 == 1) {
				System.out.println("비디오 테이블 삭제완료.");
				success = true; 
			} else {
				System.out.println("비디오 테이블 삭제불가.");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if(success == true) {
					con.commit();
				}else {
					con.rollback();
				}
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
