package model;

import java.util.Comparator;

public class ComparatorNames implements Comparator<Child>{

	@Override
	public int compare(Child o1, Child o2) {
		
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
	
	

}
