public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.addToEnd(3);
        arr.addToEnd(5);
        arr.addToEnd(678);
        System.out.println(arr.contains(5));
        arr.removeByValue(678);
        arr.showElements();
        arr.clear();
        arr.showElements();
    }
}

class ArrayList<E> {

    private E[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            list = (E[]) new Object[capacity];
        }
    }

    public ArrayList() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void addToEnd(E item) {
        list[size++] = item;
    }

    public void addToIndex(int index, E item) {
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public void removeByIndex(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i+1];
        }
        size--;
    }

    public void removeByValue(E value) {
        int index = -1;
        for(int i = 0;i<size;i++) {
            if(list[i].equals(value)){
                index = i;
                break;
            }
        }
        for (int i = index; i < size; i++) {
            list[i] = list[i+1];
        }
        size--;
    }

    public int indexOf(E item) {
        int index = -1;
        for(int i = 0;i<size;i++) {
            if(list[i].equals(item)){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(E x) {
        for(int i = 0;i<size;i++) {
            if(list[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index){
        return list[index];
    }

    public void clear() {
        for (int i = 0;i<size;i++) {
            list[i] = null;
        }
        size = 0;
    }

    public void showElements() {
        for(int i = 0;i<size;i++) {
            System.out.println(list[i]);
        }
    }
}