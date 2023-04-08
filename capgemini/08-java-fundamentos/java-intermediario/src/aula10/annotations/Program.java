package aula10.annotations;

/**
 * 
 * @author luciano
 *
 */
public class Program {

	public static void main(String[] args) {
		A a = new AA();
		a.printStr("Hello");
		
		AA aa = (AA) a;
		aa.printInt(10);
	}

}

class A {
	void printStr(String str){
		System.out.println(str);
	}
}

class AA extends A {
	@Override
	void printStr(String str) {
		super.printStr("Método de AA: " + str);
	}
	
	@Deprecated
	void printInt(int int_) {
		System.out.println(int_);
	}
}
