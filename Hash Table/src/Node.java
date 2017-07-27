/**
 * [OY] This class contains the methods describing the behaviour of Node objects.
 * A Node contains information about a single person. It has the person's name, 
 * phone, and email.
 * @author Omar Yusuf (oyusuf4@wgu.edu)
 * 
 */

public class Node {

	public String name;
	public String phoneEmail;	
	
	/** 
	 * [OY] Constructor
	 * @param name
	 * 			The name of the Node
	 * @param phoneEmail
	 * 			The concatenated phone and email of the Node
	 */
	public Node(String name, String phoneEmail){
		this.phoneEmail = phoneEmail;
		this.name = name;
	}
	
	/**
	 * [OY] Accessor method for an link's information
	 */
	public String getInformation(){
		String phoneBookEntry = "[" + name + " " + phoneEmail + "]";
		return phoneBookEntry;
	}	
}