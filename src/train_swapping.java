import java.util.Arrays;


public class train_swapping {

	public static int swapcount = 0;
	
	public static void main(String[] args) {
		int[] carts = new int[args.length];
		int c =0;
		for (String s: args){
			carts[c] = Integer.parseInt(s);
			c++;
		}
		//System.out.println("Carts length: " + Integer.toString(carts.length));
		int[] sortedcarts = mergeSort(carts,0,carts.length);
		/*for (int i: sortedcarts){
			System.out.print(Integer.toString(i) + " ");
		}*/
		System.out.println("Minimum number of swaps: " + Integer.toString(swapcount) );
		//System.out.println(Arrays.toString(merge(new int[]{6,4,3,5,6,2}, new int[]{7,3,4,6,})));
	}
		
	public static int[] mergeSort(int[] vals,int start,int end){
		//System.out.println("Recursing!");
		if (end - start == 0){ return new int[0];}
		
		else if (end - start > 1){
			return merge(mergeSort(vals, start, (start+end+1)/2), 
						 mergeSort(vals, (start+end+1)/2, end));
			}
		else{
			return new int[]{vals[start]};
		}
		
	}
	public static int[] merge(int[] a1, int[] a2){
		int totlen = a1.length + a2.length;
		int[] res = new int[totlen];
		int indc = 0;
		int i = 0;
		int j = 0;
		//System.out.println(Arrays.toString(a1) + " " + Arrays.toString(a2));
		while (i != a1.length && j != a2.length){
			//System.out.println(Integer.toString(a1[i]) + Integer.toString(a2[j]));
			if (a1[i] <= a2[j]){
				res[indc] = a1[i];
				indc++;
				i++;
			}
			else{
				res[indc] = a2[j];
				swapcount += a1.length - i;
				indc++;
				j++;
			}
		}
		if (i!= a1.length){
			while (i!=a1.length){
				res[indc] = a1[i];
				indc++;
				i++;
			}
		}
		else{
			while (j!= a2.length){
				res[indc] = a2[j];
				//swapcount += i;
				indc++;
				j++;
			}
		}
		return res;
	}
}


