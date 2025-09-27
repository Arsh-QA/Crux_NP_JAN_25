package heapHashMapAssignment;

import java.util.*;

class Employee {
	String name;
	int salary;

	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
}

public class SortGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int n = sc.nextInt();

		PriorityQueue<Employee> pq = new PriorityQueue<>((a, b) -> {
			if (b.salary != a.salary)
				return b.salary - a.salary;// higher salary first
			return a.name.compareTo(b.name);// lexicographical order
		});

		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int salary = sc.nextInt();
			if (salary >= x) {
				pq.add(new Employee(name, salary));
			}
		}

		while (!pq.isEmpty()) {
			Employee e = pq.poll();
			System.out.println(e.name + " " + e.salary);
		}
		sc.close();
	}
}