package deque;

public class ArrayDeque<Type> {

    private Type[] data;
    private int front;
    private int back;
    private int size;

    public ArrayDeque() {
        front = 0;
        back = 0;
        size = 0;
        data = (Type[]) new Object[8];
    }

    private void resize(int capacity) {
        Type[] temp = (Type[]) new Object[capacity];
        int j = 0;
        for (int i = front; i != back; i = (i + data.length + 1) % data.length, j += 1) {
            temp[j] = data[i];
        }
        front = 0;
        back = j;
        data = temp;
    }

    public void addFirst(Type item) {
        if (front == 0) {
            if (data[0] == null) {
                back = (back + data.length + 1) % data.length;
            }
        }
        data[front] = item;
        front = (front + data.length - 1) % data.length;
        size += 1;
        if ((float)size / data.length > 0.6) {
            resize((int)(data.length * 1.5));
        }
    }

    public void addLast(Type item) {
        if (back == 0) {
            if (data[0] == null) {
                front = (front + data.length - 1) % data.length;
            }
        }
        data[back] = item;
        back = (back + data.length + 1) % data.length;
        size += 1;
        if ((float)size / data.length > 0.6) {
            resize((int)(data.length * 1.5));
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = front; i != back + 1; i = (i + data.length + 1) % data.length) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public Type removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Type result = data[(front + data.length + 1) % data.length];
        data[(front + data.length + 1) % data.length] = null;
        front = (front + data.length + 1) % data.length;
        size = size - 1;
        if (data.length > 50 && (float)size / data.length < 0.25) {
            resize(size / 2);
        }
        return result;
    }

    public Type removeLast() {
        if (isEmpty()) {
            return null;
        }
        Type result = data[(back + data.length - 1) % data.length];
        data[(back + data.length - 1) % data.length] = null;
        back = (back + data.length - 1) % data.length;
        size = size - 1;
        if (data.length > 50 && (float)size / data.length < 0.25) {
            resize(size / 2);
        }
        return result;
    }

    public Type get(int index) {
        return data[(front + data.length + index + 1) % data.length];
    }
}
