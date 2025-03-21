package com.app.raghu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class C {

	public static void main(String[] args) {

//		List<Integer> ll = List.of(12, 21, 3, 14, 5, 27, 18);
//
//		ll.stream().filter(x -> x % 2 == 0).sorted().forEach(val -> System.out.println(val));
//
//		System.out.println("------------------------------");
//
//		List<String> a = List.of("HOW", "ARE", "PEOPLE", "LEAVING", "HAPPEN");
//
//		a.stream().map(name -> name.toLowerCase()).filter(v -> v.length() > 3).forEach(val -> System.out.println(val));
//
//		System.out.println("----------------------------------");
//
//		List<List<String>> l1 = Arrays.asList(Arrays.asList("Shivba", "Ramesg"), Arrays.asList("Abikest", "Khatkale"),
//				Arrays.asList("Pandurang", "Chanavan"));
//
//		l1.stream()
//		.flatMap((List<String> sentence) -> sentence.stream()
//		.map(val -> val.toUpperCase()))		
//		.forEach(x -> System.out.println(x));
//		
//		System.out.println("----------------------------------");

		// Chatgpt
		
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		// Use streams to filter even numbers and print them.
//
//		numbers.stream()
//		.filter(v -> v % 2 == 0)
//		.forEach(System.out::println);
//		
//		List<String> names = Arrays.asList("shivam", "ramesh", "khatkale");
//		// Use streams to convert each name to uppercase.
//			
//		names.stream()
//		.map(x -> x.toUpperCase())
//		.forEach(System.out::println);
//		
//		
//		List<Integer> num = Arrays.asList(10, 20, 30, 55, 60, 70);
//		// Use streams to find the first number greater than 50.
//		
//		Optional<Integer> a = num.stream()
//		.filter(x -> x > 50)
//		.findFirst();
//		
//		System.out.println(a);
//		
//		List<Integer> num1 = Arrays.asList(5, 10, 15, 20, 25);
//		// Use streams to find the sum of all elements.
//		
//		System.out.print("Sum of all elements : ");
//		int val = 
//		num1.stream()
//		.mapToInt(Integer::intValue)
//		.sum();
//		
//		System.out.println(val);
//		
//		
//		// INtermediate opertations 
//		List<Integer> num3 = Arrays.asList(12, 45, 78, 34, 89, 21);
//		// Find the maximum and minimum numbers using streams.
//		
//		Optional<Integer> maxi =
//				num3.stream()
//				.max(Integer::compareTo);
//		Optional<Integer> mini =
//				num3.stream()
//				.min(Integer::compareTo);
//		System.out.println(maxi);
//		System.out.println(mini);
//		
//		
//		
//		List<Integer> duplicates = Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6);
//		// Use streams to remove duplicates.
//
//		duplicates.stream()
//		.distinct()
//		.forEach(x -> System.out.print(x +" "));
//		System.out.println();
//		
//		List<String> words = Arrays.asList("Banana", "Apple", "Mango", "Grapes");
//		// Sort the list in reverse alphabetical order using streams.
//		
//		words.stream()
//		.sorted((s1,s2) -> s2.compareTo(s1))
//		.forEach(System.out::println);
//		
//		System.out.println("GRoup lengtj");
//		
//		List<String> word = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
//		Map<Integer, List<String>> groupedByLength = word.stream()
//		                                                  .collect(Collectors.groupingBy(String::length));
//		System.out.println(groupedByLength);
//
//		//  Find the Second Highest Number:
//		List<Integer> n = Arrays.asList(10, 20, 35, 50, 60, 35, 70);
//		int secondHighest = n.stream()
//		                           .distinct()
//		                           .sorted(Comparator.reverseOrder())
//		                           .skip(1)
//		                           .findFirst()
//		                           .orElseThrow();
//		System.out.println(secondHighest);
//		
//		System.out.println("--------------------------");
//				
//		List<List<Integer>> listOfLists = Arrays.asList(
//			    Arrays.asList(1, 2, 3),
//			    Arrays.asList(4, 5, 6),
//			    Arrays.asList(7, 8, 9)
//			);
//			List<Integer> flattenedList = listOfLists.stream()
//			                                         .flatMap(List::stream)
//			                                         .collect(Collectors.toList());
//			System.out.println(flattenedList);

			
			System.out.println("---------------------");
			
			
			List<String> ll = new ArrayList<>();
			
			ll.add("shivam");
			ll.add("rushikesh");
			ll.add("khatkale");
			
			
					ll.stream()
					.filter(s -> s.startsWith("s"))
					.forEach(System.out::println);
					
					  ArrayList<Employee> er = new ArrayList<>();

				        // Adding 10 Employee objects
				        er.add(new Employee(101, "John Doe", "IT", 60000));
				        er.add(new Employee(102, "Jane Smith", "HR", 55000));
				        er.add(new Employee(103, "Michael Brown", "Finance", 65000));
				        er.add(new Employee(104, "Emily Davis", "Marketing", 50000));
				        er.add(new Employee(105, "Daniel Wilson", "IT", 70000));
				        er.add(new Employee(106, "Sophia Martinez", "Finance", 62000));
				        er.add(new Employee(107, "David Clark", "HR", 53000));
				        er.add(new Employee(108, "Emma Johnson", "Operations", 58000));
				        er.add(new Employee(109, "Olivia White", "Sales", 61000));
				        er.add(new Employee(110, "James Anderson", "Marketing", 56000));

					
				    er.stream()
				    .filter(s -> s.getName().startsWith("D"))
				    .forEach(f -> System.out.println(f));
			
				    
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(11);
		numbers.add(22);
		numbers.add(33);
		numbers.add(34);
		
		numbers.stream()
		.filter(s -> (s % 2 == 0))
		.forEach(va ->  System.out.println(va));
		
		System.out.println("---------------------");
		
		Set<Integer> s1 = numbers.stream()
		.filter(p -> (p % 2 == 0))
		.collect(Collectors.toSet());
		
		s1.forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		// weite a program all the empid seperate list from emplist
		
		er.stream()
		.map(re -> re.getId())
		.collect(Collectors.toList());
		
		
		// Given a list of integers, find out all the numbers starting with 1 using 
		// Stream functions?
//		
//		List<Integer>myList1
//		= Arrays.asList(10,15,8,49,25,98,32);
//		
//		myList1.stream()
//		.map(s -> s+"")
//		.filter(d -> d.startsWith("1"))
//		.forEach(System.out::println);
//		
//		
		 List<Integer>my 
		 =Arrays.asList(10,15,8,49,25,98,98,32,15);
		 
		 long count = my.stream()
				 .count();
		 System.out.println(count);
		
		
		System.out.println("-------------------------");
		
//		Given a list of integers, find the maximum value element present in it 
//		using Stream functions?
		
		List<Integer>check =Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		check.stream()
		.max(Integer::compare).get();
		System.out.println(check);
		
		List<Integer> list = Arrays.asList(57, 38, 37, 54, 2);
		
		list.stream()
		.sorted()
		.forEach(System.out::println);
		
		
		List<String> st =
				Arrays.asList("Stream","Operations","on","Collections");
		
		
		st.stream()
		.sorted((s5, s2) -> (s5.length()-s2.length()))
		.forEach(System.out::println);
		
		System.out.println("===================");
		
		st.stream()
		.sorted(Collections.reverseOrder())
		.forEach(System.out::println);
		
		
		System.out.println("---------------------------");
		
		
		System.out.println(" max sorted salary in employee ");
		
		er.stream()
		.sorted((s4,s2) -> s2.getSalary() - s4.getSalary())
		.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Min and max");
		
		Optional<Employee> max = er.stream()
		.max((p1,p2) -> p1.getSalary() < p2.getSalary() ? -1 
				: ((p1.getSalary()) == p1.getSalary() ? 0 : 1));
		
		System.out.println(max);
		
		
		Optional<Employee> min = er.stream()
				.min((p1,p2) -> p1.getSalary() < p2.getSalary() ? -1 
						: ((p1.getSalary()) == p1.getSalary() ? 0 : 1));
				
				System.out.println(min);
		
		Optional<Employee> emp = er.stream()
				.min((p1,p2) -> p1.getSalary() < p2.getSalary() ? -1 
						: ((p1.getSalary()) == p1.getSalary() ? 0 : 1));
				
				System.out.println(emp);
				
				
		


	}

}
