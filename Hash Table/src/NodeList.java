 /**
 * [OY] This class describes the behavior of a NodeList for storing
 * 	phonebook entries. The Hash Table is composed of multiple Nodes.
 * @author Omar Yusuf (oyusuf4@wgu.edu)
 * 
 */
class NodeList{
	
	public int size = 0;
	Node[] nodeList = new Node[size];
	
	/**
	 * [OY] Add a new entry to the NodeList
	 * @param name
	 *			The name of the person to add
	 * @param phoneEmail
	 * 			The concatenated phone and email of the person to add
	 */
	public void add(String name, String phoneEmail){
		Node newNode = new Node(name, phoneEmail);
		Node[] newArray = new Node[size+1];
		for(int i = 0; i < size; i++){
			newArray[i] = nodeList[i];
		}
		newArray[size] = newNode;
		size++;
		nodeList = newArray;
		newArray = null;
		
	}

	/**
	 * [OY] Search for a particular entry in the NodeList
	 * @param name
	 * 			The name to search for
	 * @return
	 * 			Whether or not the search term was found
	 */
	public boolean find(String name){
		boolean found = false;
		for(int i = 0; i < size; i++){
			if(nodeList[i].name == name){
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * [OY] Output the current information of a NodeList
	 */
	public void getInformation(){
		for(int i = 0; i < size; i++){
			System.out.println(nodeList[i].getInformation() + " ");
		}
		if(size == 0){
			System.out.println("[null]");
		}
	}
}