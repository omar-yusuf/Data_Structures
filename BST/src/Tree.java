/**
 * [OY] This class describes the behavior of a Binary Tree for storing
 * 	phonebook entries. The Tree is composed of Nodes.
 * @author Omar Yusuf (oyusuf4@gu.edu)
 *
 */
public class Tree {

	static Node root;
	
	/**
	 * [OY] Adds a new node to the tree
	 * @param name
	 * 			The 'name' value of the node
	 * @param phoneEmail
	 * 			The concatanated phone and email
	 */
	public static void add(String name, String phoneEmail) {
		Node newNode = new Node(name, phoneEmail);
		//[OY] if there is no root, make one
		if (root == null) {
			root = newNode;
			System.out.println("ADDED: " + root.name);
		} else {
			//[OY] if there a root, use it
			Node currentNode = root;
			Node parent;
			while (true) { 
				//[OY] Algorithm to add new nodes to the tree.
				//[OY] Follows the normal logic of a binary tree
				parent = currentNode;
				if (name.compareTo(currentNode.name)<0) {
					currentNode = currentNode.leftChild;
					if (currentNode == null) {
						parent.leftChild = newNode;
						System.out.println("ADDED: " + newNode.name);
						return; // All Done
					}
				} else { 
					currentNode = currentNode.rightChild;
					if (currentNode == null) {
						parent.rightChild = newNode;
						System.out.println("ADDED: " + newNode.name);
						return;
					}
				}
			}
		}
	}

	/**
	 * [OY] Find information for given node
	 * @param name
	 * 			The name to find in the Tree
	 * @return
	 * 			
	 */
	public static String find(String name) {
		Node currentNode = root;
		String foundText = name + " was not found";
		boolean found = false;
		if(currentNode == null){
			return foundText;
		}
		while (!found){
			//[OY] If the 'name' argument matches
			if(name == currentNode.name){
				foundText = "LOOKUP: " + currentNode.name + " " + currentNode.phoneEmail;
				found = true;
			}
			//[OY] if the 'name' argument comes before lexicographically
			else if (name.compareTo(currentNode.name)<0) {
				currentNode = currentNode.leftChild;
			//[OY] if the 'name' argument comes after lexicographically
			} else {
				currentNode = currentNode.rightChild;
			}
			if (currentNode == null){
				found = true;
			}	
		}
		System.out.println(foundText);
		return foundText;
	}
	
	/**
	 * [OY] Remove a particular node from the tree
	 */
	public static boolean remove(String name){
		Node currentNode = root;
		Node parent = root;
		/*
		 * [OY] There are two stages.
		 * The first is to find the node.
		 * The second is to delete it.
		 */
		
		//[OY] Finding the node
		while(currentNode.name != name){
			parent = currentNode;
			if(currentNode.name.compareTo(name)<0){
				currentNode = currentNode.rightChild;
			} else if(currentNode.name.compareTo(name)>0){
				currentNode = currentNode.leftChild;
			}
			//[OY] If it's not found, return false
			if(currentNode == null){ 
				System.out.println(name + " was not found");
				return false;
			}
			
		}
		
		//[OY] Deleting nodes
		
		//[OY] If the node has no children
		if(currentNode.leftChild == null && currentNode.rightChild == null){
			System.out.println("REMOVED: " + currentNode.name);
			//[OY] if currentNode is a leftChild
			if(parent.leftChild != null && parent.leftChild.name == currentNode.name){
				parent.leftChild = null;
			//[OY] if currentNode is a rightChild
			} else if(parent.rightChild != null && parent.rightChild.name == currentNode.name){
				parent.rightChild = null;
			}
		}
		
		//[OY] If the node only has a left child
		else if(currentNode.leftChild != null && currentNode.rightChild == null){
			System.out.println("REMOVED: " + currentNode.name);
			if(parent.rightChild != null && parent.rightChild.name == currentNode.name){
				parent.rightChild = currentNode.leftChild;
			} else if(parent.leftChild.name == currentNode.name){
				parent.leftChild = currentNode.leftChild;
			}
		}
		
		//[OY] If the node only has a right child
		else if(currentNode.leftChild == null && currentNode.rightChild != null){			
			System.out.println("REMOVED: " + currentNode.name);
			if(parent.leftChild != null && parent.leftChild.name == currentNode.name){
				parent.leftChild = currentNode.rightChild;
			} else if(parent.rightChild.name == currentNode.name){
				parent.rightChild = currentNode.rightChild;
			}
		}
		
		//[OY] If the node has two children
		else if(currentNode.leftChild != null && currentNode.rightChild != null){
			System.out.println("REMOVED: " + currentNode.name);
			Node replacementNode = currentNode.rightChild;
			Node parentNode = new Node(null, null);
			while(replacementNode.leftChild != null){
				parentNode = replacementNode;
				replacementNode = replacementNode.leftChild;
			}
			currentNode.name = replacementNode.name;
			currentNode.phoneEmail = replacementNode.phoneEmail;
			System.out.println(currentNode.name + " to be replaced by " + replacementNode.name);
			if(parentNode.leftChild != null && parentNode.leftChild.name == currentNode.name){
				parentNode.leftChild = null;
			} else if (parentNode.rightChild != null && parentNode.rightChild.name == currentNode.name){
				parentNode.rightChild = null;
			}
		}
	return true;
	}
	
	/**
	 * [OY] The main method. Only test cases go here.
	 */
		public static void main(String[] args) {
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
