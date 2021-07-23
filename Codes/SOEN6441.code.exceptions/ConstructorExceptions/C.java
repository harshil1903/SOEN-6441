
public class C {
	C(char classToThrow) throws Exception { 
		System.out.println("in Constructor C() with class to throw: " + classToThrow);
		if (classToThrow == 'C') 
			throw new Exception();
		state = "initialized";
	}
	String state = "NOT initialized";
}
