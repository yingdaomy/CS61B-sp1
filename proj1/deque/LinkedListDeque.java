package deque;

public class LinkedListDeque<Type> {

    private class LinkNode {

        private Type item;
        LinkNode next;
        LinkNode prev;

        public LinkNode(Type i, LinkNode p, LinkNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private LinkNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new LinkNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(Type item) {
        size += 1;
        LinkNode t = new LinkNode(item, sentinel, sentinel.next);
        sentinel.next.prev = t;
        sentinel.next = t;
    }

    public void addLast(Type item) {
        size += 1;
        LinkNode t = new LinkNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = t;
        sentinel.prev = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println("\n");
    }

    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        LinkNode t = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return t.item;
    }

    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        LinkNode t = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = size - 1;
        return t.item;
    }

    public Type get(int index) {
        if (index > size - 1) {
            return null;
        }
        LinkNode t = sentinel.next;
        while (index != 0) {
            t = t.next;
            index = index - 1;
        }
        return t.item;
    }

    private Type getRecursive(int index, LinkNode n) {
        if (index == 0) {
            return n.item;
        }
        return getRecursive(index - 1, n.next);
    }

    public Type getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

}
