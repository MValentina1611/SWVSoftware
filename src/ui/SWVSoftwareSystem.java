package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Child;
import model.DeliveryRoute;
import model.SantaList;

public class SWVSoftwareSystem {
	
	private static DeliveryRoute deliveryRoute;
	private static SantaList santaList;
	private static Scanner reader;
	private static ArrayList<Child> delivered;
	//Method main start.
		public static void main( String args [] )
		{
			santaList = new SantaList();
			int menuOp = 0;
			delivered = new ArrayList<Child>();
			reader = new Scanner(System.in);
			
			
			System.out.println("The App is initializing...");
			
			System.out.println(
					"-=-=-=-=-=-=-=-=-=-=-=-=- W E L C O M E  T O  THE   S W V   S Y S T E M -=-=-=-=-=-=-=-=-=-=-=-=-\n" +
					"Before trace the route you need uppload the good kids list.\nPress \"1\"" );
			int firstMenu = 0;
			
			firstMenu = reader.nextInt();
			if(firstMenu == 1)
			{
				reader.nextLine();
				
				do
				{
					menuOp = showMenu();
					executeOptions(menuOp);

				}while( menuOp != 4 );

				//Trazar ruta.
			}			
		}

		public static int showMenu() 
		{
			int menuOp = 0;
			System.out.println("This is the list of children: \n");
			showList();
				
			System.out.println(
					"(1)Add a child \n" + 
					"(2)Delete a Child\n"+
					"(3)Search a child\n"+
					"(4)Okay, trace the route");
			
			
			menuOp = reader.nextInt();
			reader.nextLine();
			return menuOp;

		}//Method ends
		

		
		public static void executeOptions(int menuOp) 
		{
			
			switch( menuOp ) 
			{
				case 1:
					addChild();
					break;
				case 2:
					deleteChild();;
					break;
		
				case 3:
					searchChild();
					break;
			
				case 4:
					createRoute();
					break;
				default:
					System.out.println("Error, invalid option");
			}
	 		
		}
		
 
		public static void showList()
		{
			System.out.println("ShowList");
			
			
			for(int i = 0; i < santaList.getToShow().size();i++)
			{
				System.out.println(santaList.getToShow().get(i).toString2()+"\n");
			}
		}
	
		public static void addChild(  )
		{
			int age = 0;
			String name = "";
			String lastname = "";
			String country = "";
			String city = "";
			String address = "";
			String toy = "";
			
			
			System.out.println("Enter the info: ");
			System.out.print("\nAge: ");
			age = reader.nextInt();
			reader.nextLine();
			System.out.print("\nName: ");
			name = reader.nextLine();
			System.out.print("\nLastname: ");
			lastname = reader.nextLine();
			System.out.print("\nCountry: ");
			country = reader.nextLine();
			System.out.print("\nCity: ");
			city = reader.nextLine();
			System.out.print("\nAddress: ");
			address = reader.nextLine();
			System.out.print("\nToy: ");
			toy = reader.nextLine();
			
			Child toAdd = new Child(age, name, lastname, country, city, address, toy);
			santaList.addChild(toAdd);
		}
		
		public static void deleteChild()
		{
			int age = 0;
			String name = "";
			String lastname = "";
			String country = "";
			String city = "";
			String address = "";
			String toy = "";
			
			
			System.out.println("Enter the info: ");
			System.out.print("\nAge: ");
			age = reader.nextInt();
			reader.nextLine();
			System.out.print("\nName: ");
			name = reader.nextLine();
			System.out.print("\nLastname: ");
			lastname = reader.nextLine();
			System.out.print("\nCountry: ");
			country = reader.nextLine();
			System.out.print("\nCity: ");
			city = reader.nextLine();
			System.out.print("\nAddress: ");
			address = reader.nextLine();
			System.out.print("\nToy: ");
			toy = reader.nextLine();
			
			Child toDelete = new Child(age, name, lastname, country, city, address, toy);
			santaList.deleteChild(toDelete);
		}
	
		public static Child searchChild()
		{
			int age = 0;
			String name = "";
			String lastname = "";
			String country = "";
			String city = "";
			String address = "";
			String toy = "";
			
			
			System.out.println("Enter the info: ");
			System.out.print("\nAge: ");
			age = reader.nextInt();
			reader.nextLine();
			System.out.print("\nName: ");
			name = reader.nextLine();
			System.out.print("\nLastname: ");
			lastname = reader.nextLine();
			System.out.print("\nCountry: ");
			country = reader.nextLine();
			System.out.print("\nCity: ");
			city = reader.nextLine();
			System.out.print("\nAddress: ");
			address = reader.nextLine();
			System.out.print("\nToy: ");
			toy = reader.nextLine();
			
			Child toSearch = new Child(age, name, lastname, country, city, address, toy);
			return santaList.getSantaListByNames().search(toSearch);
		}
		
		
		public static void createRoute()
		{
			String country = "";
			String initial = "";
			
			System.out.println("Enter the coutry which Santa wants: \n");
			country = reader.nextLine();
			System.out.println("Enter the initial letter of the name of the children: \n");
			initial = reader.nextLine();
			deliveryRoute = new DeliveryRoute(initial, santaList.countryFilter(country));
			
			showTheNextChild();
		}

		public static void showTheNextChild()
		{
			Child [] toShow = (Child[]) deliveryRoute.getRoute().getGraph().keySet().toArray();
			int count = 0;
			String buffer = "";
			while(count < toShow.length)
			{
				System.out.println("The next child of the list is:\n"+toShow[count].toString2());
				System.out.println("Press enter for watch the next child: ");
				delivered.add(toShow[count]);
				buffer = reader.nextLine();
				if(buffer.equals("\n"))
				{
					count++;
				}
			}
				
				
			
		}
}
