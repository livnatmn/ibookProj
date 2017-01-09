package controller;

import entity.Subscription;
import java.util.Date;
import java.util.ArrayList;
import java.sql.*;

import entity.*;

public class SubscriptionController {
	
	public Subscription sbscrptn=new Subscription();
	public Subscription[] subArr  = new Subscription[2];
	
	public boolean getSubscriptionDetails(int subscriptionID)
	{
		ArrayList<String> arr_results;
		String queryReq = "GET:SELECT * FROM subscription WHERE subscriptionID=\""+subscriptionID+"\";";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		System.out.println("SubscriptionController-getSubscriptionDetails-arrRes::");
		for(int i=0; i<arr_results.size(); i++)
			System.out.println(arr_results.get(i));
		
		return InsertValsToSubscription(arr_results);
	}
	
	private boolean InsertValsToSubscription(ArrayList<String> arr_results)
	{
		if(arr_results.isEmpty())
			return false;
		String[] vals = new String[9];
		String[] res = arr_results.get(0).split(",");

		// Complete missing fields value.
		for(int ind=0; ind<vals.length; ind++)
		{
			if(ind<res.length)
				vals[ind] = res[ind];
			else
				vals[ind] = "";
		}
		
		sbscrptn.SetSubscriptionID(Integer.parseInt(vals[0]));
		sbscrptn.SetSubscriptionName(vals[1]);
		sbscrptn.SetSubscriptionPrice(Integer.parseInt(vals[2]));
		
		// DEL
				System.out.println("SubscriptionController-InsertValsToSubscription::\n"+
				"subscriptionID " + sbscrptn.GetSubscriptionID() + 
				"subscriptionName " + sbscrptn.GetSubscriptionName() + 
				"subscriptionPrice " + sbscrptn.GetSubscriptionPrice());
				
				return true;
	}
	
	public void UpdateUserSubscription(String userName,int subscriptionID,String date)
	{
		String queryReq = "UPDATE:UPDATE user SET subscriptionID="+subscriptionID+",subscriptionDueDate='"+date+"' WHERE userName='"+userName+"';";
		controller.ClientController.SendQuery(queryReq);
	}
	
	public Subscription[] GetSubArr()
	{
		if(getSubscriptionDetails(1)) subArr[0]=sbscrptn;
		if(getSubscriptionDetails(2)) subArr[1]=sbscrptn;
		return subArr;
	}

}
