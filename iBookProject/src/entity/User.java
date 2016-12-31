package entity;

public class User {
	private String userName;
	private String password;
	private String personID;
	private boolean isConnect;
	private boolean isPaying;
	private int privilege;
	private boolean isApproved;
	private int subscriptionID;
	private String subscriptionDueDate;
	
	public User() {
		this.userName = "";
		this.password = "";
		this.personID = "";
		this.isConnect = false;
		this.isPaying = false;
		this.privilege = 0;
		this.isApproved = false;
		this.subscriptionID = 0;
		this.subscriptionDueDate = "";
	}

	public String GetUserName() {
		return userName;
	}

	public void SetUserName(String userName) {
		this.userName = userName;
	}

	public String GetPassword() {
		return password;
	}

	public void SetPassword(String password) {
		this.password = password;
	}

	public String GetPersonID() {
		return personID;
	}

	public void SetPersonID(String personID) {
		this.personID = personID;
	}

	public boolean GetConnect() {
		return isConnect;
	}

	public void SetConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}

	public boolean GetPaying() {
		return isPaying;
	}

	public void SetPaying(boolean isPaying) {
		this.isPaying = isPaying;
	}

	public int GetPrivilege() {
		return privilege;
	}

	public void SetPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public boolean GetApproved() {
		return isApproved;
	}

	public void SetApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int GetSubscriptionID() {
		return subscriptionID;
	}

	public void SetSubscriptionID(int subscriptionID) {
		this.subscriptionID = subscriptionID;
	}

	public String GetSubscriptionDueDate() {
		return subscriptionDueDate;
	}

	public void SetSubscriptionDueDate(String subscriptionDueDate) {
		this.subscriptionDueDate = subscriptionDueDate;
	}
	
	
}
