package Basket;
import Fruits.Apple;
import Fruits.Fruit;
import Fruits.Orange;

public class BasketDriver {
	public static void main(String[] args) {
		// declare a raw Basket, instantiated with a raw Basket object
		// Warning though, as b can now contain anything, as the Basket
		// does not have any type bound. If Basket would have a type bound in
		// its definition,
		// e.g. Basket<E extends Fruit>, b could only contain Fruits or its
		// subtypes
		Basket b = new Basket();
		// Basket b can contain anything!
		b.put(new Object());
		b.inspect();
		// Type safety: The method setElement(Object) belongs to the raw type
		// Basket. References to generic type Basket<E> should be parameterized
		// Problem: b was defined as a raw Basket, i.e. a Basket that can
		// contain Objects
		// This seems to be fine:
		b.put(new Apple());
		b.inspect();

		// declare a raw Basket, instantiated with a Basket of Fruit
		Basket b1 = new Basket<Fruit>();
		// Even if b1 was initialized with a Basket of Fruit, it can contain
		// anything!
		b1.put(new Object());
		b1.inspect();

		// Declare a basket of Objects
		// Can then put an Orange in it, as Orange is a subtype of Object.
		Basket<Object> b4 = new Basket<Object>();
		b4.put(new Orange());
		b4.inspect();

		// declare a Basket of Fruit, instantiated with a Basket of Fruit
		Basket<Fruit> b2 = new Basket<Fruit>();
		b2.put(new Fruit());
		b2.inspect();
		// b2 can contain only Fruits or its subtypes
		// b2.setElement(new Object());
		// such as Apple
		b2.put(new Apple());
		b2.inspect();
		// Take the Apple from the Basket<Fruit>, cast it into an Apple
		Apple a = (Apple) b2.get();
		// Take the Apple from the Basket<Fruit>, cast it into an Orange
		// this creates a ClassCastException runtime exception at runtime
		//Orange o = (Orange) b2.get();

		Basket<Apple> b5 = new Basket<Apple>();
		// put() takes a parameter of the parameter type used in object
		// instantiation,
		// i.e. Apple. Fruit is not a kind of Apple.
		// b5.put(new Fruit());

		// Type mismatch: cannot convert from Basket<Fruit> to Basket<Apple>
		// The reason is NOT that Fruit is not a subtype of Apple. The reason
		// is that Basket<Fruit> and Basket<Apple> are unrelated.
		// Basket<Apple> b3 = new Basket<Fruit>();

		// Type mismatch: cannot convert from Basket<Apple> to Basket<Fruit>
		// Even though Apple is a subtype of Fruit, Basket<Fruit> and
		// Basket<Apple> are unrelated
		// Basket<Fruit> b4 = new Basket<Apple>(); // WRONG !!!

		// This creates a "Basket of unknown type", which replaces E with
		// "unknown" in b5.
		Basket<?> b3 = new Basket<Apple>();
		// The method setElement(capture#1-of ?) in the type Basket<capture#1-of
		// ?> is not applicable for the arguments (Orange)
		// setElement thus now gets a parameter of type "unknown", and "unknown"
		// and Orange are unrelated types, and "unknown" is not Object.
		// b3.setElement(new Orange());
		// b3.inspect();

		// 1. Cannot instantiate the type Basket<?>
		// 2. Type mismatch: cannot convert from Basket<?> to Basket<Apple>
		// Basket<Apple> b4 = new Basket<?>();

	}
}