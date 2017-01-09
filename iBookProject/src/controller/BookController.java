package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class BookController {

	// key=ID, value=Name
	private HashMap<Integer, String> hm_ctrByKey = new HashMap<Integer, String>();
	private HashMap<String, String> hm_atrByName = new HashMap<String, String>();
	private HashMap<Integer, String> hm_langByName = new HashMap<Integer, String>();
	private String[] categoriesName;
	private String[] authorsName;
	private String[] langsName;
	
	private HashMap<Integer, ArrayList<String>> hm_subByCat = new HashMap<Integer, ArrayList<String>>();
	
	
	public boolean GetAllLanguages()
	{
		int size;
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT * FROM ibook.language;";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		if(arr_results.isEmpty())
			return false;
		
		String[] res;
		size = arr_results.size();
		langsName = new String[size+1];
		langsName[0] = "";
		for(int i=0; i<size; i++)
		{
			res = arr_results.get(i).split(",");
			hm_langByName.put(Integer.parseInt(res[0]), res[1]); // langeID, langeName
			langsName[i+1] = res[1];
		}
		
		return true;
	}
	
	
	public String[] GetLanguagesName()
	{
		return langsName;
	}
	
	
	
	
	
	
	
	public boolean GetAllAuthors()
	{
		int size;
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT * FROM ibook.author;";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		if(arr_results.isEmpty())
			return false;
		
		String[] res;
		size = arr_results.size();
		authorsName = new String[size+1];
		authorsName[0] = "";
		for(int i=0; i<size; i++)
		{
			res = arr_results.get(i).split(",");
			hm_atrByName.put(res[0], res[1]); // authorID, authorName
			authorsName[i+1] = res[1];
		}
		
		return true;
	}
	
	
	public String[] GetAuthorsName()
	{
		return authorsName;
	}
	
	
	
	
	
	
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
		System.out.println("categs.size()= "+categoriesAmount);
		System.out.println("hm_ctrByKey.size= "+hm_ctrByKey.size());
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
        for (Entry<Integer, String> entry : hm_ctrByKey.entrySet()) {
            if (entry.getValue().equals(catName)) {
                return entry.getKey();
            }
        }
        
        return -1;
	}
	
}
