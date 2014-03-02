
public class s4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s4 test = new s4();
		String s1 = "CXIV";
		String s2 = "DC";
		String result = test.sum(s1,s2);
		System.out.println(Integer.toString(test.RomStringToInt(s1)) + " " + Integer.toString(test.RomStringToInt(s2)));
		System.out.println(result);
		System.out.println(test.RomStringToInt(result));
		
		//System.out.println("test " + test.intToRomString(950));

	}
	public s4(){
		
		
	}
	
	public String sum(String s1, String s2){
		int tmp = RomStringToInt(s1) + RomStringToInt(s2);
		System.out.println(tmp);
		return intToRomString( tmp);
	}
	
	public String intToRomString(int i){
		String rstr = "";
		//System.out.println("Current i " + Integer.toString(i));
		if (i > 1000){
			return "CONCORDIA CUM VERITATE";
		}
		else if (i == 1000){
			return "M";
		}
		else if (i >= 900){
			return "CM" + intToRomString(i-900) ;
		}
		else if (900> i && i >=500){
			return "D" + intToRomString(i-500); 
		}
		else if (400 <= i){
			return "CD" + intToRomString(i-400);
		}
		else if (400> i && i>=100){
			return "C" + intToRomString(i-100);
		}
		else if (i>=90){
			return "XC" + intToRomString(i-90);
		}
		else if (90>i && i >= 50){
			return 'L' + intToRomString(i-50);
		}
		else if (i >= 40){
			return "XL" + intToRomString(i-40);
		}
		else if (50>= i && i>=10){
			return "X" + intToRomString(i-10);
		}
		else if (i>=9){
			return "IX" ;//+ intToRomString(i-5);
		}
		else if (i>=5){
			return "V" + intToRomString(i-5);
		}
		else if (4 <= i){
			return "IV";
		}
		else if (4> i && i>1){
			return "I" + intToRomString(i-1);
		}
		else if (i == 1){
			return rstr + "I";
		}

		return rstr;
	}
	
	public int RomStringToInt(String s){
		char[] c = s.toCharArray();
		int sum = 0;
		for (int i=c.length-1;i>=0;i--){
			if (c[i] == 'I'){
				if (i!=c.length-1 && (c[i+1] == 'V' || c[i+1] == 'X') && (i==0 || c[i-1] != c[i]) ){
					sum -= 1;
				}
				else{
					sum += 1;
				}
				
			}
			else if (c[i] == 'V'){
				sum += 5;
			}
			else if (c[i] == 'X'){
				if (i!=c.length-1 && (c[i+1] == 'L' || c[i+1] == 'C') && (i==0 || c[i-1] != c[i]) ){
					sum -= 10;
				}
				else{
					sum += 10;
				}
			}
			else if (c[i] == 'L'){
				sum += 50;
			}
			else if (c[i] == 'C'){
				if (i!=c.length-1 && (c[i+1] == 'M' || c[i+1] == 'D') && (i==0 || c[i-1] != c[i]) ){
					sum -= 100;
				}
				else{
					sum += 100;
				}
			}
			else if (c[i] == 'D'){
				sum += 500;
			}
			
			else if (c[i] == 'M'){
				sum += 1000;
			}
		}
		return sum;
	}

}
