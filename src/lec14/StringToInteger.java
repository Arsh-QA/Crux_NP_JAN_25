package lec14;

public class StringToInteger {

	public static void main(String[] args) {
		String str = "5647890";
		// int x = (int) str;//Not possible because String can contain characters and
		// alphabets as well
		int x = Integer.parseInt(str);
		long x1 = Long.parseLong(str);
		/*
		1st way : 
			take each character and then convert to int 
			and then multiple by 10.pow(n) where n -> 0 to n-1
			then add in to convert to integer
			*/
		
		

	}
}