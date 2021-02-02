package Assignment5;

public class Singleton {
    String string;

    static Singleton getInstance(String str) {
        Singleton s = new Singleton();
        s.string = str;
        return s;
    }

    public void getString() {
        System.out.println(string);
    }
}

