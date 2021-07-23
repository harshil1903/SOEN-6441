package Basket;

// Having the following type bound would allow a Basket to only contain Fruits 
// by disallowing the declaration of Basket objects with a type parameter that 
//is not a Fruit type.  
//
//public class Basket<E extends Fruit>
public class Basket<E> {
	private E element;

	public void put(E x) {
		element = x;
	}

	public E get() {
		return element;
	}

	public void inspect() {
		System.out.println("in Basket::inspect()");
		System.out.println("E: " + element.getClass().getName());
	}
}
