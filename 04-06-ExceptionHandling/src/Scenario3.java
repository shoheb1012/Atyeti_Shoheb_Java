import java.io.FileNotFoundException;
import java.io.IOException;
/*
   At the time of method overriding if the super class method does
   not reporting or throwing checked exception then the overridden method of sub class
   not allowed to throw checked exception. otherwise it will generate compilation error
   but overridden method can throw Unchecked Exception.
 class Super
 {
	public void show()
	{
		System.out.println("Super class method not throwing checked Exception");
	}
}
class Sub extends Super
{
	@Override
	public void show()//throws IOException //here we can throw unchecked exception
	{
		System.out.println("Sub class method should not throw checked Exception");
	}
}


 If the super class method declare with throws keyword to throw a checked exception, then at the time of method overriding,
 sub class method may or may not use throws keyword.
 If the Overridden method is also using throws
 keyword to throw checked exception then it must be either same exception class or sub class,
 it should not be super class as well as we can't add more exceptions in the overridden method.

class Base
{
	public void show() throws FileNotFoundException
	{
		System.out.println("Super class method throws checked exception ");
	}
}
class Derived extends Base
{
	//throws is applicable but must be equal or sub class
	public void show() throws IOException
	{
		System.out.println("Sub class method ");
	}
}

 */
 abstract class  Parent
{
    abstract int sum(int a, int b) throws RuntimeException;
}
class Child extends Parent{

    @Override
    int sum(int a, int b)//throws  Exception{    // here it will gives an error beacuse parent class method throws checked
    {
        return 0;
    }
}
public class Scenario3 {

}
