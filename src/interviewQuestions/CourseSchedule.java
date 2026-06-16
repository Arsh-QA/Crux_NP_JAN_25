package interviewQuestions;

import java.util.*;

public class CourseSchedule {

	class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			List<List<Integer>> graph = new ArrayList<>();
			int[] indegree = new int[numCourses];

			for (int i = 0; i < numCourses; i++) {
				graph.add(new ArrayList<>());
			}

			// prerequisite : [course, prereq]
			// edge : prereq -> course

			for (int[] pre : prerequisites) {
				int course = pre[0];
				int prereq = pre[1];

				graph.get(prereq).add(course);

				indegree[course]++;
			}

			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[numCourses];

			// add all courses with no pre-requisites
			for (int i = 0; i < numCourses; i++) {
				if (indegree[i] == 0) {
					queue.add(i);
				}
			}

			int completedCourses = 0;

			while (!queue.isEmpty()) {
				// remove
				int current = queue.remove();

				// ignore
				if (visited[current]) {
					continue;
				}

				// mark visited
				visited[current] = true;

				// self work
				completedCourses++;

				// add unvisited neighbours
				for (int neighbour : graph.get(current)) {
					indegree[neighbour]--;

					if (!visited[neighbour] && indegree[neighbour] == 0) {
						queue.add(neighbour);
					}
				}
			}

			return completedCourses == numCourses;
		}
	}
}