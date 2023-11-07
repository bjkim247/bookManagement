package model;

import java.util.Objects;

public class Video {
	private int no; 		// 비디오 일련번호
	private String name; 	// 이름
	private String type; 	// 종류

	public Video() {
		super();
	}

	public Video(int no, String name, String type) {
		super();
		this.no = no;
		this.name = name;
		this.type = type;
	}

	public Video(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%3d \t %-30s \t\t %-30s", no, name, type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, name);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Video))
			return false;
		Video other = (Video)obj;
		return no == other.no && Objects.equals(name, other.name);
	}
}
