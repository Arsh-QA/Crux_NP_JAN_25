package interviewQuestions;

import java.util.*;

public class KeysAndRooms {

	class Solution {
		public boolean canVisitAllRooms(List<List<Integer>> rooms) {
			HashSet<Integer> visited = new HashSet<>();
			Queue<Integer> q = new LinkedList<>();
			int count = 0;
			q.add(0);
			while (!q.isEmpty()) {
				int rv = q.poll();

				if (visited.contains(rv))
					continue;

				visited.add(rv);
				count++;

				if (count == rooms.size()) {
					return true;
				}

				for (int nbrs : rooms.get(rv)) {
					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}
				}
			}
			return false;
		}
	}
}