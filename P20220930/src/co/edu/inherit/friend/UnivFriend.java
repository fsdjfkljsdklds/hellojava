package co.edu.inherit.friend;

public class UnivFriend extends Friend {
	private String univ;
	private String major;

	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); // Friend(String name, String phone);
		this.univ = univ;
		this.major = major;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUniv() {
		return this.univ;
	}

	public String getMajor() {
		return this.major;
	}

	@Override
	public String showInfo() {
		// 대학친구 정보
		return "학교친구의 이름은 " + getName() //
		+ ", 연락처는 "+ getPhone() //
		+ ", 학교명은 " + this.univ // 
		+ ", 전공은 " + this.major + "입니다."; //  
	}

}
