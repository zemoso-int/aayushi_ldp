package Assignment10;

public interface SListIterator<T> {
    boolean  hasNext();
    T  next();
    void remove();
    void insert(T obj);

}