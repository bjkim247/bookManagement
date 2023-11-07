package model;

public class Member {
	private int no; 		// 회원 일련번호
	private String id; 		// 아이디
	private String name; 	// 이름
	private String passwd; 	// 비밀번호
	private String phone; 	// 핸드폰번호
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int no, String id, String name, String passwd, String phone) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.phone = phone;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", name=" + name + ", passwd=" + passwd + ", phone=" + phone + "]";
	}
	
}
