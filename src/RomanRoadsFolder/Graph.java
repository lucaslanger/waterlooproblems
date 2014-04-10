package RomanRoadsFolder;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class Graph {
	Hashtable<Location, LinkedList<Location>> adjList;
	Hashtable<String, Location> strToLoc;
	
	public Graph(){
		adjList = new Hashtable<Location,LinkedList<Location>>();
		strToLoc = new Hashtable<String, Location>();
	}
	
	public void addEdge(String l1, String l2){
		LinkedList<Location> curr1;
		boolean l1exists = false;;
		

		Location start = acquireLoc(l1);
		if (adjList.containsKey(start)){
			l1exists = true;
		}
		Location end = acquireLoc(l2);
		
		if (l1exists){
			//System.out.println(adjList.get(start));
			curr1 = adjList.get(start);
		}
		else{
			curr1 = new LinkedList<Location>();
		}

		curr1.add(end);
		adjList.put(start, curr1);

	}
	
	public Location acquireLoc(String l1){
		//System.out.println("Here");
		Location start;
		if (!(strToLoc.containsKey(l1))){
			//System.out.println("Doesn't Contain " + l1);
			start = new Location(l1);
			strToLoc.put(l1, start);
		}
		else{
			//System.out.println("Already Contains " + l1);
			start = strToLoc.get(l1);
		}
		return start;
	}
	
	public void buildTree(Location root){
		
		LinkedList<Location> children = adjList.get(root);
		//System.out.println("size: " + children.size());
		//System.out.println("Visiting: " + root.getCityName() + ", Depth: " +  Integer.toString(root.getDepth()));
		root.setVisited(true);
		if (!children.isEmpty()){
			for (Location l: children){
				//System.out.println(l.getCityName());
				if (l.isVisited() == false){
					
					l.setParent(root);
					l.setDepth(root.depth + 1);
					buildTree(l);
				}
			}	
		}
	}

	//public Location getLocation(String string) {
		// TODO Auto-generated method stub
		//return null;
	//}
	
	public String toString(){
		Enumeration<Location> e = adjList.keys();
		String s = "";
		while(e.hasMoreElements()){
			Location ne = e.nextElement();
			s+= ne.getCityName() + " ["  ;
			for (Location l: adjList.get(ne)){
				s+= l.getCityName() + " ";
				}

			s+= "] \n";
		}
		return s;
	}

	public Hashtable<String, Hashtable<String, Integer>> findAllPaths() {
		Hashtable<String, Hashtable<String, Integer>> paths = new Hashtable<String, Hashtable<String, Integer>>();

		for (String city1: strToLoc.keySet()){
			for (String city2: strToLoc.keySet()){
				if (paths.containsKey(city1) && paths.get(city1).containsKey(city2)){
					int doNothing = -1;
				}
				//else{
					int pl = findPathLength(city1,city2,paths);

				//}
				
			}
		}
		return paths;
	}

	private int findPathLength(String city1, String city2, Hashtable<String, Hashtable<String, Integer>> paths) {
		Location p1 = strToLoc.get(city1).getParent();
		Location p2 = strToLoc.get(city2).getParent();
		Hashtable<String, Integer> tmp1;
		Hashtable<String, Integer> tmp2;
		
		if (paths.containsKey(city1) && paths.get(city1).containsKey(city2)){
			return paths.get(city1).get(city2);
		}
		else{
			
			if (paths.containsKey(city1)){
				tmp1 = paths.get(city1);
			}
			else{
				//System.out.println("Exception Caught");
				tmp1 = new Hashtable<String, Integer>();
			}
			
			if (paths.containsKey(city2)){
				tmp2 = paths.get(city2);
			}
			else{
				tmp2 = new Hashtable<String, Integer>();
			}
			//System.out.println("tmp1 " + tmp1.toString() + " pl " + Integer.toString(pl) );
		
			if (city1.equals(city2)){
				upDateTable(city1, city2, tmp1, tmp2, paths, 0);
				return 0;
			}
			else if (p1 == null){
				int val = strToLoc.get(city2).getDepth();
				upDateTable(city1, city2, tmp1, tmp2, paths, val);
				return val;
			}
			else if (p2 == null){
				int val = strToLoc.get(city1).getDepth();
				upDateTable(city1, city2, tmp1, tmp2, paths, val);
				return val;
			}
			else if (p1.getCityName().equals(p2.getCityName())){
				//System.out.println(city1  + " to " + city2);
				int val = 2;
				upDateTable(city1, city2, tmp1, tmp2, paths, val);
				return val;
			}
			else if (p1.getDepth() > p2.getDepth()){
				int val = 1 + findPathLength(p1.getCityName(), city2, paths);;
				upDateTable(city1, city2, tmp1, tmp2, paths, val);
				return val;
			}
			else if (p1.getDepth() < p2.getDepth()){
				int val = 1 + findPathLength(city1, p2.getCityName(), paths);
				upDateTable(city1, city2, tmp1, tmp2, paths, val);
				return val;
			}
			else{// occurs if the depths are equal
				int val = 2 + findPathLength(strToLoc.get(city1).parent.getCityName(), 
						strToLoc.get(city2).parent.getCityName(), paths);
				upDateTable(city1, city2, tmp1, tmp2, paths, val);
				return val;
			}
		}	
	}
	public void upDateTable(String city1, String city2, Hashtable<String, Integer> tmp1, Hashtable<String, Integer> tmp2,
			Hashtable<String, Hashtable<String, Integer>> paths, int val){
		tmp1.put(city2, val);
		tmp2.put(city1, val);
		paths.put(city1, tmp1);
		paths.put(city2, tmp2);
	}
}
