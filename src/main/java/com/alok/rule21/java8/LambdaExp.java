package com.alok.rule21.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExp {

	public static void main(String[] args) {
		// custom object map sorting using streams
	Map<Employee,Integer> employees = new HashMap<>();
	employees.put(new Employee("alok",700,"IT"),40);
	employees.put(new Employee("rumit",900,"AC"),50);
	employees.put(new Employee("sumit",400,"HR"),20);
	
	
	// sorting by key
/*	employees.entrySet().stream()
	.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
	.forEach(System.out::println);*/
	
	// sorting by value
/*	employees.entrySet().stream()
	.sorted(Map.Entry.comparingByValue((a,b)->b-a))
	.forEach(System.out::println);*/
	
	List<String> list = Arrays.asList("abc","efg","bcd");
	List<String> list1 = Arrays.asList("efg","hjk","dft");
	
	List<List<String>> list3 = Arrays.asList(list,list1);
	System.out.println(list3);
	
	List<String> a = list3.stream().flatMap(List::stream).collect(Collectors.toList());
	System.out.println(a);
											// {"efg","hjk"},
											// {"dft","yuj"}});
	
	List<Integer> list4 = Arrays.asList(11,3,4,6,7,9);
	List<Integer> list5 = Arrays.asList(1,13,23,6,71,9);
	
	BiFunction<List<Integer>, List<Integer>, List<Integer>> uniqueFunction = (l1,l2) -> Stream
			.of(l1,l2).flatMap(List::stream)
			.distinct()
			.collect(Collectors.toList());
	
//	System.out.println("lambda"+uniqueFunction.apply(list4, list5));
	
	Function<List<Integer>, List<Integer>> sortingLambda = l3 -> l3.stream()
			.sorted()
			.collect(Collectors.toList());
	
//	System.out.println("lambdaS"+uniqueFunction.andThen(sortingLambda).apply(list4, list5));
	
	String str = "ankita";
	Stream<Character> stream = str.chars().mapToObj(c -> (char)c);
	System.out.println(stream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	
	Function<Employee,String> function = emp -> emp.transform();
	
//	Stream.of(str.toCharArray()).forEach(System.out::println);
	
	Employee emp1 = new Employee("name12","dept1");
	Employee emp2 = new Employee("name21","dept2");
	Employee emp3 = new Employee("name13","dept3");
	
	List<Employee> emps = new ArrayList<Employee>();
	emps.add(emp1);
	emps.add(emp2);
	emps.add(emp3);
	
	
	List<String> result = emps.stream().map(Employee::transform).collect(Collectors.toList());
	
	for(String s : result){
		System.out.println(s);
	}
	
	}

}
