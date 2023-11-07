package model;

public class RentalPrint {
	private String id; 			//member id
	private String name; 		//member name
	private String phone; 		//member phone
	private String vidoName;	//video name
	private String type; 		//video type
	private String rentDate; 	//video rent date
	private String returnDate; 	//video return date
	public RentalPrint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RentalPrint(String id, String name, String phone, String vidoName, String type, String rentDate,
			String returnDate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.vidoName = vidoName;
		this.type = type;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVidoName() {
		return vidoName;
	}
	public void setVidoName(String vidoName) {
		this.vidoName = vidoName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String toString() {
		return "RentalPrint [id=" + id + ", name=" + name + ", phone=" + phone + ", vidoName=" + vidoName + ", type="
				+ type + ", rentDate=" + rentDate + ", returnDate=" + returnDate + "]";
	}
	
}
