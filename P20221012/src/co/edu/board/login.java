package co.edu.board;

public class login {
	private String id;
	private String passwd;
	private String name;

	public login() {

	}
	
	public login(String id) {
		this.id = id;
	}

	public login(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}

	public login(String id, String passwd, String name) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "login [id=" + id + ", passwd=" + passwd + ", name=" + name + "]";
	}

}