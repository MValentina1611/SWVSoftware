package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import strcs_AVL.AVLT;
import strcs_AVL.Node;

public class SantaList {
	
	ComparatorCountry c = new ComparatorCountry();
	ComparatorNames n = new ComparatorNames();
	private AVLT<Child> santaListByCountry;
	private AVLT<Child> santaListByNames;
	ArrayList<Child> toShow;
	private static final String FILE_LIST = "goodChildren.txt";
	
	public SantaList()
	{
		ComparatorCountry c = new ComparatorCountry();
		ComparatorNames n = new ComparatorNames();
		santaListByCountry = new AVLT<Child>(c );
		santaListByNames = new AVLT<Child>(n );
		toShow = new ArrayList<Child>();
	}
	
	
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
	
	
	public void importData() throws java.io.IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(FILE_LIST) );
		String line = br.readLine();
			
			while( line != null )
			{
				String [] info = line.split("\\;");
				String name  = info[0];
				String lastname  = info[1];
				String country = info[3];
				String city  = info[4];
				String address = info[5];
				String toy  = info[6];
				try 
				{
					
					int age = Integer.parseInt(info[2]);		
					Child childToAdd = new Child(age,name,lastname,country,city,address,toy);
					addChild(childToAdd);
					toShow.add(childToAdd);
				}
				catch(NumberFormatException ex){}
									
				line = br.readLine();
			}	
			br.close();
			
		
	}
	
	
	public ArrayList<Child> getToShow()
	{
		return toShow;
	}
	
	public AVLT<Child> getSantaListByNames()
	{
		return santaListByNames;
	}
}
