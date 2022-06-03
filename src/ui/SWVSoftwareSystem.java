package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import model.Child;
import model.DeliveryRoute;
import model.SantaList;

public class SWVSoftwareSystem {
	
	private DeliveryRoute deliveryRoute;
	private static SantaList santaList;
	private static Scanner reader;
	
	//Method main start.
		public static void main( String args [] )
		{
			santaList = new SantaList();
			int menuOp = 0;
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
					System.out.println("Trace the route");
					break;
				default:
					System.out.println("Error, invalid option");
			}
	 		
		}
		
 
		public static void showList()
		{
			for(int i = 0; i < santaList.getToShow().size();i++)
			{
				System.out.println(santaList.getToShow().get(i).toString()+"\n");
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

}
