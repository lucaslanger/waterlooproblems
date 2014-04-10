package RomanRoadsFolder;

import java.util.LinkedList;


public class Location{
	LinkedList<Location> children;
	Location parent;
	int depth;
	boolean visited;
	String cityname;
	
	public Location(String s){
		this.depth = 0;
		this.visited = false;
		this.cityname = s;
		this.parent = null;
	}
	
	public String getCityName(){
		return cityname;
	}
	
	public void addChild(Location l){
		this.children.add(l);
	}
	
	public void setParent(Location l){
		this.parent = l;
	}
	
	public Location getParent(){
		return this.parent;
	}

	public void setDepth(int i) {
		// TODO Auto-generated method stub
		this.depth = i;
		
	}
	
	public int getDepth(){
		return this.depth;
	}
	
	public void setVisited(boolean b){
		this.visited = b;
	}
	
	public boolean isVisited(){
		return this.visited;
	}
}
