package intlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class intListTest {
	

	@Test
	void test() {
		IntList myList = new IntList();
		/** assert myList.firstNode == null; geeft error want is private in class IntList*/
		myList.add(7);
		myList.add(42);
		assert myList.getSize() == 2;
		assert myList.get(0) == 7;
		assert myList.get(1) == 42;
		myList.add(33);
		myList.add(77);
		myList.remove(0);
		assert myList.getSize()==3;
		assert myList.get(0) == 42;
		assert myList.get(1)==33;
		assert myList.get(2)==77;
		myList.remove(1);
		assert myList.getSize()==2;
		assert myList.get(0) == 42;
		assert myList.get(1)==77;
		
		myList.insert(1,99);
		myList.insert(0,110);
		assert myList.getSize()==4;
		assert myList.get(0) == 110;
		assert myList.get(1)==42;
		assert myList.get(2)==99;
		assert myList.get(3)==77;
		
		



	}

}
