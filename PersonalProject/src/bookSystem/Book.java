package bookSystem;

public class Book {

	private String bNo;
	private String title;
	private String genre;
	private String author;
	private String company;
	private String date;
	private String price;

	public Book(String bNo, String title, String genre, String author, String company, String date, String price) {
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
		this.date = date;
		this.price = price;
	}

	public Book(String bNo, String title, String genre, String author, String company, String date) {
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
		this.date = date;
	}

	public Book(String bNo, String title, String genre, String author, String company) {
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.company = company;
	}

	public Book(String bNo, String title, String genre, String author) {
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
		this.author = author;
	}

	public Book(String bNo, String title, String genre) {
		this.bNo = bNo;
		this.title = title;
		this.genre = genre;
	}

	public Book(String bNo, String title) {
		this.bNo = bNo;
		this.title = title;
	}

	public Book(String bNo) {
		this.bNo = bNo;
	}

	public Book() {

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bNo=" + bNo + ", title=" + title + ", genre=" + genre + ", author=" + author + ", company="
				+ company + ", date=" + date + ", price=" + price + "]";
	}

}
