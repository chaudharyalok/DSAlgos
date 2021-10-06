package com.alok.rule21.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	List<String> a = list3.stream().flatMap(i -> i.stream()).collect(Collectors.toList());
	System.out.println(a);
											// {"efg","hjk"},
											// {"dft","yuj"}});

	}

}
