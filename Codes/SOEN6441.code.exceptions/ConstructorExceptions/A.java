
public class A extends B {
	static char classToThrow;
	C mC = new C(classToThrow);
	D mD = new D(classToThrow);
	String stateA = "NOT initialized";
	A() throws Exception {
		super(classToThrow);
		System.out.println("in Constructor A() with class to throw: " + classToThrow); 
		if (classToThrow == 'A') 
			throw new Exception();
		stateA = "initialized";
	}
}
