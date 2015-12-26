/**
 * 
 */
package com.ars.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author arsen
 * 
 */
public class ListGeneric {

	public static List<String> toComapreStrList = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("12-14");
		strList.add("6");
		strList.add("4");
		strList.add("18-20");
		strList.add("3");

		List<Integer> ints = new ArrayList<Integer>();
		for (String s : strList) {

			if (s.contains("-")) {
				toComapreStrList.add(s);
				for (String ss : s.split("-")) {

					int i = Integer.parseInt(ss);
					ints.add(i);
				}
			} else {
				int y = Integer.parseInt(s);
				ints.add(y);
			}
		}
		Collections.sort(ints);
		System.out.println(ints);
		createOrdered(ints);
	}

	/**
	 * 
	 * @param source
	 * @return
	 */
	public static List<String> createOrdered(List<Integer> source) {

		List<String> orderedList = new ArrayList<String>();
		int i=0;
		for (Integer ints : source) {

			String str = String.valueOf(ints);

			if (!toComapreStrList.isEmpty() && toComapreStrList.get(0).startsWith(str)) {
				orderedList.add(toComapreStrList.get(0));
				toComapreStrList.remove(0);
				i++;
			} else {
				if(orderedList.isEmpty()){
					orderedList.add(str);
				}else if (!orderedList.get(i).startsWith(str) && !orderedList.get(i).endsWith(str)) {
					orderedList.add(str);
					i++;
				}
				
			}
			
		}
		return orderedList;
	}

}
