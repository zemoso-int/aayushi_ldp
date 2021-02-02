package Assignment7;
/*
1.Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. In the base class, provide methods that are common to all Rodents,
 and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. Create an array of Rodent,
 fill it with different specific types of Rodents, and call your base-class methods to see what happens.
 Make the methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
 */
class Rodent{

    public void eat(){
        System.out.println("Rodent is eating");
    }
    public void typeOfFood(){
        System.out.println("Herbivorus");
    }
}

class Mouse extends Rodent{
    public void eat(){
        System.out.println("Mouse is eating");
    }
    public void typeOfFood(){
        System.out.println("Omnivorous");
    }

}
class Gerbill extends Rodent{
    public void eat(){
        System.out.println("Gerbill is eating");
    }
}

class Hamster extends Rodent{
    public void typeOfFood(){
        System.out.println("Omnivorous");
    }
    public void eat(){
        System.out.println("Hamster is eating");
    }
}

class TestRodent{
    public static void main(String args[]){
        Rodent rodents[]= new Rodent[3];
        rodents[0]=new Mouse();
        rodents[1]= new Gerbill();
        rodents[2]= new Hamster();

        rodents[0].eat();
        rodents[0].typeOfFood();

        rodents[1].eat();
        rodents[1].typeOfFood();

        rodents[2].eat();
        rodents[2].typeOfFood();
    }
}