
public class D {
	D(char classToThrow) throws Exception{
		System.out.println("in Constructor D() with class to throw: " + classToThrow);
		if (classToThrow == 'D') 
			throw new Exception();
		state = "initialized";
	}
	String state = "NOT initialized"; 
}
