/**
 * [OY] This class describes the behavior of a Hash Table for storing
 * 	phonebook entries. The Hash Table is composed of multiple NodeLists.
 * @author Omar Yusuf (oyusuf4@wgu.edu)
 */

public class HashTable {

	static NodeList[] hashArray = new NodeList[13];
	
	/**
	 * [OY] Constructor
	 */
	public HashTable(){
		for(int i = 0; i < 13; i++){
			hashArray[i] = new NodeList();
		}
	}
	
	/**
	 * [OY] Hash the input argument 'name'
	 * @param name
	 * 			The argument to hash
	 * @return
	 * 			the hashed number (between 0-12)
	 */
	public static int hashName(String name){
		int hashedName = name.toUpperCase().hashCode()%13;
		if(hashedName < 0){
			hashedName = hashedName * -1;
		}
		return hashedName;
	}
	
	/**
	 * [OY] Display the full hash table
	 */
	public static void getInformation(){
		System.out.println("----------------THE FULL HASHTABLE--------------");
		//Cycle through all the buckets and print the contents of each one.
		for(int i = 0; i < 13; i++){
			System.out.println("Bucket " + i);
			HashTable.hashArray[i].getInformation();
			System.out.println();
		};
		
	}
	
	/**
	 * [OY] add a new entry into the hash table
	 * @param name
	 * 			The name of the person to be added
	 * @param phoneEmail
	 * 			The concatenated phone and email of the person to be added 
	 */
	public static void add(String name, String phoneEmail){
		int hashedName = hashName(name);
		hashArray[hashedName].add(name, phoneEmail);
		System.out.println("ADDED: " + name);
	}
	
	/**
	 * [OY] Search a NodeList for a given name
	 * 
	 * @param name
	 * 			The term to search
	 * @return 
	 * 			Whether or not the 'name' argument was found.
	 */
	public static void find(String name){
		int hashedName = hashName(name);
		NodeList searchArray = HashTable.hashArray[hashedName];
		String foundText = name + " was not found";
		for(int i = 0; i < searchArray.size; i++){
			if(searchArray.nodeList[i].name == name){
				foundText = "LOOKUP: " + searchArray.nodeList[i].name + " " + searchArray.nodeList[i].phoneEmail;
			}
		}
		System.out.println(foundText);
	}
	
	/**
	 * [OY] Remove an entry from the hashtable.
	 */
	public static void remove(String name){
		//[OY] Declarations
		int hashedName = hashName(name);
		NodeList searchNodeList = hashArray[hashedName];
		int i = 0;
		boolean found = false;
		
		//[OY] If the name isn't found
		if(!searchNodeList.find(name)){
			System.out.println(name + " was not found");
			found = true;
		}
		
		//[OY] Search the NodeList for the proper name.
		//[OY] Switch 'found' to be true when finished.
		while(!found && i < searchNodeList.size){
			//[OY] if you DO find the name
			if(searchNodeList.nodeList[i].name == name){
				//[OY] Shift everything greater than i down by one
				for(; i<searchNodeList.size-1; i++){
					searchNodeList.nodeList[i] = searchNodeList.nodeList[i+1];
				}
				System.out.println("REMOVED: " + name);
				found = true;
			}
			else{ //[OY] if you DON'T find the name
				i++;
			}
		}
		//[OY] Decrement the size by one, since an entry was removed.
		searchNodeList.size--;
	}
	
	/**
	 * [OY] The Main Method. Only the test cases go here.
	 */
	public static void main(String[] args) {
		new HashTable();
		add("Bob Smith", "555-235-1111 bsmith@somewhere.com");
		add("Jane Williams","555-235-1112 jw@something.com");
		add("Mohammed al-Salam","555-235-1113 mas@someplace.com");
		add("Pat Jones", "555-235-1114 pjones@homesweethome.com");
		add("Billy Kidd","555-235-1115 billy_the_kid@nowhere.com");
		add("H. Houdini", "555-235-1116 houdini@noplace.com");
		add("Jack Jones","555-235-1117 jjones@hill.com");
		add("Jill Jones","555-235-1118 jillj@hill.com");
		add("John Doe", "555-235-1119 jdoe@somedomain.com");
		add("Jane Doe","555-235-1120 jdoe@somedomain.com");
		find("Pat Jones");
		find("Billy Kidd");
		remove("John Doe");
		add("Test Case", "555-235-1121 Test_Case@testcase.com");
		add("Nadezhda Kanachekhovskaya", "555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		add("Jo Wu", "555-235-1123 wu@h.com");
		add("Millard Fillmore","555-235-1124 millard@theactualwhitehouse.us");
		add("Bob vanDyke","555-235-1125 vandyke@nodomain.com");
		add("Upside Down", "555-235-1126 upsidedown@rightsideup.com");
		find("Jack Jones");
		find("Nadezhda Kanachekhovskaya");
		remove("Jill Jones");
		remove("John Doe");
		find("Jill Jones");
		find("John Doe");
	}

}