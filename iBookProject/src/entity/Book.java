package entity;

public class Book {
	private int bookID;
	private String title;
	private int languageID; 
	private String content;
	private String summary;
	private String keyWords;
	private int formatID;
	private boolean visibilityStatus;
	private float price;
	
	public Book()
	{
		bookID = 0;
		title = "";
		languageID = 0;
		content = "";
		summary = "";
		keyWords = "";
		formatID = 0;
		visibilityStatus = true; // appears for user
		price = 0;
	}
	
}
