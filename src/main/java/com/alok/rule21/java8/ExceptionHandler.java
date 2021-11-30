package com.alok.rule21.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExceptionHandler {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("12", "10", "4x");

		// List<Integer> list2 =
		// list.stream().map(Integer::parseInt).collect(Collectors.toList());

		// List<Integer> list3 = list.stream().map(i ->
		// Integer.parseInt(i)).collect(Collectors.toList());

		// exception handling approach 1
		// list.forEach(ExceptionHandler::printList);

		// exception handling approach 2
		/*
		 * list.forEach(i -> { try{ System.out.println(Integer.parseInt(i));
		 * }catch(NumberFormatException exp){
		 * System.out.println(exp.getMessage()); } });
		 */

		// approach 3 
	//	list.forEach(handleException(i -> System.out.println(Integer.parseInt(i))));
		
		// approach 4 for generic exception
		list.forEach(handlerGenericExp(i -> System.out.println(Integer.parseInt(i)),NumberFormatException.class));

		List<Integer> list4 = Arrays.asList(1,0);
		
		list4.forEach(handlerGenericExp(i -> System.out.println(10/i),ArithmeticException.class));
		
		// for checked exception
		List<Integer> list5 = Arrays.asList(10,20);
		list5.forEach(handleCheckedExpConsumer(Thread::sleep));
		
		
		
	}

	public static void printList(String s) {

		try {
			System.out.println(Integer.parseInt(s));
		} catch (Exception exp) {
			System.out.println("Exception:" + exp.getMessage());
		}
	}

	public static Consumer<String> handleException(Consumer<String> handler) {

		return obj -> {
			try {
				handler.accept(obj);
			} catch (Exception exp) {
				System.out.println("Exception:" + exp.getMessage());
			}
		};
	}

	public static <Target, ExpObj extends Exception> Consumer<Target> handlerGenericExp(Consumer<Target> handler,
			Class<ExpObj> expClass) {

		return obj -> {
			try {
				handler.accept(obj);

			} catch (Exception exp) {
				try {
					ExpObj expObj = expClass.cast(exp);
					System.out.println("Exception:" + expObj.getMessage());
				} catch (ClassCastException exc) {
					throw exp;
				}

			}
		};
	}
	
	public static <Target> Consumer<Target> handleCheckedExpConsumer(CheckedExpHandlerConsumer<Target,Exception> hadlerConsumer){


		return obj -> {
			try {
				hadlerConsumer.accept(obj);
			} catch (Exception exp) {
				throw new RuntimeException(exp);
			}
		};
	
	}

}
