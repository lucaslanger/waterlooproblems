
public class WheresWaldorf {

	/**
	 * @param args
	 */
	//Since the problem states that the words must be contained inside the grid, you only have to look for the first letter... 
	//This code does so for the example of the first word "rb"
	public static void main(String[] args) {
		String[] grid = new String[]{"by","re"};
		String[] words = new String[]{"rb","rb"};
		int linenumber = -1;
		int colnumber = -1;
		
		search: for (int c=0;c<grid.length;c++){
			for (int p=0;p<grid[c].length();p++){
				if (words[0].charAt(0) == grid[c].charAt(p)){
					linenumber = c;
					colnumber = p;
					break search;
				}
					
			}
		}
		System.out.println(Integer.toString(linenumber) + " " + Integer.toString(colnumber));

	}

}
