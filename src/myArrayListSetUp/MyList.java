package myArrayListSetUp;

public interface MyList {

    int size();

    void add(String o);

    void remove(String o);

    void remove(int index);

    boolean contains(String o);

    void clear();

    String get(int index);

    int capacity();

    boolean isEmpty();

}
