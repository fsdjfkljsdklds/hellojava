package bookSystem;

public class Borrow {

	private String bNo;
	private String title;
	private String genre;
	private String author;
	private String company;
	private String price;
	private String inputdate;
	private String available;

	public Borrow(String bNo, String title, String genre, String author, String company, String price, String inputdate,
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

	public Borrow(String bNo, String title, String genre, String author, String company, String price,
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

	public Borrow(String bNo, String title, String genre, String author, String company, String price) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
		this.price = price;
	}

	public Borrow(String bNo, String title, String genre, String author, String company) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
	}

	public Borrow(String bNo, String title, String genre, String author) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
	}

	public Borrow(String bNo, String title, String genre) {
		super();
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
	}

	public Borrow(String bNo, String title) {
		super();
		this.bNo = bNo;
		this.title = title;
	}

	public Borrow(String bNo) {
		super();
		this.bNo = bNo;
	}

	public Borrow() {
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
		return "=============================="//
				+ "\n" + "[도서목록] 도서번호:" + bNo + "\n" + "         도서명:" + title + "\n"
				+ "         장르:" + genre + "\n" + "         작가명:" + author + "\n" + "         출판사:" + company + "\n"
				+ "         등록일:" + price + "\n" + "         가격:" + inputdate + "\n" + "       >> 대여" + available + " <<";
//		public String toString() {
//			return "=============================="
//					+ ""+"\n"+"[도서목록] 도서번호:" + bNo + "\n" + "         도서명:" + title + "\n" + "         장르:" + genre + "\n" + "         작가명:"
//					+ author + "\n" + "         출판사:" + company + "\n" + "         등록일:" + price + "\n" + "         가격:"
//					+ inputdate+"원" ;
//		}
	}
}