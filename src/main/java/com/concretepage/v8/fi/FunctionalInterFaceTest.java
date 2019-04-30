package com.concretepage.v8.fi;


interface Interface1{
	void method1(String str);
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}


}
@FunctionalInterface
interface Interface2{
	void method2();

	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
}

class FunctionalInterFace implements Interface1, Interface2{

	@Override
	public void method1(String str) {
		System.out.println("method1 "+str);
	}


	@Override
	public void method2() {
		System.out.println(" method2 ");
	}


	public void log(String str){
		System.out.println("MyClass logging::"+str);
		//Interface1.print("abc");

	}
}


public class FunctionalInterFaceTest  {

	public static void main(String[] args) {

		FunctionalInterFace f=new FunctionalInterFace();
		f.method1("Hello");
		f.method2();
		f.log("HeLLO");

		
	}

}
