import java.sql.Date;
import java.util.LinkedList;

/**
 * Generic class that defines a wrapper class around a single 
 * element of a generic type. 
 */
public class Box<T> {

    private T t; 
    
    public Box(){}
    
    public Box(T newT){ t= newT; }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
/**
 * Generic method that uses both the generic type of the class
 * it belongs to, as well as an additional generic type 
 */
    public void inspect(){
    	System.out.println("in Box::inspect()");
        System.out.println("t: " + t + ":" + t.getClass().getName());
    }
    
    public <U> U inspectAndReturnWithAdditionalType(U u){
    	System.out.println("in Box::inspectAndReturnWithAdditionalType()");
        System.out.println("t: " + t + ":" + t.getClass().getName());
        System.out.println("u: " + u + ":" + u.getClass().getName());
        return u;
    } 
    
    public void bla(Box<?> b) {
    	b.inspect();
    }
    
    public static void main(String[] args) {
        Box<Double> numberBox = new Box<Double>();
        numberBox.set(new Double(10));
        numberBox.inspect();
        String s = numberBox.inspectAndReturnWithAdditionalType("Hello world");
        System.out.println("type name of numberBox : " + numberBox.getClass().getName());

        Box<?> questionBox = new Box<Integer>(1);
        questionBox.inspect();
        System.out.println("type name of questionBox : " + questionBox.getClass().getName());
        questionBox.bla(new Box<Double>(1.0));
        questionBox.bla(new Box<String>("Hello"));
     
        // The method set(capture#13-of ?) in the type Box<capture#13-of ?> is not applicable for the arguments (Integer)
        // Problem: the set function, when Box is instantiated with type ?, is expecting "any type", which cannot be verified 
        // to be type-safe, i.e. any mutable class cannot be instantiated with ? as a type parameter. 
        //
        // questionBox.set(new Integer(1));
    }
}