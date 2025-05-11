package lec08HW;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int max = -1;
		while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			max = Math.max(max, area);
			if (height[i] > height[j])
				j--;
			else
				i++;
		}
		return max;
	}
}