package FruitBasket;
import Fruits.Fruit;


public class BasketHandler<F extends Fruit> {
	
	public FruitBasket<F> basket;
	
	public BasketHandler(FruitBasket<F> newBasket) {
		basket = newBasket;
	}
	public F getRipeFruit() {
		return basket.get();
	}
	public void putRipeFruit(F f) {
		basket.put(f);
	}
	public boolean compareBaskets(FruitBasket<?> otherBasket) {
		// this will always return true, as all FruitBaskets belong to the raw type "FruitBasket"
		System.out.println("this FruitBasket : " + this.basket.getClass().getName() );
		System.out.println("otherBasket FruitBasket : " + otherBasket.getClass().getName() );
		return (this.basket.getClass() == otherBasket.getClass()); 
	}
	public boolean compareFruits(FruitBasket<? extends Fruit> otherBasket) {
		System.out.println("this Fruit : " + this.basket.get().getClass().getName() );
		System.out.println("otherBasket Fruit : " + otherBasket.get().getClass().getName() );
		return (this.basket.get().getClass() == otherBasket.get().getClass());	
	}
	// Take a fruit from my basket and put it in another basket 
	// that can contain it, i.e. can contain a supertype of my basket
	public void transferFruit(FruitBasket<? super F> otherBasket) {
		otherBasket.put(basket.get());
	}
}
