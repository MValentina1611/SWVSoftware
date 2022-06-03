package model;

import java.util.ArrayList;

import strcs_AVL.AVLT;
import strcs_AVL.Node;

public class SantaList {
	
	ComparatorCountry c = new ComparatorCountry();
	ComparatorNames n = new ComparatorNames();
	private AVLT<Child> santaListByCountry = new AVLT<Child>(c );
	private AVLT<Child> santaListByNames = new AVLT<Child>(n );
	
	//Add child
	public void addChild(Child toAdd)
	{
		santaListByCountry.add(toAdd);
		santaListByNames.add(toAdd);
	}
	
	
	//Filtered function
	public ArrayList<Node<Child>> countryFilter(String country)
	{
		if(santaListByCountry.getRoot() == null)
		{
			return null;
		}
		else
		{
			return countryFilter(santaListByCountry.getRoot(), country);
		}
	}

	private ArrayList<Node<Child>> countryFilter(Node<Child> current, String country) 
	{
		
		ArrayList<Node<Child>> filtered = new ArrayList<Node<Child>>();
		
		while( current != null )
		{
			if(current.getElement().getCountry().equals(country))
			{
				filtered.add(current);
			}
			else if( country.compareTo(current.getElement().getCountry()) > 0)
			{
				current = current.getRight();
			}
			else
			{
				current = current.getLeft();
			}
		}
		return filtered;
	}	 
	
	//DeleteChild

	public void deleteChild(Child toDelete)
	{
		santaListByCountry.delete(toDelete);
		santaListByNames.delete(toDelete);
	}
	
}
