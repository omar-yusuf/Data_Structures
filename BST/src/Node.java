/**
 *[OY] This class describes the behavior of a Node for storing
 * 	phonebook entries.
 * @author Omar Yusuf (oyusuf4@wgu.edu)
 *
 */
class Node {

	String name;
	String phoneEmail;

	Node leftChild;
	Node rightChild;

	Node(String name, String phoneEmail) {
		this.name = name;
		this.phoneEmail = phoneEmail;
	}
	public String toString() {
		return name;
	}

}