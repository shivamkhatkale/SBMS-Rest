package com.app.raghu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// Use streams to filter even numbers and print them.

		numbers.stream()
		.filter(v -> v % 2 == 0)
		.forEach(System.out::println);
		
		List<String> names = Arrays.asList("shivam", "ramesh", "khatkale");
		// Use streams to convert each name to uppercase.
			
		names.stream()
		.map(x -> x.toUpperCase())
		.forEach(System.out::println);
		
		
		List<Integer> num = Arrays.asList(10, 20, 30, 55, 60, 70);
		// Use streams to find the first number greater than 50.
		
		Optional<Integer> a = num.stream()
		.filter(x -> x > 50)
		.findFirst();
		
		System.out.println(a);
		
		List<Integer> num1 = Arrays.asList(5, 10, 15, 20, 25);
		// Use streams to find the sum of all elements.
		
		System.out.print("Sum of all elements : ");
		int val = 
		num1.stream()
		.mapToInt(Integer::intValue)
		.sum();
		
		System.out.println(val);
		
		
		// INtermediate opertations 
		List<Integer> num3 = Arrays.asList(12, 45, 78, 34, 89, 21);
		// Find the maximum and minimum numbers using streams.
		
		Optional<Integer> maxi =
				num3.stream()
				.max(Integer::compareTo);
		Optional<Integer> mini =
				num3.stream()
				.min(Integer::compareTo);
		System.out.println(maxi);
		System.out.println(mini);
		
		
		
		List<Integer> duplicates = Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6);
		// Use streams to remove duplicates.

		duplicates.stream()
		.distinct()
		.forEach(x -> System.out.print(x +" "));
		System.out.println();
		
		List<String> words = Arrays.asList("Banana", "Apple", "Mango", "Grapes");
		// Sort the list in reverse alphabetical order using streams.
		
		words.stream()
		.sorted((s1,s2) -> s2.compareTo(s1))
		.forEach(System.out::println);
		
		System.out.println("GRoup lengtj");
		
		List<String> word = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
		Map<Integer, List<String>> groupedByLength = word.stream()
		                                                  .collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);

		//  Find the Second Highest Number:
		List<Integer> n = Arrays.asList(10, 20, 35, 50, 60, 35, 70);
		int secondHighest = n.stream()
		                           .distinct()
		                           .sorted(Comparator.reverseOrder())
		                           .skip(1)
		                           .findFirst()
		                           .orElseThrow();
		System.out.println(secondHighest);
		
		System.out.println("--------------------------");
				
		List<List<Integer>> listOfLists = Arrays.asList(
			    Arrays.asList(1, 2, 3),
			    Arrays.asList(4, 5, 6),
			    Arrays.asList(7, 8, 9)
			);
			List<Integer> flattenedList = listOfLists.stream()
			                                         .flatMap(List::stream)
			                                         .collect(Collectors.toList());
			System.out.println(flattenedList);


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
