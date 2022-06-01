package model;

public class Child {

	private int age;
	private String name;
	private String lastname;
	private String country;
	private String city;
	private String address;
	private String toy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String  toString()
	{
		String info = "";
		
		info = "NAME: "+name+"\nLASTNAME:"+lastname+"\nAGE: "+age+"\nTOY: "+toy+"\nCOUNTRY: "+country+"\nCITY: "+city+"\nADDRESS: "+address+"\n";
		return info;
	}
	
}
