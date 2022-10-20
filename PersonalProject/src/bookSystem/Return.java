package bookSystem;

public class Return {

	private String bNo;
	private String title;
	private String genre;
	private String author;
	private String company;
	private String price;
	private String inputdate;
	private String available;

	public Return(String bNo, String title, String genre, String author, String company, String price, String inputdate,
			String available) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
		this.price = price;
		this.inputdate = inputdate;
		this.available = available;
	}

	public Return(String bNo, String title, String available) {
		this.bNo = bNo;
		this.title = title;
		this.available = available;
	}

	public Return(String bNo, String title, String genre, String author, String company, String price,
			String inputdate) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
		this.price = price;
		this.inputdate = inputdate;
	}

	public Return(String bNo, String title, String genre, String author, String company, String price) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
		this.price = price;
	}

	public Return(String bNo, String title, String genre, String author, String company) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
	}

	public Return(String bNo, String title, String genre, String author) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
	}

	public Return(String bNo, String title) {
		super();
		this.bNo = bNo;
		this.title = title;
	}

	public Return(String bNo) {
		super();
		this.bNo = bNo;
	}

	public Return() {
		super();
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "대여목록 도서번호:" + bNo + "\n" + "       도서제목:" + title + "\n" + "       >> 대여" + available + " <<";
	}
}