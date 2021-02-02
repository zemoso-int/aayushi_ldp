package Assignment8;

public class Assignment8 {
    public static void main(String[] args) {

        ThrowExceptionClass e=new ThrowExceptionClass();
        try {
            e.method1(null);
            // e.method1("throw exception one");
        }
        catch (NewExceptionOne|NewExceptionTwo|NewExceptionThree exception)
        {
            System.out.println(exception.getMessage());
        }
        catch(Exception exception){
            System.out.println("Null pointer exception");
        }
        finally
        {
            System.out.println("finally block excecuted");
        }
    }

}

class ThrowExceptionClass{
    void method1(String exception) throws NewExceptionOne, NewExceptionTwo, NewExceptionThree {
        if (exception.equalsIgnoreCase("throw exception one")) {
            throw new NewExceptionOne("customized exception one");
        } else if (exception.equalsIgnoreCase("throw exception two")) {
            throw new NewExceptionTwo("customized exception two");
        } else if (exception.equalsIgnoreCase("throw exception three")) {
            throw new NewExceptionThree("customized exception three");
        }

    }
}

class NewExceptionOne extends Exception{

    NewExceptionOne(String str)
    {
        super(str);

    }

}
class NewExceptionTwo extends Exception{

    NewExceptionTwo(String str)
    {
        super(str);

    }

}
class NewExceptionThree extends Exception{

    NewExceptionThree(String str)
    {
        super(str);

    }
}
