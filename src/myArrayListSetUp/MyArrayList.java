package myArrayListSetUp;

public class MyArrayList implements MyList {

    private Object[] myArray = new Object[4];
    private int size = 0;
    private boolean listIsEmpty = true;
    private String elements = null;

    @Override
    public int size() {
        return size++;
    }

    @Override
    public void add(String element) {
        if (listIsEmpty) {
            myArray[0] = element;
        }
        size++;
    }

    @Override
    public void remove(String element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(myArray[i])) {
                size--;
            }
        }
//        if (listIsEmpty) {
//            myArray[1] = element;
//
//        }

    }

    public Integer findIndexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (myArray[i].equals(element)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void remove(int index) {

        if(myArray[index] != findIndexOf("index")) {
            size--;
        }

    }

    @Override
    public boolean contains(String element) {
        for (int i = 0; i < size - 1; i++) {
            if (element == (myArray[i])) {
                return true;
//            if(element.equals(elements)){
//                return true;
            }
        }
       return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public int capacity() {
        return myArray.length;
    }

    @Override
    public boolean isEmpty() {
        return listIsEmpty;
    }
}
