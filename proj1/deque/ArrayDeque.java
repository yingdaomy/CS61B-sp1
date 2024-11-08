package deque;

public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T[] items;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = 0;
        back = 1;
        size = 0;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int index = 0;
        for (int i = (front + items.length + 1) % items.length; i != back; i = (i + items.length + 1) % items.length) {
            temp[index] = items[i];
            index = index + 1;
        }
        items = temp;
        back = index;
        front = items.length - 1;
    }

    @Override
    public void addFirst(T item) {
        items[front] = item;
        front = (front + items.length - 1) % items.length;
        size = size + 1;
        if (1.0 * size / items.length > 0.75) {
            resize(size + (int)(size * 0.9));
        }
    }

    @Override
    public void addLast(T item) {
        items[back] = item;
        back = (back + items.length + 1) % items.length;
        size = size + 1;
        if (1.0 * size / items.length > 0.75) {
            resize(size + (int)(size * 0.9));
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int index = (front + items.length + 1) % items.length;
        while (index != back) {
            System.out.print(items[index] + " ");
            index = (index + items.length + 1) % items.length;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T result = items[(front + items.length + 1) % items.length];
        items[(front + items.length + 1) % items.length] = null;
        front = (front + items.length + 1) % items.length;
        size = size - 1;
        if (1.0 * size / items.length < 0.25) {
            resize((int)(items.length * 0.7));
        }
        return result;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T result = items[(back + items.length - 1) % items.length];
        items[(back + items.length - 1) % items.length] = null;
        back = (back + items.length - 1) % items.length;
        size = size - 1;
        if (1.0 * size / items.length < 0.25) {
            resize((int)(items.length * 0.7));
        }
        return result;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }
        int i = (front + items.length + 1) % items.length;
        while (index != 0) {
            i = (i + items.length + 1) % items.length;
            index = index - 1;
        }
        return items[i];
    }
}
