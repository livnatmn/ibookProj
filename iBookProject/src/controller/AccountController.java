package controller;

import java.util.ArrayList;

import entity.*;

public class AccountController {
	public User usr = new User();
	public Person prsn = new Person();
	
	public boolean Login(String userName, String password){
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT * FROM user WHERE userName=\""+userName+"\";";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		System.out.println("AccountController-Login-arrRes::");
		for(int i=0; i<arr_results.size(); i++)
			System.out.println(arr_results.get(i));
		
		return InsertValsToUser(arr_results);
	}
	
	
	
	public void UpdateConnected(String userName, boolean isConnect){
		int connected = (isConnect)? 1 : 0 ;
		String queryReq = "UPDATE:UPDATE user SET isConnect="+connected +
				" WHERE userName='"+userName+"';";
		controller.ClientController.SendQuery(queryReq);
		
	}
	
//	public boolean Regist(String personID){
	
	
	public boolean IsPersonIDExist(String personID){
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT personID FROM person WHERE personID=\""+personID+"\";";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		System.out.println("AccountController-IsPersonIDExist-arrRes::");
		for(int i=0; i<arr_results.size(); i++)
			System.out.println(arr_results.get(i));
		
		if(arr_results.isEmpty())
			return false;
		return true;
	//	return InsertValsToPerson(arr_results);
	}
//	public boolean name(){return true;}
	
	
/*
	private boolean InsertValsToPerson(ArrayList<String> arr_results)
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
		
		for(int ind=0; ind<vals.length; ind++)
			if(vals[ind].equals("null"))
				vals[ind] = "";
		
		prsn.SetPersonID ( vals[0] );
		prsn.SetFirstName( vals[1] );
		prsn.SetLastName ( vals[2] );
		prsn.SetEmail    ( vals[3] );
		
		
		// DEL
		System.out.println("AccountController-InsertValsToUser::\n"+
		" PersonID: " + prsn.GetPersonID() +
		" FirstName: " + prsn.GetFirstName() +
		" LastName: " + prsn.GetLastName() +
		" Email: " + prsn.GetEmail());
		
		return true;
	}// end InsertValsToPerson function.

*/	

	private boolean InsertValsToUser(ArrayList<String> arr_results)
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
		
		usr.SetUserName( vals[0] );
		usr.SetPassword( vals[1] );
		usr.SetPersonID( vals[2] );
		usr.SetConnect(!(Integer.parseInt(vals[3])==0)); // 0 disconnected
		usr.SetPaying(!(Integer.parseInt(vals[4])==0)); // 0 not paying
		usr.SetPrivilege(Integer.parseInt(vals[5])); // 0 =user
		usr.SetApproved(!(Integer.parseInt(vals[6])==0)); // 0 not approved
		
		int sbID = 0;
		if(!(vals[7].equals("null")) && !(vals[7].equals("")))
			sbID = Integer.parseInt(vals[7]);
		usr.SetSubscriptionID(sbID);
		
		String date="";
		if(!(vals[8].equals("null")) && !(vals[8].equals("")))
			date = vals[8];
		usr.SetSubscriptionDueDate( date );
		
		// DEL
		System.out.println("AccountController-InsertValsToUser::\n"+
		" UserName: " + usr.GetUserName() +
		" Password: " + usr.GetPassword() +
		" PersonID: " + usr.GetPersonID() +
		" Connect: " + usr.GetConnect() +
		" Paying: " + usr.GetPaying() +
		" Privilege: " + usr.GetPrivilege() +
		" Approved: " + usr.GetApproved() +
		" SubscriptionID: " + usr.GetSubscriptionID() +
		" SubscriptionDueDate: " + usr.GetSubscriptionDueDate());
		
		return true;
	}// end InsertValsToUser function.
	
	
	public int CountPersonAccounts(String personID)
	{
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT COUNT(userName) as amount FROM user WHERE (privilege=0 OR privilege=1) AND personID=\""+personID+"\";";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		System.out.println("AccountController-UsersAmount-arrRes::");
		for(int i=0; i<arr_results.size(); i++)
			System.out.println(arr_results.get(i));
		
		if(arr_results.isEmpty())
			return 0;
		

		String[] res = arr_results.get(0).split(",");
		System.out.println("res[0]= "+res[0]);
		
		return Integer.parseInt(res[0]);
		
	}
	
	public void InsertPeraonDetails(String personID, String firstName, String lastName, String email){
		String queryReq = "INSERT:INSERT INTO person VALUES ('"+personID+"', '"+firstName+"', '"+lastName+"', '"+email+"');";
		controller.ClientController.SendQuery(queryReq);
		
	}
}
