package lec17;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		int n = 100;
		List<Integer> al = new ArrayList<Integer>();
		lexicographical(0, n, al);
		System.out.println(al);
	}

	public static void lexicographical(int curr, int n, List<Integer> al) {
		if (curr > n)
			return;
//		System.out.println(curr);
		// leetcode solution : 
		 // if(curr != 0)
		  //  al.add(curr);
		al.add(curr);
		int i = 0;
		if (curr == 0)
			i = 1;
		for (; i <= 9; i++) {
			lexicographical(curr * 10 + i, n, al);
		}
	}
}