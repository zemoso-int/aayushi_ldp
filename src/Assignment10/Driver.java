package Assignment10;

public class Driver {
    public static void main(String[] args) {
        SList<Integer> list = new SList<Integer>();
        SListIterator it = list.iterator();
        it.insert(10);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        it.remove();
        it.insert(20);
        System.out.println(it.next());
        System.out.println(it.hasNext());

        SListIterator it2 = list.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        SListIterator it3 = list.iterator();
        it3.remove();

        while (it3.hasNext()) {
            System.out.println(it3.next());
        }


    }
}