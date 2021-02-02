package Assignment6.Part3_4;

/*3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.
4. Complete the previous exercise by creating objects to attach to the array of references. */

public class ConstructorTest {
    private String s;
    public ConstructorTest(String s){
        this.s=s;
        System.out.println(s);
    }

    public static void main(String[] args) {
        ConstructorTest arr[]=new ConstructorTest[5];
        for(int i=0;i<5;i++){
            arr[i]=new ConstructorTest("hello world"+i);
        }
    }

}
