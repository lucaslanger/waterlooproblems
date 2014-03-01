import java.util.ArrayList;


public class s3 {

	public static void main(String[] args){
		ArrayList<String> myArraylist = findBitPatterns(4,2,"");
		for (int i=0;i<myArraylist.size();i++){
			System.out.println(myArraylist.get(i));
		}
		
	}
	
	public static ArrayList<String> findBitPatterns(int n, int k, String prev){
		ArrayList<String> listofnums = new ArrayList<String>(10);
		String s1 = prev + "0";
		String s2 =  prev + "1" ;
		if(n == k){
			//System.out.println("added a bunch of 1's at end");
			listofnums.add(prev + repeatString("1",n));
		}
		
		else if (n > 1 && k > 0){
			//System.out.println("recursing");
			listofnums.addAll(findBitPatterns(n-1,k, s1));
			listofnums.addAll(findBitPatterns(n-1, k-1, s2));
		}
		else{
			//System.out.println("added 0 at end " + n + " " + k );
			listofnums.add(prev + repeatString("0",n));
		}
		return listofnums;
		
	}
	
	public static String repeatString(String s, int r){
		String rString = "";
		for (int c=0;c<r;c++){
			rString += s;
		}
		return rString;
	}
	
}


