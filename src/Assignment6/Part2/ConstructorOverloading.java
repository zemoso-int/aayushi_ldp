package Assignment6.Part2;

//2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.


class ConstructorOverloading {
    public ConstructorOverloading(int a){
        //calling parameterized constructor inside default constructor
        this('c');
    }
    ConstructorOverloading(char c){
        System.out.println(c);
    }
}

