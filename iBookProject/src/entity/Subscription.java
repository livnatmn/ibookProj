package entity;

public class Subscription {

	private int subscriptionID;
	private String subscriptionName;
	private int subscriptionPrice;
	
	public Subscription(){
		this.subscriptionName="";
		this.subscriptionPrice=0;
	}
	public int GetSubscriptionID(){return subscriptionID;}
	
	public String GetSubscriptionName(){return subscriptionName;}
	
	public int GetSubscriptionPrice(){return subscriptionPrice;}
	
	public void SetSubscriptionID(int subscriptionID){this.subscriptionID=subscriptionID;}
	
	public void SetSubscriptionName(String subscriptionName){this.subscriptionName=subscriptionName;}
	
	public void SetSubscriptionPrice(int subscriptionPrice){this.subscriptionPrice=subscriptionPrice;}
}
