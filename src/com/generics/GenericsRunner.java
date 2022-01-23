package com.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {

	// Generic methods
	// doubleValue converts and Integer to a Double
	static <X> X doubleValue(X value) {
		return value;
	}

	static <X extends List> void duplicate(X list) {
		list.addAll(list);
	}

	// Wild card '?'
	// When to choose Upper or Lower Bounded
	// use the Get/Put principle
	// This is an upper bounded wild card
	// we are passing it arguments to Get
	static double sumOfNumberList(List<? extends Number> numbers) {
		double sum = 0.0;
		for (Number number : numbers) {
			sum += number.doubleValue();
		}
		return sum;
	}

	// This is a lower bounded wild card
	// we are passing it arguments to Put
	static void addACoupleOfValues(List<? super Number> numbers) {
		// Any type which is a subclass of Number can be added
		numbers.add(1);
		numbers.add(1.0);
		numbers.add(1.0f);
		numbers.add(1l);
	}

	public static void main(String[] args) {

		System.out.println(sumOfNumberList(List.of(1, 2, 3, 4, 5)));
		System.out.println(sumOfNumberList(List.of(1.1, 2.1, 3.1, 4.1, 5.1)));
		System.out.println(sumOfNumberList(List.of(1l, 2l, 3l, 4l, 5l)));

		// Generic method calls
		String value1 = doubleValue(new String());
		Integer number1 = doubleValue(Integer.valueOf(5));
		ArrayList list1 = doubleValue(new ArrayList());

		ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
		duplicate(numbers);
		System.out.println(numbers);

		// Generic classes
		MyCustomList<String> list = new MyCustomList<>();
		list.addElement("Element 1");
		list.addElement("Element 2");
		String value = list.get(0); // get(index)

		System.out.println(list);
		System.out.println(value);

		MyCustomList<Integer> list2 = new MyCustomList<>();
		list2.addElement(Integer.valueOf(5));
		list2.addElement(Integer.valueOf(7));
		Integer number = list2.get(0); // get(index)

		System.out.println(list2);
		System.out.println(number);
	}

}
