package Assignment7;

/*
5. Create a class with an inner class that has a non-default constructor (one that takes arguments). Create a second class with an inner class that inherits from the first inner class.
 */

class A
{
    A()
    {
        System.out.println("constructor of A:");
    }
    class B
    {   int x;
        B (int x)
        {
            this.x = x;
            System.out.println("constructor of B:"+x);
        }
    }
}
class C
{
    C()
    {
        System.out.println("constructor of C:");
    }
    class D extends A.B
    {
        D()
        {
            new A().super(5);
            System.out.println("constructor of D:");

        }
    }
}
class InnerClass
{
    public static void main(String args[])
    {
        new C().new D();
    }
}