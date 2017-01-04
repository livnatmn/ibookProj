package controller;

import java.util.HashMap;
import java.util.ArrayList;


public class SearchBookController {
	
	// key=categoryID, value=categoryName
	private HashMap<Integer, String> hm_ctrByKey = new HashMap<Integer, String>();
	private HashMap<String, Integer> hm_ctrByName = new HashMap<String, Integer>();
	private String[] categoriesName;
	
	private HashMap<Integer, ArrayList<String>> hm_subByCat = new HashMap<Integer, ArrayList<String>>();
	
	public boolean GetAllCatsAndSubs()
	{
		int categoryID;
		int categoriesAmount;
		ArrayList<String> arr_results;
		ArrayList<String> tmpVal;
		ArrayList<String> categs;
		
		String queryReq = "GET:SELECT category.categoryID, category.categoryName, subject.subjectID, subject.subjectName FROM ibook.category,ibook.subject WHERE subject.categoryID=category.categoryID;";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		if(arr_results.isEmpty())
			return false;
		

		categoriesAmount = arr_results.size();
		categs = new ArrayList<String>();
		categs.add(0,"");
		
		String[] res;
		for(int i=0; i<categoriesAmount; i++)
		{
			res = arr_results.get(i).split(",");
			categoryID = Integer.parseInt(res[0]);
			if(!hm_ctrByKey.containsKey(categoryID))
			{
				hm_ctrByKey.put(categoryID, res[1]);
				hm_ctrByName.put(res[1], categoryID);
				categs.add(i+1,res[1]);
			}
			
			if(hm_subByCat.get(categoryID) == null)
			{
				System.out.println("key: "+categoryID+" is empty.");
				hm_subByCat.put(categoryID, new ArrayList<String>());
				
			}

			tmpVal = hm_subByCat.get(categoryID);
			tmpVal.add(0,res[3]);
			hm_subByCat.remove(categoryID);
			hm_subByCat.put(categoryID, tmpVal);
			
			System.out.println("hm_subByCat.size= "+hm_subByCat.size());
			System.out.println("array.size= "+hm_subByCat.get(categoryID).size());

		}
		categoriesAmount = categs.size();
		categoriesName = new String[categoriesAmount];
		for(int i=0; i<categoriesAmount; i++)
			categoriesName[i] = categs.get(i);

		return true;
	}
	
	
	
	public String[] GetCategoriesName()
	{
		return categoriesName;
	}
	
	
	
	public ArrayList<String> GetSubjectsByCategory(int categoryID)
	{
		return hm_subByCat.get(categoryID);
	}
	
	
	public String GetCategoryNameByID(int catID)
	{
		return hm_ctrByKey.get(catID);
	}
	
	
	public int GetCategoryIDByName(String catName)
	{
		return hm_ctrByName.get(catName);
	}
	
}
