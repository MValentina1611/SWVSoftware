package model;

import java.util.ArrayList;

import strcs_LA.GraphLA;
import strcs_LA.VertexLA;
import strcs_AVL.Node;

public class DeliveryRoute {
	
	private GraphLA<Child> route;
	
	
	public DeliveryRoute(String initial, ArrayList<Node<Child>> childrenByCountry)
	{
		ArrayList<Child> childrenPerInitial = new ArrayList<Child>();
		
		for(int i = 0; i < childrenByCountry.size(); i++)
		{
			String initialToCompare = String.valueOf(childrenByCountry.get(i).getElement().getName().charAt(0));
			
			if(initialToCompare.equalsIgnoreCase(initial))
			{
				childrenPerInitial.add(childrenByCountry.get(i).getElement());
			}
			
		}
		
		createRoute(childrenPerInitial);
		
	}
	
	private void createRoute(ArrayList<Child> childrenByName)
	{
		for(int i = 0; i< childrenByName.size()-1; i++)
		{
			VertexLA<Child> vi = new VertexLA<Child>(childrenByName.get(i));
			VertexLA<Child> vf = new VertexLA<Child>(childrenByName.get(i+1));
			route.addEdge(vi, vf, defineDistance(vi.getElement(), vf.getElement()));
		}
			
	}
	
	private int defineDistance(Child vi, Child vf)
	{
		int distance = 0;
		String viInitial = String.valueOf(vi.getCity().charAt(0));
		String vfInitial = String.valueOf(vf.getCity().charAt(0));
		
		if(viInitial.equalsIgnoreCase("A") && (vfInitial.equalsIgnoreCase("A") || vfInitial.equalsIgnoreCase("E") 
				|| vfInitial.equalsIgnoreCase("I") || 
				vfInitial.equalsIgnoreCase("O") || vfInitial.equalsIgnoreCase("U"))){
			
			distance = 100;
		}
		else if(isConsonant(viInitial) == true &&  isConsonant(vfInitial) == false || isConsonant(vfInitial) == true &&  isConsonant(viInitial) == false)  
		{
			distance = distanceBetweenConsonantandVowels();
		}
		else if(vi.getCity().equalsIgnoreCase(vf.getCity()))
		{
			distance = distanceSameCity();
		}
		
		return distance;
	}
	
	private boolean isConsonant(String letter)
	{
		if(!letter.equalsIgnoreCase("A") && !letter.equalsIgnoreCase("E") && !letter.equalsIgnoreCase("I")
				&& !letter.equalsIgnoreCase("O") && !letter.equalsIgnoreCase("U"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	private int distanceBetweenConsonantandVowels()
	{
		int distance = (int)(Math.random()*1000);
		
		if(distance >= 30 && distance <= 150)
		{
			if(distance % 3 == 0)
			{
				return distance;
			}
			else
			{
				return distanceBetweenConsonantandVowels();
			}
		}
		else
		{
			return distanceBetweenConsonantandVowels();
		}
		
	}
	
	private int distanceSameCity()
	{
		int distance = (int)(Math.random()*100+1);
		if( distance >= 10 && distance <= 30 )
		{
			return distance;
		}
		else
		{
			return distanceSameCity();
		}
		
	}
	
	
	
	
}
