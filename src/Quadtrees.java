import java.util.Arrays;
import java.util.Stack;


public class Quadtrees {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static int bcount = 0;
	
	public static void main(String[] args) {
		//String[] myargs = new String[]{"ppeeefpffeefe","pefepeefe"}; //TEST1
		String[] myargs = new String[]{"peeef","peefe"}; //TEST2
		//String[] myargs = new String[]{"peeef","peepefefe"}; //TEST3
		
		String[] inp1 = convertFormat(toChars(myargs[0]));
		String[] inp2 = convertFormat(toChars(myargs[1]));
		System.out.println(Arrays.toString(inp2));
		System.out.println(Arrays.toString(inp2));
		String[] res = addIMGs(inp1, inp2);
		System.out.println(Arrays.toString(res));
		System.out.println(bcount);

	}
	
	private static String[] addIMGs(String[] inp1, String[] inp2) {
		String[] r = new String[inp1.length];
		System.out.println("Both pixel representations have the same length: " + Boolean.toString(inp1.length == inp2.length));
		for (int i =0;i<inp1.length;i++){
			if (inp1[i].equals("f") || inp2[i].equals("f")){
				r[i] = "f";
				bcount++;
			}
			else{
				r[i] = "e";
			}
		}
		return r;
	}

	private static String[] toChars(String string) {
		String[] result = new String[string.length()];
		for (int i = 0; i < string.length(); i++){
		    String c = Character.toString(string.charAt(i));        
		    result[i] = c;
		}
		return result;
	}

	public static String[] convertFormat(String[] s){

		//System.out.println(Arrays.toString(s));
		String[] rval = new String[1024];
		int lastfilled=0;
		
		int topcount=0;
		Stack<Integer> fillcounters = new Stack<Integer>();
		
		int depth = 1;
		for (int y=0;y<s.length;y++){
			if (!(s[y]).equals("p")){
				
				lastfilled = fillArray(rval,s[y],1024/depth,lastfilled);
	
				topcount++;
				while (topcount == 4){
					depth = depth/4;
					//topcount = 0;
					topcount = fillcounters.pop() + 1;
					//System.out.println(topcount);
				}
			}

			else{
				fillcounters.push(topcount);
				topcount = 0;
				depth = depth * 4;
			}
		}
		
		return rval;
		
	}

	private static int fillArray(String[] rval, String string, int i, int lf) {
		int ind = lf;
		for (int j=0;j<i;j++){
			rval[ind] = string;
			ind++;
		}
		return ind;
		
	}
	

}
