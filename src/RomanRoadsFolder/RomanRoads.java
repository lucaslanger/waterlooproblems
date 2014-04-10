package RomanRoadsFolder;

import java.util.ArrayList;
import java.util.Hashtable;


public class RomanRoads {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		String[] myargs = {
				"Rome Turin",
				"Turin Venice",
				"Turin Genoa",
				"Rome Pisa",
				"Pisa Florence",
				"Venice Athens",
				"Turin Milan"}; 
		
		ArrayList<String> cities = new ArrayList<String>();
		Graph mytree = new Graph();
		
		Hashtable<String, Hashtable<String,Integer>> pathLengths = 
				new Hashtable<String, Hashtable<String,Integer>>();
		
		for (String s: myargs){
			String[] vals = s.split(" ");
			
			if (!(cities.contains(vals[0]))) {cities.add(vals[0]);}
			if (!(cities.contains(vals[1]))) {cities.add(vals[1]);}
			
			mytree.addEdge(vals[0], vals[1]);
			mytree.addEdge(vals[1], vals[0]);
		}
		//System.out.println(mytree.toString());
		mytree.buildTree(mytree.strToLoc.get("Rome"));
		
		pathLengths = mytree.findAllPaths();
		//System.out.println(pathLengths.get("Rome").get("Rome"));
		//System.out.println(queryLength("Rome", "Rome", pathLengths));
		
		for (String s1: cities){
			for (String s2 : cities){
				System.out.println("The Length between " + s1 + " and " + s2 + " is " + queryLength(s1,s2, pathLengths));
			}
		}
		
	}
	
	public static int queryLength(String s1, String s2, Hashtable<String, Hashtable<String,Integer>> pls){
		try{
			return pls.get(s1).get(s2);
		}
		catch(Exception e){
			System.out.println("Invalid City in query");
			return -1;
		}
	}
	


}


	

