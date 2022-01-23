package com.generics;

import java.util.ArrayList;

// Once you specify the variable type on a class
// where ever you typically specify a type you can
// update all the places and use the generic as the TYPE
public class MyCustomList<T> {

	ArrayList<T> list = new ArrayList<>();

	public void addElement(T element) {
		list.add(element);
	}

	public void removeElement(T element) {
		list.remove(element);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	// Return the TYPE T
	public T get(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

}
