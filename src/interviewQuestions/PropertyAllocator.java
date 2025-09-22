package interviewQuestions;

import java.util.*;

public class PropertyAllocator {

	public static void main(String[] args) {
		List<Property> properties = new ArrayList<>();
		properties.add(new Property(1, "downtown", 5));
		properties.add(new Property(2, "downtown", 3));
		properties.add(new Property(3, "downtown", 1));
		properties.add(new Property(4, "uptown", 2));
		properties.add(new Property(5, "uptown", 4));
		System.out.println(findMinimumProperties(properties, 6, "downtown"));
		System.out.println(findMinimumProperties(properties, 4, "downtown"));
		System.out.println(findMinimumProperties(properties, 3, "uptown"));
	}

	static class Property {
		int propertyId;
		String neighbourhood;
		int capacity;

		public Property(int propertyId, String neighbourhood, int capacity) {
			this.propertyId = propertyId;
			this.neighbourhood = neighbourhood;
			this.capacity = capacity;
		}
	}

	public static List<Integer> findMinimumProperties(List<Property> properties, int groupSize,
			String targetNeighbourhood) {
		// Filter properties by required neighbourhood
		List<Property> filtered = new ArrayList<>();
		for (Property p : properties) {
			if (p.neighbourhood.equalsIgnoreCase(targetNeighbourhood)) {
				filtered.add(p);
			}
		}

		Collections.sort(filtered, Comparator.comparingInt(p -> p.propertyId));

		int n = filtered.size();

		List<Integer> bestCombo = new ArrayList<>();
		int minCount = Integer.MAX_VALUE, minWastage = Integer.MAX_VALUE;

		// For all Possible Subsets
		for (int mask = 1; mask < (1 << n); mask++) {
			int sum = 0;
			List<Integer> combo = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) != 0) {
					sum += filtered.get(i).capacity;
					combo.add(filtered.get(i).propertyId);
				}
			}
			if (sum >= groupSize) {
				int wastage = sum - groupSize;
				// Updage best if :
				// 1. Fewer Propreties or
				// 2. Same count, but less wastage or
				// 3. Same count and wastage, but lexicographically smaller IDs
				if (combo.size() < minCount || (combo.size() == minCount && wastage < minWastage)
						|| (combo.size() == minCount && wastage == minWastage && isLexSmaller(combo, bestCombo))) {
					bestCombo = combo;
					minCount = combo.size();
					minWastage = wastage;
				}
			}
		}
		return bestCombo;
	}

	private static boolean isLexSmaller(List<Integer> a, List<Integer> b) {
		for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
			if (!a.get(i).equals(b.get(i)))
				return a.get(i) < b.get(i);
		}
		return a.size() < b.size();
	}
}