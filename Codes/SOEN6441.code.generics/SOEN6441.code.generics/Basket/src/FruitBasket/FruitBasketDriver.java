package FruitBasket;
import Fruits.Apple;
import Fruits.Fruit;
import Fruits.Orange;

public class FruitBasketDriver {
	public static void main(String[] args) {
		// declare a raw FruitBasket, instantiated with a raw FruitBasket object
		// Warning though, as b can now contain any kind of Fruit, as FruitBasket
		// is bound to Fruit. 
		FruitBasket b = new FruitBasket();
		// FruitBasket b cannot contain Object, as it has a bound on Fruit
		// b.put(new Object());
		// b.inspect();
		// Type safety: The method setElement(Object) belongs to the raw type
		// FruitBasket. References to generic type FruitBasket<E> should be parameterized
		// Problem: b was defined as a raw FruitBasket, i.e. a FruitBasket that can
		// contain Objects
		// This seems to be fine:
		b.put(new Apple());
		b.inspect();

		// declare a raw FruitBasket, instantiated with a FruitBasket of Fruit
		FruitBasket b1 = new FruitBasket<Fruit>();
		// Even if b1 was initialized with a FruitBasket of Fruit, it cannot contain
		// any Object, as FruitBasket has a bound on Fruit
		// b1.put(new Object());
		// b1.inspect();

		// Cannot declare a FruitBasket of Objects, as FruitBasket has a bound on Fruit
		// FruitBasket<Object> b4 = new FruitBasket<Object>();
		// b4.put(new Orange());
		// b4.inspect();

		// declare a FruitBasket of Fruit, instantiated with a FruitBasket of Fruit
		FruitBasket<Fruit> b2 = new FruitBasket<Fruit>();
		b2.put(new Fruit());
		b2.inspect();
		// b2 can contain only Fruits or its subtypes because of the type bound to 
		// Fruit on FruitBasket class declaration
		// b2.setElement(new Object());
		// such as Apple
		b2.put(new Apple());
		b2.inspect();
		// Take the Apple from the FruitBasket<Fruit>, cast it into an Apple
		Apple a = (Apple) b2.get();
		// Take the Apple from the FruitBasket<Fruit>, cast it into an Orange
		// this creates a ClassCastException runtime exception at runtime
		// Orange o = (Orange) b2.get();

		// create a FruitBasket of Apples
		FruitBasket<Apple> b5 = new FruitBasket<Apple>();
		// put() takes a parameter of the parameter type used in object
		// instantiation,
		// i.e. Apple. Fruit is not a kind of Apple.
		// b5.put(new Fruit());

		// Type mismatch: cannot convert from FruitBasket<Fruit> to FruitBasket<Apple>
		// The reason is NOT that Fruit is not a subtype of Apple. The reason
		// is that FruitBasket<Fruit> and FruitBasket<Apple> are unrelated.
		// FruitBasket<Apple> b3 = new Basket<Fruit>();

		// Type mismatch: cannot convert from FruitBasket<Apple> to FruitBasket<Fruit>
		// Even though Apple is a subtype of Fruit, FruitBasket<Fruit> and
		// FruitBasket<Apple> are unrelated
		// FruitBasket<Fruit> b4 = new FruitBasket<Apple>(); 

		// This creates a "FruitBasket of unknown type", which replaces E with
		// "unknown" in b5.
		FruitBasket<?> b3 = new FruitBasket<Apple>();
		// The method setElement(capture#1-of ?) in the type FruitBasket<capture#1-of
		// ?> is not applicable for the arguments (Orange)
		// setElement thus now gets a parameter of type "unknown", and "unknown"
		// and Orange are unrelated types, and "unknown" is not Object.
		// b3.setElement(new Orange());
		// b3.inspect();

		// 1. Cannot instantiate the type FruitBasket<?>
		// 2. Type mismatch: cannot convert from FruitBasket<?> to FruitBasket<Apple>
		// FruitBasket<Apple> b4 = new FruitBasket<?>();

		// create a FruitBasket of Fruits and put an Apple in it 
		FruitBasket<Fruit> b6 = new FruitBasket<Fruit>();
		b6.put(new Apple());
		// create a FruitBasket of Apples and put an Apple in it
		FruitBasket<Apple> b7 = new FruitBasket<Apple>();
		b7.put(new Apple());
		// create a BasketHandler of Baskets of Fruits and assign b6 to it
		BasketHandler<Fruit> bu1 = new BasketHandler<Fruit>(b6);
		// Compare the Basket of Fruits to the Basket of Apples
		// They are both FruitBaskets!
		System.out.println(bu1.compareBaskets(b7));
	    // Compare the Fruits that they contain. 
		// They both contain Apples.
		System.out.println(bu1.compareFruits(b7));
		// Put an Orange in the FruitBasket
		b6.put(new Orange());
		// Compare the Fruits in the FruitBaskets again. 
		// They are not the same kind.
		System.out.println(bu1.compareFruits(b7));
		// Create a BasketHandler for the FruitBasket of Apples b7
		// and transfer its Apple into the FruitBasket of Fruits b6
		BasketHandler<Apple> bu2 = new BasketHandler<Apple>(b7);
        bu2.transferFruit(b6);
	}
}