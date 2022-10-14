package co.edu.moring;

public class Member {
	private String id;
	private String name;
	private String point;

	public Member(String id, String name, String point) {
		this.id = id;
		this.name = name;
		this.point = point;
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

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "회원아이디    회원이름    회원포인트" + "\n" + "  " + id + "   " + "  " + name + "      " + point + "";
	}

}
