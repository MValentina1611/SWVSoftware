package model;

import java.util.Comparator;

public class ComparatorCountry implements Comparator<Child>{

	@Override
	public int compare(Child o1, Child o2) {
		
		return o1.getCountry().compareToIgnoreCase(o2.getCountry());
	}

}
