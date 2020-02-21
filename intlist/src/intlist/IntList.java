package intlist;

/** node class kan ook nested in intlist gezet worden als public private*/
class Node {
	int value;
	Node next;
}

public class IntList {
	
	private Node firstNode;

	public int getSize() {
		int count = 0; 
		Node node = firstNode;
		while (node!=null) {
			count++;
			node = node.next;
		}
		return count;
	}

	/**
	 * @pre given index is between and size of list - 1
	 * 		| 0<= index && index < getSize()
	 * 
	 */
	
	public int get(int index) {
		Node node = firstNode;
		for (int i = 0; i<index;i++) 
			node = node.next;
		return node.value;	
	}
	
	public int[] getElements() {
		int [] result = new int[getSize()];
		Node node = firstNode;
		for (int i=0; i<result.length;i++) {
			result[i] = node.value;
			node = node.next;
		}
		return result;	
	}

	/**
	 * 
	 * @post adds given value to end of list
	 * 		| getSize() == old(getSize())+1
	 * @post elements of this list are the old ones with the given element => extra 'inspector' is handig.
	 * 		| Arrays.equals(getElements(), 0, old(getSize()),old(getElements()), 0, old(getSize()))
	 * @post last element in list equals given value
	 * 		| getElements()[old(getSize())] == value
	 * 
	 */
	
	public void add(int value) {
		if (firstNode == null) {
			firstNode = new Node();
			firstNode.value = value;
		} else {
			Node node = firstNode;
			while (node.next != null)
				node = node.next;
			node.next = new Node();
			node.next.value = value;
		}
	}
	
	/**
	 * removes the element at the given index from this list
	 * @pre given index between 0(incl) and list's size (excl)
	 * 		| 0<= index && index < getSize()
	 * @post list's size equals its old minus one
	 * 		| getSize() == old(getSize()) - 1
	 * @post list's elements at indices less than given index have remained unchanged (for-loop kan niet gebruikt worden hier!)
	 * 		| Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post 
	 * 		| Arrays.equals(getElements(), index, getSize(), old(getElements()), index +1, old(getSize()))
	 *
	 * 
	 */

	public void remove(int index) {
		if (index == 0) {
			firstNode = firstNode.next;
		} else {
			Node node = firstNode;
			for (int i = 0; i <index-1;i++)
				node = node.next;
			node.next = node.next.next;
			
		}
					
		
	}

	/**
	 * inserts given value into list at given index
	 * 
	 * @pre given index is between 0 and list's size(incl)
	 * 		| 0<= index && index <= getSize()
	 * @post list's size equals to old one plus one.
	 * 		| getSize() == old(getSize())+1
	 * @post elements at indices less than given index have remained unchanged 
	 * 		| Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post the elements at the given indices greater than the given index equal the elements at an indew one less than the old list
	 * 		| Arrays.equals(getElements(), index +1, getSize(), old(getElements()), index, old(getSize()))
	 * @post the element at the given index equals the given value
	 * 		| getElements()[index] == value
	 * 
	 */
	
	public void insert(int index, int value) {
		/**eerst if eigenlijk redundant, mag ook weg evt*/
		if (firstNode == null) {
			firstNode = new Node();
			firstNode.value = value;
		} else {
			if(index == 0) {
				Node node = firstNode;
				firstNode = new Node();
				firstNode.value = value;
				firstNode.next = node;
			} else {
				Node node = firstNode;
				for (int i = 0; i<index -1;i++)
					node = node.next;
				Node nextNode = node.next;
				node.next = new Node();
				node.next.value = value;
				node.next.next = nextNode;
			}
		}
		
		
		
	} 
	
	
	

}
