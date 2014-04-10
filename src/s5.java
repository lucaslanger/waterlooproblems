import java.util.ArrayList;
import java.util.HashMap;


public class s5 {

// this algorithm would be effective for inputs way bigger than 1000, for inputs around 1000 the more obvious algorithm of doing an 
	// n^2 type operation would probably have a similar runtime.

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] l1 = new int[]{8, 8, 4, 4, 4, 3, 3, 3, 1};
		//int[] l2 = new int[]{9, 9, 8, 8, 6, 5, 5, 4, 3};
		int[] l1 = new int[]{6, 5, 4, 4, 4, 4, 4};
		int[] l2 = new int[]{3, 3, 3, 3, 3, 3, 3};
		System.out.println(getMaxDistance(l1, l2));
		//System.out.println(getCVI(1,4,6, new int[]{9,8,4,2,1}));
	}
	
	public static int getMaxDistance(int[] l1 , int[] l2){
		int maxdistance = 0;

		HashMap<Integer, Integer> valToMin = setupMinMap(l1);
		HashMap<Integer, Integer> valToMax = setupMaxMap(l2);
		int[] uniqueA = makeArrayUnique(l2); //O(n) amount of work required
		
		for (int c =0;c< l1.length;c++){ //O(n) amount of work required
			
			int closestValidIndex = getCVI(c,uniqueA.length -1 ,l1[c], uniqueA );
			if (closestValidIndex != -1){
				int tmp = valToMax.get( closestValidIndex );
				if (tmp > c && tmp - c > maxdistance ){
					maxdistance = tmp - c;
				}
			}
		}
		return maxdistance;
	}
	
	public static int getCVI(int start, int end,int inp, int[] l2){ // O(logn) work required
		int guess = start + (end - start)/2;
		//System.out.println("Guess " + guess + " Start " + start + " End " + end);
		if (inp == l2[guess]){
			return inp;
		}
		else if(end-start < 2){
			if (l2[end] >= inp){
				return l2[end];
			}
			else if(l2[start] >= inp){
				return l2[start];
			}
			else{
				return -1;
			}
		
		}
		else{
			if (l2[guess] > inp){
				//System.out.println("Recursing Here");
				return getCVI(guess, end, inp, l2);
			}
			else{
				//System.out.println("Recursing Here #2");
				return getCVI(start, guess, inp, l2);
			}
		}
	}
	
	public static int[] makeArrayUnique(int[] l2){
		int[] rval = new int[l2.length];
		int ci = 0;
		for (int j=0;j<l2.length-1;j++){
			if (j == 0 || l2[j] != l2[j-1]){
				rval[ci] = l2[j];
				ci++;
			}	
				
		}
		return rval;
	}
	
	public static HashMap<Integer, Integer> setupMaxMap(int[] l){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int j=0;j<l.length-1;j++){
			if (j == l.length -1 || l[j] != l[j+1]){
				hm.put(l[j], j);
			}	
				
		}
		return hm;
		
	}
	
	public static HashMap<Integer, Integer> setupMinMap(int[] l){ // NOT USED
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int j=0;j<l.length-1;j++){
			if (j == 0 || l[j] != l[j-1]){
				hm.put(l[j], j);
			}	
				
		}
		return hm;
		
	}
	

}
