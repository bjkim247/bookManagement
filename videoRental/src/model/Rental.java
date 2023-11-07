package model;

import java.util.Objects;

public class Rental {
	private int no;  			// 랜탈 일련번호
	private String id;  		// 회원 일련번호
	private int videoNo;  		// 비디오 일련번호
	private String rentDate;  	// 대여날짜
	private String returnDate; 	// 반납날짜
	
	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rental(int no, String id, int videoNo, String rentDate, String returnDate) {
		super();
		this.no = no;
		this.id = id;
		this.videoNo = videoNo;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVideoNo() {
		return videoNo;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash( no, id, videoNo);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Rental) )
			return false; 
		Rental other = (Rental) obj;
		return no == other.no && id.equals(other.id) && videoNo == other.videoNo;
	}
}
