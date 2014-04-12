<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;


public class Safebreaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Safebreaker sb = new Safebreaker(new String[]{"1234", "2/2"});//{"6428" ,"3/0","1357","3/0"});
		/*"9793", "0/1", "2384", "0/2", "6264", "0/1",
				"3383", "1/0",
				"2795", "0/0",
				"0218", "1/0"});*/
		
		//System.out.println(args.toString());
				

	}
	
	public Safebreaker(String[] args){
		int[][] data = new int[args.length/2][3];
		int c=0;
		while (c<args.length/2){
			data[c][0] = Integer.parseInt(args[2*c]);
			String[] parts = args[2*c+1].split("/");
			data[c][1] = Integer.parseInt(parts[0]);
			data[c][2] = Integer.parseInt(parts[1]);
			c++;
		}
		ArrayList<Integer> solns = new ArrayList<Integer>(); 
		
		boolean possible = true;
		for (int j=0;j<10000;j++){
			possible = true;
			for (int[] d: data){
				int em = getExactMatches(d[0],j);
				int vm = getValMatches(d[0],j);
				//System.out.println(Integer.toString(em) + " " + Integer.toString(vm));
				//System.out.println(Integer.toString(d[0]) +" " + Integer.toString(j));
				if (!(d[1] == em && vm-em == d[2]) ){
					possible = false;
					break;
				}
				
			}
			if (possible){
				solns.add(j);
			}
		}
		if (solns.size()==1){
			System.out.println(solns.get(0));
		}
		else if (solns.size() == 0){
			System.out.println("impossible");
		}
		else{
			System.out.println("indeterminant");
		}
		//System.out.println(solns.toString());
		
		
		//System.out.println(Integer.toString(getValMatches(4312,9218)));
	}

	private int getValMatches(int i, int j) {
		int[] di = toDigits(i);
		int[] dj = toDigits(j);
		int[] used = new int[]{-1,-1,-1,-1};
		int ul=0;
		
		int valmatches=0;
		for (int g:di){
			if(LicontainsI(dj,g) && !(LicontainsI(used,g) ) ){
				valmatches++;
				used[ul] = g;
				ul++;
			}
		}
		return valmatches;
	}

	private boolean LicontainsI(int[] dj, int g) {
		for (int y: dj){
			if (y==g){
				return true;
			}
		}
		return false;
	}

	private int getExactMatches(int i, int j) {
		int exactMatches = 0;
		int[] di = toDigits(i);
		int[] dj = toDigits(j);
		for (int g=0;g<di.length;g++){
			if (di[g] == dj[g]){
				exactMatches++;
			}
		}
		return exactMatches;
		//System.out.println(Arrays.toString(di));
		
		
	}

	private int[] toDigits(int j) {
		int[] rval = new int[4];
		int c = 0;
		int mod10;
		while(c<rval.length){
			mod10 = j%10;
			j = j/10;
			rval[rval.length-1-c] = mod10;
			c++;
		}
		return rval;
	}
	

		// TODO Auto-generated method stub

	}

}
