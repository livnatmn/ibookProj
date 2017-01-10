package controller;

import java.util.ArrayList;
//import javafx.util.Pair;

public class SearchBookController {
/*
	public void SearchBookByOneFeature(ArrayList<Pair<String,String>> arr_srchFlds)
	{
		System.out.println("SearchBookController-SearchBookByOneFeature");
		SearchBookBySomeFeatures(arr_srchFlds, "non"); // del
		
	}
	
	
	public void SearchBookBySomeFeatures(ArrayList<Pair<String,String>> arr_srchFlds, String action)
	{
		ArrayList<String> arr_results;
		
		String query = "GET:SELECT book.* ";
		String from = " FROM ";
		String where = " WHERE ";
		
		 // Using for each loop to iterate array of Pair Objects
        for (Pair <String,String> temp : arr_srchFlds)
        {
          switch(temp.getKey())
          {
          case "title": from+=" book,";
          				where+=" title like \"%"+temp.getValue()+"%\" "+action;
          				//where+=" title like \"%"+temp.getValue()+"%\";";
          				break;
          case "author":from+=" author_of_book,";
						where+=" title like \"%"+temp.getValue()+"%\";";
						break;
          case "language":
        	  break;
          case "subject":
        	  break;
          default:
          }
        }
        
        if(from.charAt((from.length() - 1)) == ',')
        	from = from.substring(0,from.length()-1);

        if(where.charAt((where.length() - 1)) == ',')
        	where = where.substring(0,from.length()-1);
        
        query = query + from + where;
        
        
        System.out.println("SBC-query= "+query);
        controller.ClientController.SendQuery(query);
		controller.ClientController.SetResults(query);
		arr_results = ClientController.RecieveQueryResults();
		
		System.out.println("SearchBookController-SearchBookBySomeFeatures-arrRes::");
		for(int i=0; i<arr_results.size(); i++)
			System.out.println(arr_results.get(i));
	}
	*/
}
